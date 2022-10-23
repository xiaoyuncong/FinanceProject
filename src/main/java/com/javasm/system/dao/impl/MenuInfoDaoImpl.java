package com.javasm.system.dao.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.util.JDBCUtils;
import com.javasm.system.bean.MenuInfo;
import com.javasm.system.dao.MenuInfoDao;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-17:19
 * @Since：jdk1.8
 * @Description：
 */
public class MenuInfoDaoImpl implements MenuInfoDao {
    @Override
    public List<MenuInfo> selectParentMenuByRoleId(Integer roleId) {
        String sql = "select m.menu_id menuId,m.menu_name menuName,m.menu_state menuState,m.menu_url menuUrl,m.parent_id parentId,m.menu_icon menuIcon\n" +
                "from bk_menu_role mr, bk_menu_info m  " +
                "where m.menu_id = mr.menu_id and mr.role_id = ? and m.parent_id = 0";
        return JDBCUtils.query(sql, MenuInfo.class, roleId);
    }

    @Override
    public List<MenuInfo> selectSonMenuByParentIdRoleId(Integer parentId, Integer roleId) {
        String sql = "select m.menu_id menuId,m.menu_name menuName,m.menu_state menuState,m.menu_url menuUrl,m.parent_id parentId,m.menu_icon menuIcon\n" +
                "from bk_menu_role mr, bk_menu_info m  " +
                "where m.menu_id = mr.menu_id and mr.role_id = ? and m.parent_id = ?";
        return JDBCUtils.query(sql, MenuInfo.class, roleId, parentId);
    }

    @Override
    public int addMenu(MenuInfo menuInfo) {
        String sql = "insert into bk_menu_info values (null,?,?,?,?,1) ";
        int insert = JDBCUtils.insert(sql, menuInfo.getMenuIcon(), menuInfo.getMenuName(), menuInfo.getMenuUrl(), menuInfo.getParentId());
        return insert;
    }

    @Override
    public List<MenuInfo> selectMenuInfoByConditionForPage(PageInfo<MenuInfo> pageInfo, MenuInfo menuInfo) {
        StringBuffer sb = new StringBuffer();
        String sql ="select m1.menu_id menuId,m1.parent_id parentId," +
                "m1.menu_icon menuIcon,m1.menu_name menuName,m1.menu_url menuUrl ,m2.menu_name parentName from" +
                " bk_menu_info m1 LEFT JOIN bk_menu_info m2 on " + "m1.parent_id = m2.menu_id where m1.menu_state=1";
        sb.append(sql);
        if (menuInfo != null) {
            if(menuInfo.getMenuName()!=null && !menuInfo.getMenuName().equals("")){
                sb.append(" and m1.menu_name like '%" + menuInfo.getMenuName()+ "%'");
            }

            if(menuInfo.getParentId()!=null){
                if(menuInfo.getParentId()!=-1)
                sb.append(" and m1.parent_id like '%" + menuInfo.getParentId()+ "%'");
            }

        }
        sb.append(" limit ?,?");
        return  JDBCUtils.query(sb.toString(),MenuInfo.class,pageInfo.getStartIndex(),pageInfo.getPageSize());
    }

    @Override
    public int getTotal(MenuInfo menuInfo) {
        StringBuffer sb = new StringBuffer();
        String sql ="select count(*) from" +
                " bk_menu_info m1 LEFT JOIN bk_menu_info m2 on " + "m1.parent_id = m2.menu_id where m1.menu_state=1";
        sb.append(sql);
        if (menuInfo != null) {
            if(menuInfo.getMenuName()!=null && !menuInfo.getMenuName().equals("")){
                sb.append(" and m1.menu_name like '%" + menuInfo.getMenuName()+ "%'");
            }

            if(menuInfo.getParentId()!=null){
                if(menuInfo.getParentId()!=-1)
                sb.append(" and m1.parent_id like '%" + menuInfo.getParentId()+ "%'");
            }


        }
            return JDBCUtils.count(sb.toString());
    }

    @Override
    public int updateByMenuId(int menuId) {
        String sql ="update bk_menu_info set menu_state = 0 where menu_id =?";
        int update = JDBCUtils.update(sql, menuId);

        return update;
    }

    @Override
    public int updateMenuInfoByMenuId(MenuInfo menuInfo) {
        String sql ="update bk_menu_info set menu_name =?,parent_id =?,menu_url =?,menu_icon=? where menu_id =?";
        if (menuInfo != null) {
            int update = JDBCUtils.update(sql, menuInfo.getMenuName(), menuInfo.getParentId(),
                    menuInfo.getMenuUrl(), menuInfo.getMenuIcon(), menuInfo.getMenuId());
            return  update;
        }

        return -1;
    }

    @Override
    public List<MenuInfo> selectAll() {
        String sql = "select m.menu_id menuId,m.menu_name menuName,m.menu_state menuState,m.menu_url menuUrl,m.parent_id parentId,m.menu_icon menuIcon\n" +
                "from bk_menu_info m  " +
                "where m.parent_id = 0";
        return  JDBCUtils.query(sql,MenuInfo.class);
    }

    @Override
    public List<MenuInfo> selectAllSon(Integer parentId) {
        String sql = "select m.menu_id menuId,m.menu_name menuName,m.menu_state menuState,m.menu_url menuUrl,m.parent_id parentId,m.menu_icon menuIcon\n" +
                "from bk_menu_info m  " +
                "where m.parent_id = ?";
        return JDBCUtils.query(sql, MenuInfo.class, parentId);
    }

    @Override
    public List<MenuInfo> selectQxMenuByRoleId(int roleId) {
        String sql = "select m.menu_id menuId,m.menu_name menuName,m.menu_state menuState,m.menu_url menuUrl,m.parent_id parentId,m.menu_icon menuIcon\n" +
                "from bk_menu_role mr, bk_menu_info m  " +
                "where m.menu_id = mr.menu_id and mr.role_id = ?";
       return JDBCUtils.query(sql,MenuInfo.class,roleId);
    }
}
