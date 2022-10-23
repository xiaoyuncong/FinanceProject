package com.javasm.system.web.control;

import com.alibaba.fastjson.JSON;
import com.javasm.base.annotation.RequestParam;
import com.javasm.base.web.control.BaseServlet;
import com.javasm.system.bean.MenuInfo;
import com.javasm.system.service.MenuInfoService;
import com.javasm.system.service.impl.MenuInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-17:36
 * @Since：jdk1.8
 * @Description：
 */
@WebServlet(name = "GetSessionDataServlet", urlPatterns = "/getData.do")
public class GetSessionDataServlet extends BaseServlet {


    private MenuInfoService menuInfoService =new MenuInfoServiceImpl();

    /**
     * 获取sesison对象中的菜单
     *
     * @param session
     * @return
     */
    public String getLoginMenu(HttpSession session) {
        Object menuList = session.getAttribute("menuList");
        return menuList != null ? (String) menuList : "";
    }

    /**
     * 获取sesison对象中的登录对象
     *
     * @param session
     * @return
     */
    public String getLoginAdmin(HttpSession session) {
        Object loginAdmin = session.getAttribute("loginAdmin");
        return loginAdmin != null ? (String) loginAdmin : "";
    }


    /**
     * 安全退出
     * @param session
     */
    public void logout(HttpSession session,HttpServletRequest request,HttpServletResponse response){
        session.removeAttribute("loginAdmin");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("adminName")){
                cookie.setMaxAge(0);
                response.addCookie(cookie);

            }else if (cookie.getName().equals("adminPwd")){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }


    public String getNowMenuInfo(@RequestParam("roleId") Integer roleId){
        List<MenuInfo> menuInfoList = menuInfoService.showMenuByRoleId(roleId);
        String s = JSON.toJSONString(menuInfoList);
        return s;
    }


}
