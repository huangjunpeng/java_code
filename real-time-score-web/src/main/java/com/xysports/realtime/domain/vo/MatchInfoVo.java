package com.xysports.realtime.domain.vo;

import java.util.List;

/**
 * @author yuxi
 * @date 2019/8/8
 */
public class MatchInfoVo {

    private Long i;
    private String t;
    private List<String> s;
    private String f;

    public Long getI() {
        return i;
    }

    public void setI(Long i) {
        this.i = i;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public List<String> getS() {
        return s;
    }

    public void setS(List<String> s) {
        this.s = s;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }
}
