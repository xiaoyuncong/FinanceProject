package com.javasm.product.dao;

import com.javasm.base.bean.PageInfo;
import com.javasm.product.bean.BkProductLine;

import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/18-14:35
 * @Since：jdk1.8
 * @Description：
 */
public interface BkProductLineDao {


    /**
     * 添加产品系列
     * @param bkProductLine
     * @return
     */
    int addProductLine(BkProductLine bkProductLine);

    /**
     * 按条件分页查询
     * @param pageInfo
     * @param productLineName
     * @return
     */
    List<BkProductLine> selectByConditionForPage(PageInfo<BkProductLine> pageInfo,String productLineName);


    /**
     * 得到总记录数
     * @param productLineName
     * @return
     */
    int getTotal(String productLineName);


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
