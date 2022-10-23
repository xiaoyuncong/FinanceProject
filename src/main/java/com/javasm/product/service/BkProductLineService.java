package com.javasm.product.service;

import com.javasm.base.bean.PageInfo;
import com.javasm.product.bean.BkProductLine;
import com.javasm.product.bean.Remittance;

import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/18-14:36
 * @Since：jdk1.8
 * @Description：
 */
public interface BkProductLineService {

    /**
     * 添加产品系列
     * @param bkProductLine
     * @return
     */
    int add(BkProductLine bkProductLine);


    /**
     * 按条件分页查询
     * @param nowPage
     * @param pageSize
     * @param pName
     * @return
     */
    PageInfo<BkProductLine> queryByConditionForPage(String nowPage,String pageSize,String pName);


    /**
     * 添加汇款信息
     * @param remittance
     * @return
     */
    int addRemittance(Remittance remittance);


    /**
     * 修改产品系列
     * @param bkProductLine
     * @return
     */
    int updateById(BkProductLine bkProductLine);


    /**
     * 查询所有
     * @return
     */
    List<BkProductLine> selectAll();
}
