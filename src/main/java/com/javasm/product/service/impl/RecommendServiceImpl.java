package com.javasm.product.service.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.util.SqlSessionFactoryUtils;
import com.javasm.product.bean.Recommend;
import com.javasm.product.dao.RecommendMapper;
import com.javasm.product.service.RecommendService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/20-15:01
 * @Since：jdk1.8
 * @Description：
 */
public class RecommendServiceImpl implements RecommendService {

    private static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public int add(Recommend recommend) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RecommendMapper mapper = sqlSession.getMapper(RecommendMapper.class);
        int insert = mapper.insert(recommend);
        if(insert>0){
            sqlSession.commit();
        }
        sqlSession.close();
        return insert;

    }

    @Override
    public int update(Recommend recommend) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RecommendMapper mapper = sqlSession.getMapper(RecommendMapper.class);
        int i = mapper.updateByPrimaryKey(recommend);
        if(i>0){
            sqlSession.commit();
        }
        sqlSession.close();
        return i;
    }

    @Override
    public PageInfo<Recommend> queryByPage(Integer nowPage, Integer pageSize, String productName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RecommendMapper mapper = sqlSession.getMapper(RecommendMapper.class);
        int total = mapper.getTotal(productName);
        PageInfo<Recommend> pageInfo = new PageInfo<>(nowPage, pageSize, total);
        List<Recommend> recommends = mapper.queryByConditionForPage(pageInfo, productName);

        pageInfo.setData(recommends);
        return pageInfo;
    }
}
