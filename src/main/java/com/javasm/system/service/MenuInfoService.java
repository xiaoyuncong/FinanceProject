package com.javasm.system.service;

import com.javasm.base.bean.PageInfo;
import com.javasm.system.bean.MenuInfo;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-17:22
 * @Since：jdk1.8
 * @Description：
 */
public interface MenuInfoService {

    /**
     * 通过roleId查询权限
     *
     * @param roleId
     * @return
     */
    List<MenuInfo> showMenuByRoleId(Integer roleId);


    /**
     * 添加菜单
     * @return
     */
    int addMenu(MenuInfo menuInfo);


    /**
     * 按条件分页查询菜单信息
     * @param nowPage
     * @param pageSize
     * @param menuInfo
     * @return
     */
    PageInfo<MenuInfo> selectMenInfoByConditionForPage(String nowPage ,String pageSize ,MenuInfo menuInfo);


    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    int removeMenu(int menuId);


    /**
     * 修改菜单信息
     * @param menuInfo
     * @return
     */
    int updateMenuInfo(MenuInfo menuInfo);


    /**
     * 查询所有菜单
     * @return
     */
    List<MenuInfo> selectAllMenuInfo();


    /**
     * 查询权所对应的全部菜单
     * @param id
     * @return
     */
    List<MenuInfo> selectQxMenuByRoleId(int id);

}
