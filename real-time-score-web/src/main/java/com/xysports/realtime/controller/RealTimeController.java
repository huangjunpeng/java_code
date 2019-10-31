package com.xysports.realtime.controller;

import com.alibaba.fastjson.JSON;
import com.xysports.realtime.domain.MatchInfo;
import com.xysports.realtime.domain.vo.MatchInfoVo;
import com.xysports.realtime.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yuxi
 * @date 2019/8/1
 */
@RestController
@RequestMapping("/real")
public class RealTimeController {

    @Autowired
    private MatchService matchService;

    /**
     * 获取有更新的信息
     * @param t
     * @return
     */
    @RequestMapping("/change")
    public String getRealTimeInfo(@RequestParam(value = "t", required = false) String t){
        Calendar cal = Calendar.getInstance();
        if(StringUtils.isEmpty(t)){
            cal.setTime(new Date());
            cal.add(Calendar.HOUR, -2);
        }else{
            cal.setTimeInMillis(Long.parseLong(t));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = sdf.format(cal.getTime());
        Timestamp timeStamp = Timestamp.valueOf(timeStr);
        List<MatchInfo> matchInfos = matchService.getRealTimeChanges(timeStamp);
        Map<String, Object> resMap = new HashMap<>(matchInfos.size());
        List<MatchInfoVo> matchInfoVos = new ArrayList<>();
        if(!CollectionUtils.isEmpty(matchInfos)){
            cal.setTime(matchInfos.get(0).getUpdateDate());
            timeStr = sdf.format(cal.getTime());
            timeStamp = Timestamp.valueOf(timeStr);
        }
        for(MatchInfo m : matchInfos){
            MatchInfoVo vo = new MatchInfoVo();
            vo.setI(m.getMatchId());
            //"3^79^3^0^2^0^8^6^2^2^1^0"
            String sb = String.valueOf(m.getStatus()) + "^" +
                    m.getTm() + "^" +
                    m.getHomeScore() + "^" +
                    m.getAwayScore() + "^" +
                    m.getHomeHalfScore() + "^" +
                    m.getAwayHalfScore() + "^" +
                    m.getHomeYellow() + "^" +
                    m.getAwayYellow() + "^" +
                    m.getHomeRed() + "^" +
                    m.getAwayRed();
            vo.setF(sb);
            matchInfoVos.add(vo);
        }
        resMap.put("ct", timeStamp.getTime());
        resMap.put("ci", matchInfoVos);
        return JSON.toJSONString(resMap);
    }

}
