package com.czxy.service.impl;

import com.czxy.feign.ProductFeign;
import com.czxy.mapper.OrderitemMapper;
import com.czxy.service.OrderitemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderitemServiceImpl implements OrderitemService{

    @Resource
    private OrderitemMapper orderitemMapper;


}
