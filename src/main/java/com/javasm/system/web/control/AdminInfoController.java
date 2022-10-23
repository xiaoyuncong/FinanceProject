package com.javasm.system.web.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javasm.base.annotation.RequestParam;
import com.javasm.base.bean.PageInfo;
import com.javasm.base.web.control.BaseServlet;
import com.javasm.system.bean.AdminInfo;
import com.javasm.system.bean.RoleInfo;
import com.javasm.system.dao.AdminInfoDao;
import com.javasm.system.service.AdminInfoService;
import com.javasm.system.service.RoleInfoService;
import com.javasm.system.service.impl.AdminInfoServiceImpl;
import com.javasm.system.service.impl.RoleInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/14-18:37
 * @Since：jdk1.8
 * @Description：
 */

@WebServlet("/admin.do")
public class AdminInfoController extends BaseServlet {

    private AdminInfoService adminInfoService =new AdminInfoServiceImpl();


    private RoleInfoService roleInfoService =new RoleInfoServiceImpl();

    /**
     * 按条件分页查询员工
     * @param nowPage
     * @param pageSize
     * @param adminInfo
     * @return
     */
    public String getAdminByPage(@RequestParam("nowPage") String nowPage, @RequestParam("pageSize") String pageSize,

                                 AdminInfo adminInfo){


        PageInfo<AdminInfo> adminInfoPageInfo = adminInfoService.queryAdminInfoByPage(nowPage, pageSize, adminInfo);

        String s = JSON.toJSONString(adminInfoPageInfo);
        return s;
    }


    /**
     * 保存管理员信息
     * @param adminInfo
     * @return
     */
    public  String saveAdmin(AdminInfo adminInfo){

        int i = adminInfoService.saveAdmin(adminInfo);

        if(i>0){
            return "true";
        }else {
            return "false";
        }

    }


    /**
     * 查询所有的角色
     *
     * @return
     */
    public String getRole() {
        List<RoleInfo> roleInfos = roleInfoService.selectAllRoleInfo();
        return JSONObject.toJSONString(roleInfos);
    }


    /**
     * 删除员工信息
     * @param adminId
     * @return
     */
    public  String deleteAdmin(@RequestParam("adminId") Integer adminId){
        int i = adminInfoService.deleteAdmin(adminId);
        if(i>0){
            return  "success";
        }
        return  "fail";

    }


    /**
     * 修改员工信息
     * @param adminInfo
     * @return
     */
    public String editAdmin(AdminInfo adminInfo){
        int i = adminInfoService.updateAdminInfo(adminInfo);
        if(i>0){
            return "true";
        }
        return "false";
    }


    /**
     * 修改密码
     * @param pwd
     * @param adminInfo
     * @return
     */
    public  String updatePwd(@RequestParam("pwd") String pwd ,AdminInfo adminInfo){
        if (adminInfo != null) {
            int i = adminInfoService.updatePwd(pwd, adminInfo.getAdminId());
            if(i>0){
                return "true";
            }
        }

        return "false";
    }



}
