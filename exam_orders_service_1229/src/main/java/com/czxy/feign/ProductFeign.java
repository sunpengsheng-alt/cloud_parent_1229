package com.czxy.feign;

import com.czxy.domain.Product;
import com.czxy.utils.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "productservice",path = "/product")
public interface ProductFeign {

    @GetMapping("/findByPid/{pid}")
    public BaseResult<Product> findByPid(@PathVariable("pid") Long pid);
}
