package com.javasm.product.dao;

import com.javasm.product.bean.ProductRelated;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductRelatedMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_related
     *
     * @mbggenerated Thu Oct 20 19:50:23 CST 2022
     */
    int insert(ProductRelated record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_related
     *
     * @mbggenerated Thu Oct 20 19:50:23 CST 2022
     */
    List<ProductRelated> selectAll();


    int delByProductId(@Param("id") Integer productId);

    int insertR(@Param("rId") int rId,@Param("id") int id);


    int deleteByRIdAndPId(@Param("pid") int pid,@Param("rid") int id);
}