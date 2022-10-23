package com.javasm.product.service.impl;

import com.javasm.base.util.SqlSessionFactoryUtils;
import com.javasm.product.bean.ProductNet;
import com.javasm.product.dao.BkProductMapper;
import com.javasm.product.dao.ProductNetMapper;
import com.javasm.product.service.ProductNetService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/19-22:37
 * @Since：jdk1.8
 * @Description：
 */
public class ProductNetServiceImpl implements ProductNetService {

    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public int add(ProductNet productNet) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductNetMapper mapper = sqlSession.getMapper(ProductNetMapper.class);
        int insert = mapper.insert(productNet);
        if(insert>0){
            sqlSession.commit();
            sqlSession.close();
            return insert;
        }

        return -1;
    }
}
