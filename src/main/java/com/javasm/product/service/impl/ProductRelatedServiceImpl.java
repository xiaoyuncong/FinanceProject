package com.javasm.product.service.impl;

import com.javasm.base.util.SqlSessionFactoryUtils;
import com.javasm.product.bean.ProductRelated;
import com.javasm.product.dao.BkProductMapper;
import com.javasm.product.dao.ProductRelatedMapper;
import com.javasm.product.service.ProductRelatedService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/20-20:00
 * @Since：jdk1.8
 * @Description：
 */
public class ProductRelatedServiceImpl implements ProductRelatedService {
    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public Integer[] selectAllR(int productId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BkProductMapper mapper = sqlSession.getMapper(BkProductMapper.class);
        Integer[] ints = mapper.selectRelatedIdsByProductId(productId);

        return ints;
    }

    @Override
    public Integer[] selectAllNoR(int productId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BkProductMapper mapper = sqlSession.getMapper(BkProductMapper.class);
        Integer[] ints = mapper.selectNoRelatedIdsByProductId(productId);
        return ints;
    }

    @Override
    public int addRelated(int id, int[] rids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductRelatedMapper mapper = sqlSession.getMapper(ProductRelatedMapper.class);
        if (rids != null && rids.length>0) {
        int i = mapper.delByProductId(id);
            for (int rid : rids) {
                int i1 = mapper.insertR(rid, id);

                //新添加
                mapper.insertR(id,rid);

            }

        }

        sqlSession.commit();
        sqlSession.close();
        return 1;
    }

    @Override
    public int deleteNoRelated(int pid,int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductRelatedMapper mapper = sqlSession.getMapper(ProductRelatedMapper.class);
        if (ids != null && ids.length>0) {
            for (int id : ids) {
                int i = mapper.deleteByRIdAndPId(pid, id);

                //
                mapper.deleteByRIdAndPId(id,pid);
            }

        }

        sqlSession.commit();
        sqlSession.close();
        return 1;
    }
}
