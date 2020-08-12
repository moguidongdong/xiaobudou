package com.mayikt.order.tony.service;

import com.mayikt.order.tony.dao.IOrderMapper;
import com.mayikt.order.tony.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private IOrderMapper orderMapper;

    @Transactional
    public Map addOrder(Order order) {
        int result = orderMapper.insert(order.getId(), order.getName(), order.getAge());
        Map<String, Object> map = new HashMap<>();
        map.put("respsCode", "200");
        map.put("repsMag", result > 0 ? "addMember success" : "addMember fail");
        return map;
    }

}
