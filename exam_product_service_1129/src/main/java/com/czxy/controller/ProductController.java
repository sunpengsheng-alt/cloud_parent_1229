package com.czxy.controller;

import com.czxy.domain.Category;
import com.czxy.domain.Product;
import com.czxy.service.CategoryService;
import com.czxy.service.ProductService;
import com.czxy.utils.BaseResult;
import com.czxy.vo.ProductVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;
    @Resource
    private CategoryService categoryService;

    @GetMapping("/findAllProduct")
    public BaseResult findAllProduct(){
       List<Product> productList = productService.findAllProduct();
       return BaseResult.ok("查询成功",productList);
    }

    @GetMapping("/findAllCategory")
    public BaseResult findAllCategory(){
       List<Category> categoryList = categoryService.findAllCategory();
       return BaseResult.ok("查询成功",categoryList);
    }

    @PostMapping("/findAll")
    public BaseResult findAll(@RequestBody ProductVo productVo){
        PageInfo<Product> plist = productService.findAll(productVo);
        return BaseResult.ok("查询成功",plist);
    }

    @GetMapping("/findByPid/{pid}")
    public BaseResult<Product> findByPid(@PathVariable("pid") Long pid){
        Product product = productService.findByPid(pid);
        return BaseResult.ok("查询成功",product);
    }

    @PutMapping("/update")
    public BaseResult update(@RequestBody Product product){
        productService.update(product);
        return BaseResult.ok("修改成功");
    }

    @DeleteMapping("/deleteAll/{ids}")
    public BaseResult deleteAll(@PathVariable("ids") String ids){
        productService.deleteAll(ids);
        return BaseResult.ok("删除成功");
    }
}
