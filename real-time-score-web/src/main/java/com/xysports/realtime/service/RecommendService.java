package com.xysports.realtime.service;

import com.xysports.realtime.dao.RealTimeRecInfoDao;
import com.xysports.realtime.domain.RealTimeRecInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuxi
 * @date 2019/8/9
 */
@Service
public class RecommendService {

    @Autowired
    private RealTimeRecInfoDao realTimeRecInfoDao;

    public List<RealTimeRecInfo> getRealTimeRecommend(){
        return realTimeRecInfoDao.getRealTimeRecommend();
    }

}
