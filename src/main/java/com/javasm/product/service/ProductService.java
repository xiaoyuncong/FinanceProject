package com.javasm.product.service;

import com.javasm.base.bean.PageInfo;
import com.javasm.product.bean.BkProduct;
import com.javasm.system.bean.AdminInfo;

import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/19-11:02
 * @Since：jdk1.8
 * @Description：
 */
public interface ProductService {

    /**
     * 添加产品
     * @param bkProduct
     * @return
     */
    int add(BkProduct bkProduct);


    /**
     * 按条件分页查询
     * @param PageSize
     * @param nowPage
     * @param bkProduct
     * @return
     */
    PageInfo<BkProduct> queryByConditionForPage(int PageSize,int nowPage,BkProduct bkProduct);


    List<AdminInfo> selectAllAdminForAudit();

    /**
     *
     * @param bkProduct
     * @return
     */
    int updateProduct(BkProduct bkProduct);


    PageInfo<BkProduct> queryByConditionForPage(int PageSize,int nowPage,BkProduct bkProduct,int adminId);


    /**
     * 查询所有产品
     * @return
     */
    List<BkProduct> selectAll();



}
