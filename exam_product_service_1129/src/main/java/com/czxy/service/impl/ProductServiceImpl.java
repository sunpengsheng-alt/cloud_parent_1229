package com.czxy.service.impl;

import com.czxy.domain.Product;
import com.czxy.mapper.ProductMapper;
import com.czxy.service.ProductService;
import com.czxy.vo.ProductVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    private ProductMapper productMapper;

    @Override
    public PageInfo<Product> findAll(ProductVo productVo) {
        PageHelper.startPage(productVo.getPageNum(),productVo.getPageSize());
        if (productVo.getPname() != null && productVo.getPname() != ""){
            productVo.setPname("%"+productVo.getPname()+"%");
        }
        List<Product> plist = productMapper.findAll(productVo);
        return new PageInfo<>(plist);
    }

    @Override
    public Product findByPid(Long pid) {
        Product product = productMapper.selectByPrimaryKey(pid);
        return product;
    }

    @Override
    public void update(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public void deleteAll(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            productMapper.deleteByPrimaryKey(s);
        }
    }

    @Override
    public List<Product> findAllProduct() {
        return productMapper.selectAll();
    }
}
