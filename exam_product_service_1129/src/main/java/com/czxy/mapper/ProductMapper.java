package com.czxy.mapper;

import com.czxy.domain.Product;
import com.czxy.vo.ProductVo;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ProductMapper extends Mapper<Product> {

    @Select("<script>" +
            "select * from product where 1=1" +
            "<if test=\" productVo.pname != null and productVo.pname != '' \"> and pname like #{productVo.pname}</if>" +
            "<if test=\" productVo.cid != null and productVo.cid != '' \"> and cid = #{productVo.cid}</if>" +
            "</script>")
    @Results({
            @Result(property = "pid",column = "pid"),
            @Result(property = "marketPrice",column = "market_price"),
            @Result(property = "cid",column = "cid"),
            @Result(property = "category",column = "cid",one = @One(select = "com.czxy.mapper.CategoryMapper.selectByPrimaryKey")),
            @Result(property = "pid",column = "pid"),
    })
    List<Product> findAll(@Param("productVo") ProductVo productVo);
}