package com.javasm.system.dao.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.util.JDBCUtils;
import com.javasm.system.bean.AdminInfo;
import com.javasm.system.bean.RoleInfo;
import com.javasm.system.dao.RoleInfoDao;

import java.sql.Connection;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/14-17:24
 * @Since：jdk1.8
 * @Description：
 */
public class RoleInfoDaoImpl implements RoleInfoDao {
    @Override
    public List<RoleInfo> selectAllRoleInfo() {
        String sql = " select role_Id roleId,role_name roleName,role_state roleState from bk_role_info ";
        return JDBCUtils.query(sql, RoleInfo.class);
    }

    @Override
    public int addRole(RoleInfo roleInfo) {
        String sql ="insert into bk_role_info values(null,?,1)";
        int insert = JDBCUtils.insert(sql, roleInfo.getRoleName());
        return insert;
    }

    @Override
    public int updateRole(RoleInfo roleInfo) {
        String sql ="update bk_role_info set role_name=? where role_id =?";
        int update = JDBCUtils.update(sql, roleInfo.getRoleName(), roleInfo.getRoleId());
        return update;
    }

    @Override
    public int deleteRole(int roleId) {
        String sql = "update bk_role_info set role_state =0 where role_id = ?";
        int update = JDBCUtils.update(sql, roleId);
        return update;
    }

    @Override
    public List<RoleInfo> selectMenuInfoByConditionForPage(PageInfo<RoleInfo> pageInfo, RoleInfo roleInfo) {
        String sql = "select role_id roleId , role_name roleName from bk_role_info where role_state =1";
        if (roleInfo != null) {
            if(roleInfo.getRoleName()!=null&& !roleInfo.getRoleName().equals("") )
            sql +=" and role_name like '%" +roleInfo.getRoleName()+ "%'";
        }
        sql+=" limit ?,?";


        return JDBCUtils.query(sql, RoleInfo.class, pageInfo.getStartIndex(), pageInfo.getPageSize());
    }

    @Override
    public int getTotal(RoleInfo roleInfo) {
        String sql = "select count(*) from bk_role_info where role_state =1";
        if (roleInfo != null) {
            if(roleInfo.getRoleName()!=null&& !roleInfo.getRoleName().equals("") )
                sql +=" and role_name like '%" +roleInfo.getRoleName()+ "%'";
        }
        int count = JDBCUtils.count(sql);
        return count;
    }

    @Override
    public int deleteRoleQx(Connection connection, int roleId) {
        String sql ="delete from bk_menu_role where role_id = ?";
        int update = JDBCUtils.update(connection, sql, roleId);
        return update;
    }

    @Override
    public int addRoleQx(Connection connection, int roleId, int menuIds) {
        String sql = "insert into bk_menu_role values(?,?)";
        int update = JDBCUtils.update(connection, sql, roleId, menuIds);
        return update;
    }

    @Override
    public List<AdminInfo> selectAllProductAuditAdmin() {
        String sql ="select ai.admin_id adminId,ai.admin_name adminName from bk_admin_info ai LEFT JOIN bk_menu_role mr on ai.role_id = mr.role_id LEFT JOIN bk_menu_info mi ON "
                + "mi.menu_id = mr.menu_id where mi.menu_name='产品审核' and ai.admin_state =1";
        return  JDBCUtils.query(sql, AdminInfo.class);

    }
}
