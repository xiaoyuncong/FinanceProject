package com.javasm.product.web;

import com.alibaba.fastjson.JSON;
import com.javasm.base.annotation.RequestParam;
import com.javasm.base.web.control.BaseServlet;
import com.javasm.product.service.ProductRelatedService;
import com.javasm.product.service.impl.ProductRelatedServiceImpl;

import javax.servlet.annotation.WebServlet;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/20-20:04
 * @Since：jdk1.8
 * @Description：
 */

@WebServlet("/prc.do")
public class ProductRelatedController extends BaseServlet {
    private ProductRelatedService productRelatedService =new ProductRelatedServiceImpl();

    public String getRIds(@RequestParam("productId") Integer productId){
        Integer[] ints = productRelatedService.selectAllR(productId);
        String s;
        if (ints != null) {
           s = JSON.toJSONString(ints);
        }else {
            s="";
        }

        return s;
    }


    public String getNoRIds(@RequestParam("productId") Integer productId){
        Integer[] ints = productRelatedService.selectAllNoR(productId);
        String s;
        if (ints != null) {
            s = JSON.toJSONString(ints);
        }else {
            s="";
        }

        return s;
    }


    /**
     * 添加关联
     * @param ids
     * @return
     */
    public String addRelated(@RequestParam("pId") Integer pid,@RequestParam("ids") String ids,@RequestParam("noIds") String nIds){
        ids ="["+ids+"]";
        nIds ="["+nIds+"]";
        int[] ints = JSON.parseObject(ids, int[].class);
        int[] ints1 = JSON.parseObject(nIds, int[].class);
        int i1 = productRelatedService.deleteNoRelated(pid, ints1);
        int i = productRelatedService.addRelated(pid, ints);
        return "true";
    }
}
