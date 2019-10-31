package com.xysports.realtime.domain;

/**
 * @author yuxi
 * @date 2019/8/1
 */
public class StatisticInfo {

    private Long matchId;
    private String league;
    private String home;
    private String away;
    private Long tenseTm;
    private Long tenseGoal;
    private Long totalGoal;
    private Float recommend;
    private Long result;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public Long getTenseTm() {
        return tenseTm;
    }

    public void setTenseTm(Long tenseTm) {
        this.tenseTm = tenseTm;
    }

    public Long getTenseGoal() {
        return tenseGoal;
    }

    public void setTenseGoal(Long tenseGoal) {
        this.tenseGoal = tenseGoal;
    }

    public Long getTotalGoal() {
        return totalGoal;
    }

    public void setTotalGoal(Long totalGoal) {
        this.totalGoal = totalGoal;
    }

    public Float getRecommend() {
        return recommend;
    }

    public void setRecommend(Float recommend) {
        this.recommend = recommend;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}
