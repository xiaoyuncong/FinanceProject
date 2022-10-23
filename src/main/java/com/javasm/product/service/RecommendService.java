package com.javasm.product.service;

import com.javasm.base.bean.PageInfo;
import com.javasm.product.bean.Recommend;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/20-15:00
 * @Since：jdk1.8
 * @Description：
 */
public interface RecommendService {

    /**
     * 添加推荐产品
     * @param recommend
     * @return
     */
    int add(Recommend recommend);


    /**
     * 修改推荐产品
     * @param recommend
     * @return
     */
    int update(Recommend recommend);


    /**
     * 按条件分页查询
     * @param nowPage
     * @param pageSize
     * @param productName
     * @return
     */
    PageInfo<Recommend> queryByPage(Integer nowPage,Integer pageSize,String productName);
}
