function timespace(begin) {
    var startTime = new Date(begin); // 开始时间
    var endTime = new Date(); // 结束时间
    var usedTime = endTime - startTime; // 相差的毫秒数
    return Math.round(usedTime/1000/60);
}

function color16(){//十六进制颜色随机
    var r = Math.floor(Math.random()*256);
    var g = Math.floor(Math.random()*256);
    var b = Math.floor(Math.random()*256);
    var color = '#'+r.toString(16)+g.toString(16)+b.toString(16);
    return color;
}

var objMap = new Object();
var statistics = ['得分', '上半得分', '黄牌', '红牌'];

/*初始化比分列表*/
function init_score() {
    $.ajaxSettings.async = false;

    $.get(url + '/match/list?d=0 ', function (data, status) {
        if (status != 'success') {
            $('div.data-null').removeClass('hide');
        } else {
            score = $.parseJSON(data);
            if (score != null && score.length !=0) {
                $('div.data-null').addClass('hide');
                var str = '';
                for (var i = 0; i < score.length; i++) {
                    str += '<tr data-id="' + score[i].i + '">';

                    // 复选框
                    str += '<th class="lab-check" width="2%">' +
                                '<form class="layui-form" action="">' +
                                '<input type="checkbox" name="check[]" lay-skin="primary" lay-filter="oneChoose">' +
                                '</form></th>';

                    // 赛事
                    var color = '';
                    if (objMap[score[i].i]) {
                        color = objMap[score[i].i]
                    } else {
                        color = color16();
                        objMap[score[i].i] = color;
                    }
                    str += '<th width="9%" bgcolor="'+ color +'">' + score[i].s[0] + '</th>';
                    // 时间
                    str += '<th width="8%">' + score[i].t + '</th>';
                    // 状态
                    str += '<th width="6%"><span>' + timespace(score[i].t) + '</span><img src="images/in.gif" border="0"></th>';
                    //比赛球队
                    str += '<th width="14%">' + score[i].s[1] + '</th>';

                    //比分
                    str += '<th width="6%" class="score"><span>0-0';
                    str += '</span><div class="score_table">';
                    str += '<table width="380" class="evt_table" bgcolor="#E1E1E1" cellpadding="0" cellspacing="1" border="0">';
                    str += '<tr><td height=20 colspan=3 bgcolor=#666699 align=center><font color=white><b>初盘参考</b></font></td></tr>';
                    str += '<tr bgcolor=#D5F2B7 align=center><td width=12% bgcolor=#CCE8B5>时间</td>' +
                        '<td height=20 width=44%><font color=#006600><b>'+score[i].s[1]+'</b></font></td>' +
                        '<td width=44%><font color=#006600><b>'+score[i].s[2]+'</b></font></td></tr>';
                    str += '</table>';

                    str += '<table width="380" class="evt_table" bgcolor="#E1E1E1" cellpadding="0" cellspacing="1" border="0">';
                    str += '<tr><td height=20 colspan=3 bgcolor=ghostwhite align=center><font color=#006600><b>技术统计</b></font></td></tr>';
                    for (var j = 0; j < statistics.length; j++) {
                        str += '<tr bgcolor=#D5F2B7 align=center>' +
                            '<td height=20 width=42%><font color=#006600><b>0</b></font></td>' +
                            '<td width=16% bgcolor=#CCE8B5>' + statistics[j] + '</td>'+
                            '<td width=42%><font color=#006600><b>0</b></font></td>' +
                            '</tr>';
                    }

                    str += '</table></div></th>';

                    // 比赛球队
                    str += '<th width="14%">' + score[i].s[2] + '</th>';

                    // 半场
                    str += '<th width="6%"><span>0-0</span></th>';

                    // 推荐
                    var hot = true;
                    if (hot)
                        str += '<th width="6%"><span><img src="images/hot.gif" border="0"></span></th>';
                    else
                        str += '<th width="6%"></th>';
                    str += '</tr>'
                }
                $(".total_count").text(score.length)
                $('#list>tbody').html(str);
            } else {
                $('div.data-null').removeClass('hide');
            }
        }
    });

    $.ajaxSettings.async = true;
}

function realTimeScore() {

    var ct = sessionStorage.getItem('score-ct');
    var change_url = url + '/real/change?'
    if (ct != null) {
        change_url += 't=' + ct;
    }
    $.get(change_url, function (data, status) {
        if (status == 'success') {
            var realtimescore = $.parseJSON(data);
            if (realtimescore != null) {
                sessionStorage.setItem('score-ct', realtimescore.ct);
                if (realtimescore.ci.length > 0) {
                    for (var i = 0; i < realtimescore.ci.length; i++) {
                        var ci = realtimescore.ci[i];
                        var divd = $("tr[data-id='"+ ci.i + "']");
                        var scores = ci.f.split('^');
                        divd.children().eq(3).find('span').eq(0).text(scores[1]);
                        divd.children().eq(5).find('span').eq(0).text(scores[2] + '-' + scores[3]);
                        divd.children().eq(7).find('span').eq(0).text(scores[4] + '-' + scores[5]);

                        // 1 23   2 45  3 67 4 89

                        var trs = divd.children().eq(5).find('table').eq(1).find('tr');
                        for (var j = 1; j < 5; j++) {
                            var bs = trs.eq(j).find('b');
                            bs.eq(0).text(scores[j*2]);
                            bs.eq(1).text(scores[j*2+1]);
                        }


                    }
                }
            }
        }
    });
}

$(function () {

    /*初始化比分列表*/
    init_score();
    realTimeScore();

    /*设置复选框按钮*/
    layui.use('form', function(){
        var form = layui.form;

        //全选
        form.on('checkbox(allChoose)', function (data) {
            $("input[name='check[]']").each(function () {
                this.checked = data.elem.checked;
            });

            $(".checkboxAll").prop("checked",data.elem.checked);

            form.render('checkbox');
        });

        // layui复选框
        form.on('checkbox(oneChoose)', function (data) {
            // 选中数量
            var i = 0;
            // 总数量
            var j = 0;

            // 变量复选框
            $("input[name='check[]']").each(function () {
                if( this.checked === true ) {
                    i++;
                }
                j++;
            });

            // 判断是全选
            if(i == j) {
                $(".checkboxAll").prop("checked",true);
                form.render('checkbox');
            } else {
                $(".checkboxAll").removeAttr("checked");
                form.render('checkbox');
            }
        });
    });


    // 显示全部
    $('.display_all').click(function () {
        $('.tbody-item tr').each(function(){
            $(this).show();
        });
        $(".hide_count").text(0);
    });

    // 保留选中
    $('.retain_select').click(function () {
        var hide_count = 0;
        // 变量复选框
        $("input[name='check[]']").each(function () {
            if(this.checked === true) {
                $(this).parent().parent().parent().show();
            } else {
                $(this).parent().parent().parent().hide();
                ++hide_count;
            }
        });
        $(".hide_count").text(hide_count);
    });

    // 隐藏选中
    $('.hide_select').click(function () {
        var hide_count = 0;
        // 变量复选框
        $("input[name='check[]']").each(function () {
            if(this.checked === true) {
                $(this).parent().parent().parent().hide();
                ++hide_count;
            } else {
                $(this).parent().parent().parent().show();
            }
        });
        $(".hide_count").text(hide_count);
    });



    // 定时器
    setInterval(function () {
        realTimeScore();
    }, 20 * 1000);
})


/*添加事件*/
$(document).ready(function () {
    /*判断表头是否在可视区*/
    $(document).scroll(function(){
        if ($('.thead-item').offset().top < $(window).scrollTop()) {
            /*alert("不在可视区");*/
            $('.tob_thead').removeClass('hide');
        } else if (($('.thead-item').offset().top + $(window).height()) > $(window).scrollTop()) {
           /* alert("可视区");*/
            $('.tob_thead').addClass('hide');
        }
    });
});


