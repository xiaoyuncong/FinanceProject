package com.javasm.system.service.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.util.DataConvert;
import com.javasm.system.bean.MenuInfo;
import com.javasm.system.dao.MenuInfoDao;
import com.javasm.system.dao.impl.MenuInfoDaoImpl;
import com.javasm.system.service.MenuInfoService;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-17:22
 * @Since：jdk1.8
 * @Description：
 */
public class MenuInfoServiceImpl implements MenuInfoService {

    private MenuInfoDao menuInfoDao = new MenuInfoDaoImpl();

    @Override
    public List<MenuInfo> showMenuByRoleId(Integer roleId) {
        // 获取所有的一级菜单
        List<MenuInfo> menuInfos = menuInfoDao.selectParentMenuByRoleId(roleId);

        if (menuInfos != null) {
            for (MenuInfo menuInfo : menuInfos) {
                //  查询二级查询
                List<MenuInfo> sonList = menuInfoDao.selectSonMenuByParentIdRoleId(menuInfo.getMenuId(), roleId);

                menuInfo.setSonList(sonList);
            }
        }

        return menuInfos;
    }

    @Override
    public int addMenu(MenuInfo menuInfo) {
        int i = menuInfoDao.addMenu(menuInfo);
        return i;
    }

    @Override
    public PageInfo<MenuInfo> selectMenInfoByConditionForPage(String nowPage, String pageSize, MenuInfo menuInfo) {
        Integer _nowPage = DataConvert.stringConvertInteger(nowPage);
        Integer _pageSize = DataConvert.stringConvertInteger(pageSize);
        int total = menuInfoDao.getTotal(menuInfo);
        PageInfo<MenuInfo> pageInfo = new PageInfo<>(_nowPage, _pageSize, total);

        List<MenuInfo> data = menuInfoDao.selectMenuInfoByConditionForPage(pageInfo, menuInfo);

        pageInfo.setData(data);


        return pageInfo;
    }

    @Override
    public int removeMenu(int menuId) {
        int i = menuInfoDao.updateByMenuId(menuId);
        return i;

    }

    @Override
    public int updateMenuInfo(MenuInfo menuInfo) {
        int i = menuInfoDao.updateMenuInfoByMenuId(menuInfo);
        return i;
    }

    @Override
    public List<MenuInfo> selectAllMenuInfo() {
        List<MenuInfo> menuInfos = menuInfoDao.selectAll();
        if (menuInfos != null)
        for (MenuInfo menuInfo : menuInfos) {
            List<MenuInfo> menuInfos1 = menuInfoDao.selectAllSon(menuInfo.getMenuId());
            menuInfo.setSonList(menuInfos1);
        }

        return menuInfos;
    }

    @Override
    public List<MenuInfo> selectQxMenuByRoleId(int id) {
        List<MenuInfo> menuInfos = menuInfoDao.selectQxMenuByRoleId(id);
        return menuInfos;
    }
}
