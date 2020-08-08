package com.czxy.controller;

import com.czxy.domain.Orders;
import com.czxy.service.OrderitemService;
import com.czxy.service.OrdersService;
import com.czxy.utils.BaseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    @Resource
    private OrderitemService orderitemService;

    @PostMapping("/addorder")
    public BaseResult addorder(@RequestBody Orders orders){
        ordersService.addorder(orders);
        return BaseResult.ok("添加成功");
    }

}
