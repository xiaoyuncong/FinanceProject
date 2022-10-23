package com.javasm.product.dao;

import com.javasm.product.bean.BkProduct;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/19-10:36
 * @Since：jdk1.8
 * @Description：
 */
public interface BkProductDao {

    /**
     * 添加产品信息
     * @param bkProduct
     * @return
     */
    int add(BkProduct bkProduct);
}
