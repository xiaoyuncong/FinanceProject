package com.javasm.system.dao;

import com.javasm.base.bean.PageInfo;
import com.javasm.system.bean.AdminInfo;
import com.javasm.system.bean.MenuInfo;
import com.javasm.system.bean.RoleInfo;

import java.sql.Connection;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/14-17:23
 * @Since：jdk1.8
 * @Description：
 */
public interface RoleInfoDao {

    /**
     * 查询所有的角色
     *
     * @return
     */
    List<RoleInfo> selectAllRoleInfo();

    /**
     * 添加角色
     * @param roleInfo
     * @return
     */
    int addRole(RoleInfo roleInfo);


    /**
     * 修改角色
     * @param roleInfo
     * @return
     */
    int updateRole(RoleInfo roleInfo);


    /**
     * 删除角色
     * @param roleId
     * @return
     */
    int deleteRole(int roleId);


    /**
     * 按条件分页查询角色信息
     * @param pageInfo
     * @param roleInfo
     * @return
     */
    List<RoleInfo> selectMenuInfoByConditionForPage(PageInfo<RoleInfo> pageInfo, RoleInfo roleInfo);


    /**
     * 总记录数
     * @param roleInfo
     * @return
     */
    int getTotal(RoleInfo roleInfo);


    /**
     * 删除角色权限(事务)
     * @param connection
     * @param roleId
     * @return
     */
    int deleteRoleQx(Connection connection,int roleId);


    /**
     * 添加权限
     * @param connection
     * @param roleId
     * @param menuId
     * @return
     */
    int addRoleQx(Connection connection ,int roleId,int menuId);

    /**
     * 查询所有具有产品审核权限的admin
     * @return
     */
    List<AdminInfo> selectAllProductAuditAdmin();

}
