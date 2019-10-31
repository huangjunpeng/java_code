package com.xysports.realtime.dao;

import com.xysports.realtime.domain.RealTimeRecInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yuxi
 * @date 2019/8/1
 */
@Mapper
public interface RealTimeRecInfoDao {
    @Results({
            @Result(property = "matchId", column = "match_id"),
            @Result(property = "recommendTm", column = "recommend_tm"),
            @Result(property = "homeGoalPoint", column = "home_goal_point"),
            @Result(property = "awayGoalPoint", column = "away_goal_point"),
            @Result(property = "recommend", column = "recommend")
    })

    /**
     * 获取当前所有
     * @return
     */
    @Select("SELECT rec.match_id, rec.recommend_tm, rec.home_goal_point, rec.away_goal_point, rec.recommend " +
            "FROM recommend rec LEFT JOIN match_info mi " +
            "ON rec.match_id=mi.match_id WHERE mi.match_date > DATE_SUB(NOW(), interval '03:00:00' hour_second) " +
            "ORDER BY mi.match_date")
    List<RealTimeRecInfo> getRealTimeRecommend();
}
