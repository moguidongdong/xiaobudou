package com.mayikt.member.tony.service;

import com.mayikt.member.tony.dao.IMemberMapper;
import com.mayikt.member.tony.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {

    @Value("${mayikt.address}")
    private String address;

    @Autowired
    private IMemberMapper memberMapper;

    @Transactional
    public Map addMember(Member member) {
        int result = memberMapper.insert(member.getId(), member.getName(), member.getAge());
        Map<String, Object> map = new HashMap<>();
        map.put("address", "测试获取配置文件自定义的值:" + address);
        map.put("respsCode", "200");
        map.put("repsMag", result > 0 ? "addMember success" : "addMember fail");
        return map;
    }
}
