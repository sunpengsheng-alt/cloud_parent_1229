package com.czxy.service.impl;

import com.czxy.domain.Category;
import com.czxy.mapper.CategoryMapper;
import com.czxy.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllCategory() {
        return categoryMapper.selectAll();
    }
}
