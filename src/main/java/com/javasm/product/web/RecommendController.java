package com.javasm.product.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javasm.base.annotation.RequestParam;
import com.javasm.base.bean.PageInfo;
import com.javasm.base.web.control.BaseServlet;
import com.javasm.product.bean.Recommend;
import com.javasm.product.service.RecommendService;
import com.javasm.product.service.impl.RecommendServiceImpl;
import com.javasm.system.bean.AdminInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/20-15:08
 * @Since：jdk1.8
 * @Description：
 */

@WebServlet("/rp.do")
public class RecommendController extends BaseServlet {
    private RecommendService recommendService = new RecommendServiceImpl();

    /**
     * 添加推荐
     * @param recommend
     * @return
     */
    public String add(Recommend recommend, HttpSession session){
        String loginAdmin = (String) session.getAttribute("loginAdmin");
        AdminInfo adminInfo = JSON.parseObject(loginAdmin, AdminInfo.class);
        recommend.setAdmin(adminInfo.getAdminId());


        int add = recommendService.add(recommend);
        if(add>0){
            return "true";
        }else {
            return "false";
        }
    }


    /**
     * 修改推荐
     * @param recommend
     * @return
     */
    public String update(Recommend recommend){
        int add = recommendService.update(recommend);
        if(add>0){
            return "true";
        }else {
            return "false";
        }
    }


    public String queryByPage(@RequestParam("nowPage") Integer nowPage, @RequestParam("pageSize") Integer pageSize,
                              @RequestParam("productName") String productName){

        PageInfo<Recommend> recommendPageInfo = recommendService.queryByPage(nowPage, pageSize, productName);
        String s = JSON.toJSONString(recommendPageInfo);
        return s;

    }



}
