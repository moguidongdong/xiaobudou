package com.kenneth.ex.service;

import com.kenneth.ex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public String addUser(User user) {
        String sql = "insert into t_user (id, name, age)values(" + user.getId() + "," + user.getName() + "," + user.getAge() + ");";
        int result = jdbcTemplate.update(sql);
        return result > 0 ? "success" : "fail";
    }
}
