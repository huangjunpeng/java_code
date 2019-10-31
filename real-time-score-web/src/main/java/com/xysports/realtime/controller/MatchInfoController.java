package com.xysports.realtime.controller;

import com.alibaba.fastjson.JSON;
import com.xysports.realtime.domain.MatchInfo;
import com.xysports.realtime.domain.vo.MatchInfoVo;
import com.xysports.realtime.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * match信息
 *
 * @author yuxi
 * @date 2019/8/1
 */
@RestController
@RequestMapping("/match")
public class MatchInfoController {

    @Autowired
    private MatchService matchService;

    /**
     *
     * @param d 保留
     * @return
     */
    @RequestMapping("/list")
    public String getNowMatches(@RequestParam(value = "d", required = false) String d) {

        List<MatchInfoVo> matchInfoVos = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<MatchInfo> matchInfos = matchService.getMatchNowAndLater();
        for(MatchInfo m : matchInfos){
            MatchInfoVo vo = new MatchInfoVo();
            vo.setI(m.getMatchId());
            vo.setT(sdf.format(m.getMatchDate()));
            List<String> teamList = new ArrayList<>(3);
            teamList.add(m.getLeague());
            teamList.add(m.getHome());
            teamList.add(m.getAway());
            vo.setS(teamList);
            matchInfoVos.add(vo);
        }
        return JSON.toJSONString(matchInfoVos);
    }

}
