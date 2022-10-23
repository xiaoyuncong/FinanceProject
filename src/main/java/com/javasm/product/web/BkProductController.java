package com.javasm.product.web;

import com.alibaba.fastjson.JSON;
import com.javasm.base.annotation.RequestParam;
import com.javasm.base.bean.PageInfo;
import com.javasm.base.web.control.BaseServlet;
import com.javasm.product.bean.BkProduct;
import com.javasm.product.bean.BkProductLine;
import com.javasm.product.service.ProductService;
import com.javasm.product.service.impl.ProductServiceImpl;
import com.javasm.system.bean.AdminInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/19-11:06
 * @Since：jdk1.8
 * @Description：
 */

@WebServlet("/bp.do")
public class BkProductController extends BaseServlet {

    private ProductService productService =new ProductServiceImpl();

    /**
     * 添加产品
     * @param bkProduct
     * @return
     */
    public String add(BkProduct bkProduct){
        //起初添加的产品的审核状态都是未审核
        bkProduct.setAuditState(0);
        int add = productService.add(bkProduct);
        if(add>0){
            return "true";
        }else {
            return "false";
        }
    }


    /**
     * 按条件分页查询
     * @param nowPage
     * @param pageSize
     * @param bkProduct
     * @return
     */
    public String queryByPage(@RequestParam("nowPage") Integer nowPage, @RequestParam("pageSize") Integer pageSize,
                              @RequestParam("adminid") Integer adminid, BkProduct bkProduct){

        PageInfo<BkProduct> bkProductPageInfo=null;
        if (adminid != null ) {
             bkProductPageInfo = productService.queryByConditionForPage(pageSize, nowPage, bkProduct, adminid);
        }else {

        bkProductPageInfo = productService.queryByConditionForPage(pageSize, nowPage, bkProduct);
        }
        String s = JSON.toJSONString(bkProductPageInfo);

        return s;

    }


    /**
     * 查询所有具有产品审核权限的admin
     * @return
     */
    public String selectAllAdminForAudit(){
        List<AdminInfo> adminInfos = productService.selectAllAdminForAudit();
        String s = JSON.toJSONString(adminInfos);
        return s;
    }


    /**
     * 修改产品,
     * @param bkProduct
     * @return
     */
    public String update(BkProduct bkProduct){

        int i = productService.updateProduct(bkProduct);
        if(i>0){
            return "true";
        }
        return "false";
    }


    /**
     * 查询所有产品
     * @return
     */
    public String selectAll(){
        List<BkProduct> bkProducts = productService.selectAll();
        String s = JSON.toJSONString(bkProducts);
        return s;
    }



}
