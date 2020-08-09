package com.ex.dao;

import com.ex.model.Score;
import com.ex.model.ScoreKey;
import com.utils.BasicMapper;

public interface ScoreMapper extends BasicMapper<Score> {
    int deleteByPrimaryKey(ScoreKey key);

    Score selectByPrimaryKey(ScoreKey key);

}