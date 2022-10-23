package com.javasm.product.service.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.util.SqlSessionFactoryUtils;
import com.javasm.product.bean.BkProduct;
import com.javasm.product.dao.BkProductMapper;
import com.javasm.product.service.ProductService;
import com.javasm.system.bean.AdminInfo;
import com.javasm.system.dao.AdminInfoDao;
import com.javasm.system.dao.RoleInfoDao;
import com.javasm.system.dao.impl.AdminInfoDaoImpl;
import com.javasm.system.dao.impl.RoleInfoDaoImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/19-11:03
 * @Since：jdk1.8
 * @Description：
 */
public class ProductServiceImpl implements ProductService {

    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    private RoleInfoDao roleInfoDao =new RoleInfoDaoImpl();

    @Override
    public int add(BkProduct bkProduct) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BkProductMapper mapper = sqlSession.getMapper(BkProductMapper.class);
        int insert = mapper.insert(bkProduct);
        if (insert > 0) {
            sqlSession.commit();
        }
        sqlSession.close();
        return insert;


    }

    @Override
    public PageInfo<BkProduct> queryByConditionForPage(int PageSize, int nowPage, BkProduct bkProduct) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BkProductMapper mapper = sqlSession.getMapper(BkProductMapper.class);
        String _productName = "%"+bkProduct.getProductName()+"%";
        bkProduct.setProductName(_productName);
        int total = mapper.getTotal(bkProduct);
        PageInfo<BkProduct> objectPageInfo = new PageInfo<>(nowPage, PageSize, total);
        List<BkProduct> bkProducts = mapper.queryByConditionForPage(objectPageInfo, bkProduct);
        objectPageInfo.setData(bkProducts);
        return objectPageInfo;
    }

    @Override
    public List<AdminInfo> selectAllAdminForAudit() {
        List<AdminInfo> adminInfos = roleInfoDao.selectAllProductAuditAdmin();
        return adminInfos;
    }

    @Override
    public int updateProduct(BkProduct bkProduct) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BkProductMapper mapper = sqlSession.getMapper(BkProductMapper.class);
        int i = mapper.updateByPrimaryKey(bkProduct);
        if(i>0){
            sqlSession.commit();
            sqlSession.close();
            return i;
        }

        return -1;

    }

    @Override
    public PageInfo<BkProduct> queryByConditionForPage(int PageSize, int nowPage, BkProduct bkProduct, int adminId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BkProductMapper mapper = sqlSession.getMapper(BkProductMapper.class);
        String _productName = "%"+bkProduct.getProductName()+"%";
        bkProduct.setProductName(_productName);
        int total = mapper.getTotalForAudit(bkProduct,adminId);
        PageInfo<BkProduct> objectPageInfo = new PageInfo<>(nowPage, PageSize, total);
        List<BkProduct> bkProducts = mapper.queryByConditionForPageAndAudit(objectPageInfo, bkProduct,adminId);
        objectPageInfo.setData(bkProducts);
        return objectPageInfo;
    }

    @Override
    public List<BkProduct> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BkProductMapper mapper = sqlSession.getMapper(BkProductMapper.class);
        List<BkProduct> bkProducts = mapper.selectAll();
        return bkProducts;
    }
}
