package com.javasm.system.service.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.util.DataConvert;
import com.javasm.base.util.JDBCUtils;
import com.javasm.system.bean.MenuInfo;
import com.javasm.system.bean.RoleInfo;
import com.javasm.system.dao.RoleInfoDao;
import com.javasm.system.dao.impl.RoleInfoDaoImpl;
import com.javasm.system.service.RoleInfoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/14-17:26
 * @Since：jdk1.8
 * @Description：
 */
public class RoleInfoServiceImpl implements RoleInfoService {

    private RoleInfoDao roleInfoDao = new RoleInfoDaoImpl();

    @Override
    public List<RoleInfo> selectAllRoleInfo() {
        return roleInfoDao.selectAllRoleInfo();
    }

    @Override
    public int addRole(RoleInfo roleInfo) {
        int i = roleInfoDao.addRole(roleInfo);
        return i;
    }

    @Override
    public int updateRole(RoleInfo roleInfo) {
        int i = roleInfoDao.updateRole(roleInfo);
        return i;
    }

    @Override
    public int deleteRole(String roleId) {


        int i = roleInfoDao.deleteRole(Integer.parseInt(roleId));
        return i;
    }

    @Override
    public PageInfo<RoleInfo> selectRoleInfoByConditionForPage(String nowPage,String pageSize, RoleInfo roleInfo) {
        Integer _nowPage = DataConvert.stringConvertInteger(nowPage);
        Integer _pageSize = DataConvert.stringConvertInteger(pageSize);
        int total = roleInfoDao.getTotal(roleInfo);
        PageInfo<RoleInfo> pageInfo = new PageInfo<>(_nowPage,_pageSize,total);

        List<RoleInfo> roleInfos = roleInfoDao.selectMenuInfoByConditionForPage(pageInfo, roleInfo);
        pageInfo.setData(roleInfos);
        return pageInfo;
    }

    @Override
    public int addQx(int[] menuIds, int roleId) {
        Connection connection = JDBCUtils.getConnection();
        try {
            connection.setAutoCommit(false);
            int i = roleInfoDao.deleteRoleQx(connection, roleId);
            if(i<=0){
                connection.rollback();
            }
            for (int menuId : menuIds) {
                int i1 = roleInfoDao.addRoleQx(connection, roleId, menuId);
                if(i1<=0){
                    connection.rollback();
                }
            }
            connection.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return 1;


    }
}
