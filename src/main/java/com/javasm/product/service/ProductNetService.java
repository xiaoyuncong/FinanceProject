package com.javasm.product.service;

import com.javasm.product.bean.ProductNet;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/19-22:36
 * @Since：jdk1.8
 * @Description：
 */
public interface ProductNetService  {

    /**
     * 添加净值
     * @param productNet
     * @return
     */
    int add(ProductNet productNet);
}
