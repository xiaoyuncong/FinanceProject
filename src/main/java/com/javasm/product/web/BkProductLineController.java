package com.javasm.product.web;

import com.alibaba.fastjson.JSON;
import com.javasm.base.annotation.RequestParam;
import com.javasm.base.bean.PageInfo;
import com.javasm.base.web.control.BaseServlet;
import com.javasm.product.bean.BkProductLine;
import com.javasm.product.bean.Remittance;
import com.javasm.product.service.BkProductLineService;
import com.javasm.product.service.impl.BkProductLineServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/18-14:37
 * @Since：jdk1.8
 * @Description：
 */

@WebServlet("/bpl.do")
public class BkProductLineController extends BaseServlet {


    private BkProductLineService bkProductLineService =new BkProductLineServiceImpl();
    /**
     * 添加产品系列
     * @param bkProductLine
     * @return
     */
    public  String add(BkProductLine bkProductLine){

        int add = bkProductLineService.add(bkProductLine);
        if (add>0){
            return "true";
        }else {
            return "false";
        }
    }


    public String queryByPage(@RequestParam("nowPage") String nowPage,@RequestParam("pageSize") String pageSize,
                              @RequestParam("productLineChineseName") String pName){

        PageInfo<BkProductLine> bkProductLinePageInfo = bkProductLineService.queryByConditionForPage(nowPage, pageSize, pName);
        String s = JSON.toJSONString(bkProductLinePageInfo);
        return s;

    }


    /**
     * 添加汇款信息
     * @param remittance
     * @return
     */
    public String addRemittance(Remittance remittance){
        int i = bkProductLineService.addRemittance(remittance);
        if(i>0){
            return "true";
        }else {
            return "false";
        }
    }


    /**
     * 修改产品系列
     * @param bkProductLine
     * @return
     */
    public String update(BkProductLine bkProductLine){

        int i = bkProductLineService.updateById(bkProductLine);
        if(i>0){
            return "true";
        }else {
            return "false";
        }
    }


    /**
     * 查询所有
     * @return
     */
    public String selectAll(){
        List<BkProductLine> bkProductLines = bkProductLineService.selectAll();
        String s = JSON.toJSONString(bkProductLines);
        return s;
    }



}
