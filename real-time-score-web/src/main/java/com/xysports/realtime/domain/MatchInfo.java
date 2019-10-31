package com.xysports.realtime.domain;

import java.util.Date;

/**
 * @author yuxi
 * @date 2019/8/1
 */
public class MatchInfo {

    private Long matchId;
    private Date matchDate;
    private Long status;
    private Long tm;
    private String league;
    private String home;
    private String away;
    private Long homeScore;
    private Long awayScore;
    private Long homeHalfScore;
    private Long awayHalfScore;
    private Long homeYellow;
    private Long awayYellow;
    private Long homeRed;
    private Long awayRed;
    private Date updateDate;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getTm() {
        return tm;
    }

    public void setTm(Long tm) {
        this.tm = tm;
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

    public Long getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Long homeScore) {
        this.homeScore = homeScore;
    }

    public Long getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Long awayScore) {
        this.awayScore = awayScore;
    }

    public Long getHomeHalfScore() {
        return homeHalfScore;
    }

    public void setHomeHalfScore(Long homeHalfScore) {
        this.homeHalfScore = homeHalfScore;
    }

    public Long getAwayHalfScore() {
        return awayHalfScore;
    }

    public void setAwayHalfScore(Long awayHalfScore) {
        this.awayHalfScore = awayHalfScore;
    }

    public Long getHomeYellow() {
        return homeYellow;
    }

    public void setHomeYellow(Long homeYellow) {
        this.homeYellow = homeYellow;
    }

    public Long getAwayYellow() {
        return awayYellow;
    }

    public void setAwayYellow(Long awayYellow) {
        this.awayYellow = awayYellow;
    }

    public Long getHomeRed() {
        return homeRed;
    }

    public void setHomeRed(Long homeRed) {
        this.homeRed = homeRed;
    }

    public Long getAwayRed() {
        return awayRed;
    }

    public void setAwayRed(Long awayRed) {
        this.awayRed = awayRed;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
