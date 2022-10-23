package com.javasm.system.service;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.bean.ResultCode;
import com.javasm.system.bean.AdminInfo;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-14:54
 * @Since：jdk1.8
 * @Description：
 */
public interface AdminInfoService {

    /**
     * 登录
     *
     * @param adminName
     * @param adminPwd
     * @return
     */
    ResultCode login(String adminName, String adminPwd);


    /**
     * 按条件分页查询管理员信息
     * @param nowPage
     * @param pageSize
     * @param adminInfo
     * @return
     */
    PageInfo<AdminInfo> queryAdminInfoByPage(String nowPage,String pageSize,AdminInfo adminInfo);


    /**
     * 添加管理员
     * @param adminInfo
     * @return
     */
    int saveAdmin(AdminInfo adminInfo);


    /**
     * 删除管理员用户
     * @param adminId
     * @return
     */
    int deleteAdmin(int adminId);


    /**
     * 修改用户
     * @param adminInfo
     * @return
     */
    int updateAdminInfo(AdminInfo adminInfo);


    /**
     * 修改密码
     * @param pwd
     * @param adminId
     * @return
     */
    int updatePwd(String pwd, int adminId);

}
