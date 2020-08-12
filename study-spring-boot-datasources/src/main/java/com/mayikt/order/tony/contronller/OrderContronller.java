package com.mayikt.order.tony.contronller;

import com.mayikt.order.tony.entity.Order;
import com.mayikt.order.tony.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderContronller {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/addOrder")
    @ResponseBody
    public Map addOrder(Order order) {
        return orderService.addOrder(order);
    }
}
