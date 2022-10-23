package com.javasm.product.dao.impl;

import com.javasm.base.util.JDBCUtils;
import com.javasm.product.bean.Remittance;
import com.javasm.product.dao.RemittanceDao;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/18-19:15
 * @Since：jdk1.8
 * @Description：
 */
public class RemittanceDaoImpl implements RemittanceDao {
    @Override
    public int add(Remittance r) {
        String sql ="insert into remittance values(null,?,?,?,?,?,?,?,?,?,?,?)";
       return JDBCUtils.update(sql,r.getBankName(),r.getBankswift(),r.getBankCode(),r.getCnaps(),r.getCollectionBankArea(),
                r.getCollectionBankCity(),r.getCollectionBankName(),r.getColletionBankAccout(),r.getAccountAddress(),
                r.getManagement(),r.getProductLineId());
    }
}
