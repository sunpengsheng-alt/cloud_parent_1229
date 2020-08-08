package com.czxy.service;

import com.czxy.domain.Product;
import com.czxy.vo.ProductVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService{


    PageInfo<Product> findAll(ProductVo productVo);

    Product findByPid(Long pid);

    void update(Product product);

    void deleteAll(String ids);

    List<Product> findAllProduct();
}
