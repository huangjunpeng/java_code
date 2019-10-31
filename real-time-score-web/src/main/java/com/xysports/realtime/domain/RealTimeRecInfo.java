package com.xysports.realtime.domain;

/**
 * @author yuxi
 * @date 2019/8/8
 */
public class RealTimeRecInfo {

    private Long matchId;
    private Long recommendTm;
    private Long homeGoalPoint;
    private Long awayGoalPoint;
    private Float recommend;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getRecommendTm() {
        return recommendTm;
    }

    public void setRecommendTm(Long recommendTm) {
        this.recommendTm = recommendTm;
    }

    public Long getHomeGoalPoint() {
        return homeGoalPoint;
    }

    public void setHomeGoalPoint(Long homeGoalPoint) {
        this.homeGoalPoint = homeGoalPoint;
    }

    public Long getAwayGoalPoint() {
        return awayGoalPoint;
    }

    public void setAwayGoalPoint(Long awayGoalPoint) {
        this.awayGoalPoint = awayGoalPoint;
    }

    public Float getRecommend() {
        return recommend;
    }

    public void setRecommend(Float recommend) {
        this.recommend = recommend;
    }
}
