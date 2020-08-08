package com.czxy.service.impl;

import com.czxy.domain.Orderitem;
import com.czxy.domain.Orders;
import com.czxy.domain.Product;
import com.czxy.feign.ProductFeign;
import com.czxy.mapper.OrderitemMapper;
import com.czxy.mapper.OrdersMapper;
import com.czxy.service.OrdersService;
import com.czxy.utils.BaseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class OrdersServiceImpl implements OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private ProductFeign productFeign;

    @Resource
    private OrderitemMapper orderitemMapper;
    @Override
    public void addorder(Orders orders) {
        ordersMapper.insertSelective(orders);
        for (Long pid : orders.getPlist()) {
            BaseResult baseResult = productFeign.findByPid(pid);
            System.out.println(baseResult.getData());
            Product data = (Product) baseResult.getData();
            Orderitem orderitem = new Orderitem(null, 1, data.getMarketPrice(), pid, orders.getOid(), data.getPname());
            orderitemMapper.insertSelective(orderitem);
        }
    }
}
