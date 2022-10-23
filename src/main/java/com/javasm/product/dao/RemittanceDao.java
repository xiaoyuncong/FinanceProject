package com.javasm.product.dao;

import com.javasm.product.bean.Remittance;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/18-19:14
 * @Since：jdk1.8
 * @Description：
 */
public interface RemittanceDao {

    /**
     * 添加汇款信息
     * @param remittance
     * @return
     */
    int add(Remittance remittance);
}
