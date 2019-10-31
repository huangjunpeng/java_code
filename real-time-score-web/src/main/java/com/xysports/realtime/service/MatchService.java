package com.xysports.realtime.service;

import com.xysports.realtime.dao.MatchInfoDao;
import com.xysports.realtime.domain.MatchInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author yuxi
 * @date 2019/8/8
 */
@Service
public class MatchService {

    @Autowired
    private MatchInfoDao matchInfoDao;

    public List<MatchInfo> getMatchNowAndLater(){
        return matchInfoDao.findNowAndLater();
    }

    public List<MatchInfo> getRealTimeChanges(Timestamp start){
        return matchInfoDao.findRefreshdInfos(start);
    }

}
