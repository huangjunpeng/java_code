package com.xysports.realtime.dao;

import com.xysports.realtime.domain.MatchInfo;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author yuxi
 * @date 2019/8/1
 */
@Mapper
public interface MatchInfoDao {


    /**
     * 当前时间及之后的
     * @return
     */
    @Select("SELECT match_id, match_date, league, home, away FROM match_info " +
            "WHERE match_date > DATE_SUB(NOW(), interval '04:00:00' hour_second) ORDER BY match_date")
    @Results({
            @Result(property = "matchId", column = "match_id"),
            @Result(property = "matchDate", column = "match_date"),
            @Result(property = "tm", column = "tm"),
            @Result(property = "status", column = "status"),
            @Result(property = "league", column = "league"),
            @Result(property = "home", column = "home"),
            @Result(property = "away", column = "away"),
            @Result(property = "homeScore", column = "home_score"),
            @Result(property = "awayScore", column = "away_score"),
            @Result(property = "homeHalfScore", column = "home_half"),
            @Result(property = "awayHalfScore", column = "away_half"),
            @Result(property = "homeYellow", column = "home_yellow"),
            @Result(property = "awayYellow", column = "away_yellow"),
            @Result(property = "homeRed", column = "home_red"),
            @Result(property = "awayRed", column = "away_red"),
            @Result(property = "updateDate", column = "update_date")
    })
    List<MatchInfo> findNowAndLater();

    @Select("SELECT * FROM match_info WHERE update_date >= #{start} ORDER BY update_date DESC")
    @Results({
            @Result(property = "matchId", column = "match_id"),
            @Result(property = "matchDate", column = "match_date"),
            @Result(property = "tm", column = "tm"),
            @Result(property = "status", column = "status"),
            @Result(property = "league", column = "league"),
            @Result(property = "home", column = "home"),
            @Result(property = "away", column = "away"),
            @Result(property = "homeScore", column = "home_score"),
            @Result(property = "awayScore", column = "away_score"),
            @Result(property = "homeHalfScore", column = "home_half"),
            @Result(property = "awayHalfScore", column = "away_half"),
            @Result(property = "homeYellow", column = "home_yellow"),
            @Result(property = "awayYellow", column = "away_yellow"),
            @Result(property = "homeRed", column = "home_red"),
            @Result(property = "awayRed", column = "away_red"),
            @Result(property = "updateDate", column = "update_date")
    })
    List<MatchInfo> findRefreshdInfos(@Param("start") Timestamp start);
}
