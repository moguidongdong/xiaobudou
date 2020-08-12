package com.mayikt.datasources.controller;

import com.mayikt.datasources.service.DataSourcesService;
import com.mayikt.member.tony.dao.IMemberMapper;
import com.mayikt.member.tony.entity.Member;
import com.mayikt.member.tony.service.MemberService;
import com.mayikt.order.tony.dao.IOrderMapper;
import com.mayikt.order.tony.entity.Order;
import com.mayikt.order.tony.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DataSourcesController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DataSourcesService dataSourcesService;


    @RequestMapping("/addMember2")
    public Map addMember2(Member member) {
        return memberService.addMember(member);
    }

    @RequestMapping("/addOrder2")
    public Map addOrder2(Order order) {
        return orderService.addOrder(order);
    }

    @RequestMapping("/addMemberAndOrder")
    public Map addMemberAndOrder(Map<String, Object> params) {
        return dataSourcesService.addMemberAndOrder(params);
    }

}
