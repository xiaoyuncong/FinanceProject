package com.javasm.product.dao.impl;

import com.javasm.base.util.JDBCUtils;
import com.javasm.product.bean.BkProduct;
import com.javasm.product.dao.BkProductDao;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/19-10:37
 * @Since：jdk1.8
 * @Description：
 */

public class BkProductDaoImpl implements BkProductDao {

    //没写完
    @Override
    public int add(BkProduct p) {
        String sql ="insert into values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return JDBCUtils.update(sql,p.getProductName(),p.getProductLineId(),p.getProductTypeId(),
                p.getManageOrgnazition(),p.getOpenTime(),p.getCurrencyType(),p.getAnnualYield(),
                p.getAuditState(),p.getAdminId(),p.getSubscriptionCycle(),p.getFundManageRates());
    }
}
