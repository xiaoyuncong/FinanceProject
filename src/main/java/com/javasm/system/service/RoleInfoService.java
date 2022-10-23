package com.javasm.system.service;

import com.javasm.base.bean.PageInfo;
import com.javasm.system.bean.RoleInfo;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/14-17:26
 * @Since：jdk1.8
 * @Description：
 */
public interface RoleInfoService {


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
    int deleteRole(String roleId);

    /**
     * 按条件分页查询角色信息
     * @param pageInfo
     * @param roleInfo
     * @return
     */
    PageInfo<RoleInfo> selectRoleInfoByConditionForPage(String nowPage,String pageSize , RoleInfo roleInfo);


    /**
     * 添加权限
     * @param menuIds
     * @param roleId
     * @return
     */
    int addQx(int[] menuIds,int roleId);

}
