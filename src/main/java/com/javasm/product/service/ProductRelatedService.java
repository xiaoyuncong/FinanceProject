package com.javasm.product.service;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/20-19:59
 * @Since：jdk1.8
 * @Description：
 */
public interface ProductRelatedService {


    Integer[] selectAllR(int productId);


    Integer[] selectAllNoR(int productId);


    /**
     * 添加关联
     * @param id
     * @param rids
     * @return
     */
    int addRelated(int id,int[] rids);


    /**
     * 删除选择未关联的
     * @return
     */
    int deleteNoRelated(int pid,int[] ids);
}
