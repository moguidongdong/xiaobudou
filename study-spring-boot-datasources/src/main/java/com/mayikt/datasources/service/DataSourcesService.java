package com.mayikt.datasources.service;

import com.mayikt.member.tony.entity.Member;
import com.mayikt.member.tony.service.MemberService;
import com.mayikt.order.tony.entity.Order;
import com.mayikt.order.tony.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataSourcesService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private OrderService orderService;

    @Transactional
    public Map addMemberAndOrder(Map<String, Object> params) {
        Map<String, String> map = new HashMap<>();
        Map addMemberResult = memberService.addMember((Member) params.get("member"));
        Map addOrderResult = orderService.addOrder((Order) params.get("order"));
        map.put("respsCode", "200");
        map.put("repsMag1", addMemberResult.get("repsMag").toString());
        map.put("repsMag2", addOrderResult.get("repsMag").toString());
        return map;
    }

}
