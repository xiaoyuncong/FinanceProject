package com.javasm.product.service.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.util.DataConvert;
import com.javasm.product.bean.BkProductLine;
import com.javasm.product.bean.Remittance;
import com.javasm.product.dao.BkProductLineDao;
import com.javasm.product.dao.RemittanceDao;
import com.javasm.product.dao.impl.BkProductLineDaoImpl;
import com.javasm.product.dao.impl.RemittanceDaoImpl;
import com.javasm.product.service.BkProductLineService;

import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/18-15:53
 * @Since：jdk1.8
 * @Description：
 */
public class BkProductLineServiceImpl implements BkProductLineService {


    private BkProductLineDao bkProductLineDao =new BkProductLineDaoImpl();

    private RemittanceDao remittanceDao =new RemittanceDaoImpl();

    @Override
    public int add(BkProductLine bkProductLine) {
        int i = bkProductLineDao.addProductLine(bkProductLine);
        return i;
    }

    @Override
    public PageInfo<BkProductLine> queryByConditionForPage(String nowPage, String pageSize, String pName) {
        int total = bkProductLineDao.getTotal(pName);
        Integer nPage = DataConvert.stringConvertInteger(nowPage);
        Integer pageS = DataConvert.stringConvertInteger(pageSize);
        PageInfo<BkProductLine> objectPageInfo = new PageInfo<>(nPage,pageS,total);

        List<BkProductLine> bkProductLines = bkProductLineDao.selectByConditionForPage(objectPageInfo, pName);

        objectPageInfo.setData(bkProductLines);

        return objectPageInfo;

    }

    @Override
    public int addRemittance(Remittance remittance) {
        int add = remittanceDao.add(remittance);
        return add;
    }

    @Override
    public int updateById(BkProductLine bkProductLine) {
        int i = bkProductLineDao.updateById(bkProductLine);
        return i;
    }

    @Override
    public List<BkProductLine> selectAll() {
        List<BkProductLine> bkProductLines = bkProductLineDao.selectAll();
        return bkProductLines;
    }
}
