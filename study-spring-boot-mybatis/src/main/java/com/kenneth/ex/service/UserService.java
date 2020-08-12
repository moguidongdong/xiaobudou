package com.kenneth.ex.service;

import com.kenneth.ex.dao.UserMapper;
import com.kenneth.ex.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public Map<String, Object> findById(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userMapper.findById(id);
        map.put("data", user);
        map.put("respCode", 200);
        map.put("respMsg", "success");
        return map;
    }

    @Transactional
    public Map<String, Object> insert(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(user)) {
            Integer id = user.getId();
            String name = user.getName();
            Integer age = user.getAge();
            int rusult = userMapper.insert(id, name, age);
            map.put("data", rusult > 0 ? "insert successfull!" : "insert failed!");
        }
        map.put("respCode", 200);
        map.put("respMsg", "success");
        return map;
    }
}
