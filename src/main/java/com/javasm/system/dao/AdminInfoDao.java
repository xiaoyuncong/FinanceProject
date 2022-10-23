package com.javasm.system.dao;

import com.javasm.base.bean.PageInfo;
import com.javasm.system.bean.AdminInfo;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-14:48
 * @Since：jdk1.8
 * @Description：
 */
public interface AdminInfoDao {

    /**
     * 通过 账号查询管理员信息
     *
     * @param adminName
     * @return
     */
    AdminInfo selectAdminByName(String adminName);


    /**
     * 按条件分页查询管理员信息
     * @param pageInfo
     * @param adminInfo
     * @return
     */
    List<AdminInfo> selectAdminInfoByPage(PageInfo<AdminInfo> pageInfo,AdminInfo adminInfo );

    /**
     * 查询总条数
     * @param adminInfo
     * @return
     */
    int selectTotal(AdminInfo adminInfo);


    /**
     * 添加管理员
     * @param adminInfo
     * @return
     */
    int saveAdmin(AdminInfo adminInfo);


    /**
     * 修改管理员状态为0,逻辑删除
     * @param adminId
     * @return
     */
    int updateAdminByAdminId(int adminId);


    /**
     * 修改管理员信息
     * @param adminInfo
     * @return
     */
    int updateAdminInfoBySelected(AdminInfo adminInfo);


    /**
     * 修改密码
     * @param adminId
     * @return
     */
    int updatePwdById(String pwd,int adminId);

}
