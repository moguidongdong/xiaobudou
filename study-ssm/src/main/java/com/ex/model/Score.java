package com.ex.model;

public class Score extends ScoreKey {
    private Integer score;

    public Score(String sid, String cid, Integer score) {
        super(sid, cid);
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }
}