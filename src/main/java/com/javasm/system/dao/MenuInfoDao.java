package com.javasm.system.dao;

import com.javasm.base.bean.PageInfo;
import com.javasm.system.bean.MenuInfo;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-17:15
 * @Since：jdk1.8
 * @Description：
 */
public interface MenuInfoDao {

    /**
     * 查询一级菜单
     *
     * @param roleId 角色ID
     * @return
     */
    List<MenuInfo> selectParentMenuByRoleId(Integer roleId);

    /**
     * 通过用户的角色Id、父级ID查询权限
     *
     * @param parentId 父级ID
     * @param roleId   角色ID
     * @return
     */
    List<MenuInfo> selectSonMenuByParentIdRoleId(Integer parentId, Integer roleId);


    /**
     * 添加菜单
     * @param menuInfo
     * @return
     */
    int addMenu(MenuInfo menuInfo);


    /**
     * 按条件分页查询菜单信息
     * @param pageInfo
     * @param menuInfo
     * @return
     */
    List<MenuInfo> selectMenuInfoByConditionForPage(PageInfo<MenuInfo> pageInfo, MenuInfo menuInfo);


    /**
     * 查询总记录数
     * @param menuInfo
     * @return
     */
    int getTotal(MenuInfo menuInfo);


    /**
     * 通过id修改状态
     * @param menuId
     * @return
     */
    int updateByMenuId(int menuId);


    /**
     * 修改菜单信息
     * @param menuInfo
     * @return
     */
    int updateMenuInfoByMenuId(MenuInfo menuInfo);


    /**
     * 查询所有一级菜单
     * @return
     */
    List<MenuInfo> selectAll();

    /**
     * 查询所有一级菜单的子菜单
     * @param parentId
     * @return
     */
    List<MenuInfo> selectAllSon(Integer parentId);


    /**
     * 查询角色所对应的全部菜单
     * @param roleId
     * @return
     */
    List<MenuInfo> selectQxMenuByRoleId(int roleId);
}
