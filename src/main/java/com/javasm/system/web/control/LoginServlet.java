package com.javasm.system.web.control;


import com.alibaba.fastjson.JSONObject;
import com.javasm.base.annotation.RequestParam;
import com.javasm.base.bean.ResultCode;
import com.javasm.base.web.control.BaseServlet;
import com.javasm.system.bean.AdminInfo;
import com.javasm.system.bean.MenuInfo;
import com.javasm.system.service.AdminInfoService;
import com.javasm.system.service.MenuInfoService;
import com.javasm.system.service.impl.AdminInfoServiceImpl;
import com.javasm.system.service.impl.MenuInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-15:04
 * @Since：jdk1.8
 * @Description：
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends BaseServlet {

    private AdminInfoService adminInfoService = new AdminInfoServiceImpl();
    private MenuInfoService menuInfoService = new MenuInfoServiceImpl();

    /**
     * 登录
     *
     * @param adminName
     * @param adminPwd
     * @param session
     * @return
     */
    public String login(@RequestParam("rememberpwd") String rememberpwd, @RequestParam("adminName") String adminName, @RequestParam("adminPwd") String adminPwd, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        // 调用service中login方法
        ResultCode<AdminInfo> resultCode = adminInfoService.login(adminName, adminPwd);

        // 获取所有cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (adminName.equals(name)) {
                    resultCode.setMessage("登录成功");
                    break;
                }
            }
        }

        // 判断是否登录成功
        if (resultCode.getMessage().equals("登录成功")) {
            // 获取登录的用户
            AdminInfo login = resultCode.getData();
            String json = JSONObject.toJSONString(login);
            //  将用户存储在session
            session.setAttribute("loginAdmin", json);

            // 查询当前登录人的权限
            List<MenuInfo> menuInfoList = menuInfoService.showMenuByRoleId(login.getRoleId());
            String menuJson = JSONObject.toJSONString(menuInfoList);//  将用户存储在session
            session.setAttribute("menuList", menuJson);

            // 记住密码
            if (rememberpwd != null && rememberpwd.equals("true")) {
                // 实例化cookie
                Cookie cookie = new Cookie("adminName",adminName);
                Cookie cookie1 = new Cookie("adminPwd",adminPwd);
                //  设置有效期
                cookie.setMaxAge(60 * 60 * 24 * 7);
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                // 发送cookie到浏览器
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
        }

        return JSONObject.toJSONString(resultCode);
    }

}
