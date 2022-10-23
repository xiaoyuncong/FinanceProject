package com.javasm.product.dao.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.util.JDBCUtils;
import com.javasm.product.bean.BkProductLine;
import com.javasm.product.dao.BkProductLineDao;

import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/18-15:00
 * @Since：jdk1.8
 * @Description：
 */
public class BkProductLineDaoImpl implements BkProductLineDao {
    @Override
    public int addProductLine(BkProductLine bpl) {
        String sql = "insert into bk_product_line values(null,?,?,?,?,null)";
       return JDBCUtils.update(sql,bpl.getProductLineQudao(),bpl.getProductLineType(),bpl.getProductLineChineseName(),
                bpl.getProductLineEnglishName());
    }

    @Override
    public List<BkProductLine> selectByConditionForPage(PageInfo<BkProductLine> pageInfo, String productLineName) {
        String sql ="select bpl.product_line_qudao productLineQudao,bpl.product_line_type productLineType, bpl.product_line_id productLineId,product_line_chinese_name productLineChineseName,product_line_english_name productLineEnglishName," + "r.collection_bank_name collectionBankName " +
                "from bk_product_line bpl LEFT JOIN remittance r on bpl.product_line_id = r.product_line_id where 1=1";
        if(productLineName!=null && !productLineName.equals("")){
            sql+=" and bpl.product_line_chinese_name like '%" +productLineName+ "%'";
        }

        sql+=" limit ?,?";
       return JDBCUtils.query(sql,BkProductLine.class,pageInfo.getStartIndex(),pageInfo.getPageSize());
    }

    @Override
    public int getTotal(String productLineName) {
        String sql ="select count(*)"+
                "from bk_product_line bpl LEFT JOIN remittance r on bpl.product_line_id = r.product_line_id where 1=1";
        if(productLineName!=null && !productLineName.equals("")){
            sql+=" and bpl.product_line_chinese_name like '%" +productLineName+ "%'";
        }
       return JDBCUtils.count(sql);
    }

    @Override
    public int updateById(BkProductLine b) {
        String sql ="update bk_product_line set product_line_qudao =?,product_line_type=?," +
                "product_line_chinese_name=?,product_line_english_name=? where product_line_id=? ";
       return JDBCUtils.update(sql,b.getProductLineQudao(),b.getProductLineType(),b.getProductLineChineseName(),
                b.getProductLineEnglishName(),b.getProductLineId());
    }

    @Override
    public List<BkProductLine> selectAll() {
        String sql ="select bpl.product_line_qudao productLineQudao,bpl.product_line_type productLineType, bpl.product_line_id productLineId,product_line_chinese_name productLineChineseName,product_line_english_name productLineEnglishName," + "r.collection_bank_name collectionBankName " +
                "from bk_product_line bpl LEFT JOIN remittance r on bpl.product_line_id = r.product_line_id where 1=1";
        return JDBCUtils.query(sql,BkProductLine.class);
    }
}
