package com.javasm.product.web;

import com.javasm.base.web.control.BaseServlet;
import com.javasm.product.bean.ProductNet;
import com.javasm.product.service.ProductNetService;
import com.javasm.product.service.impl.ProductNetServiceImpl;

import javax.servlet.annotation.WebServlet;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/19-22:39
 * @Since：jdk1.8
 * @Description：
 */

@WebServlet("/pn.do")
public class ProductNetController extends BaseServlet {
    private ProductNetService productNetService =new ProductNetServiceImpl();


    public String add(ProductNet productNet){
        int add = productNetService.add(productNet);
        if(add>0){
            return "true";
        }

        return "false";
    }
}
