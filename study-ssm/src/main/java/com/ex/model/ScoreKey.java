package com.ex.model;

public class ScoreKey {
    private String sid;

    private String cid;

    public ScoreKey(String sid, String cid) {
        this.sid = sid;
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public String getCid() {
        return cid;
    }
}