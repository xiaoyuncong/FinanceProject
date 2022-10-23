package com.javasm.system.dao.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.util.JDBCUtils;
import com.javasm.system.bean.AdminInfo;
import com.javasm.system.dao.AdminInfoDao;

import java.util.Date;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-14:49
 * @Since：jdk1.8
 * @Description：
 */
public class AdminInfoDaoImpl implements AdminInfoDao {
    @Override
    public AdminInfo selectAdminByName(String adminName) {
        String sql = "select a.admin_id adminId,a.admin_image adminImage,a.admin_name adminName,a.admin_pwd adminPwd,\n" +
                "a.admin_sex adminSex,a.admin_state adminState,a.login_time loginTime,a.role_id roleId " +
                "from bk_admin_info a where a.admin_name =?";
        return JDBCUtils.get(sql, AdminInfo.class,adminName);
    }

    @Override
    public List<AdminInfo> selectAdminInfoByPage(PageInfo<AdminInfo> pageInfo, AdminInfo adminInfo) {
        StringBuffer stringBuffer = new StringBuffer();


        String sql = "select a.admin_id adminId,a.admin_image adminImage,a.admin_name adminName,a.admin_pwd adminPwd,\n" +
                "a.admin_sex adminSex,a.admin_state adminState,a.login_time loginTime,a.role_id roleId " +
                "from bk_admin_info a where admin_state !=0";
        stringBuffer.append(sql);
        if (adminInfo != null) {
            if (adminInfo.getAdminName() != null && !"".equals(adminInfo.getAdminName())) {
               String s1=" and a.admin_name like '%" + adminInfo.getAdminName() + "%'";
               stringBuffer.append(s1);
            }
            if (adminInfo.getAdminId() != null) {
                String s2 =" and a.admin_id like '%" + adminInfo.getAdminId()+ "%'";
                stringBuffer.append(s2);
            }
        }
        String s3= " limit ?,? ";
        stringBuffer.append(s3);
        return JDBCUtils.query(stringBuffer.toString(), AdminInfo.class, pageInfo.getStartIndex(), pageInfo.getPageSize());
    }

    @Override
    public int selectTotal(AdminInfo adminInfo) {
        String sql = "select count(*) from bk_admin_info a where admin_state != 0";
        if (adminInfo != null) {
            if (adminInfo.getAdminName() != null && !"".equals(adminInfo.getAdminName())) {
                sql += " and a.admin_name like '%" + adminInfo.getAdminName() + "%'";
            }
            if (adminInfo.getAdminId() != null) {
                sql += " and a.admin_id like '%" + adminInfo.getAdminId() + "%'";
            }
        }
        return JDBCUtils.count(sql);
    }

    @Override
    public int saveAdmin(AdminInfo adminInfo) {
        String sql = "insert into bk_admin_info values(null,?,?,?,null,?,?,?)";
        int insert = JDBCUtils.insert(sql, adminInfo.getAdminName(), "123",
                adminInfo.getAdminState(), adminInfo.getAdminImage(), adminInfo.getRoleId(), 0);

        return  insert;
    }

    @Override
    public int updateAdminByAdminId(int adminId) {
        String sql ="update bk_admin_info set admin_state = 0 where admin_id = ?";

        int update = JDBCUtils.update(sql, adminId);

        return update;
    }

    @Override
    public int updateAdminInfoBySelected(AdminInfo adminInfo) {
        String sql = "update bk_admin_info set admin_name =?,admin_state=?,role_id =?,admin_image= ?  where admin_id =?";
        if (adminInfo != null) {
            int update = JDBCUtils.update(sql, adminInfo.getAdminName(), adminInfo.getAdminState(),
                    adminInfo.getRoleId(), adminInfo.getAdminImage(), adminInfo.getAdminId());

            return  update;

        }

        return -1;
    }

    @Override
    public int updatePwdById(String pwd ,int adminId) {
        String sql ="update bk_admin_info set  admin_pwd =? where admin_id = ? ";

        int update = JDBCUtils.update(sql, pwd, adminId);

        return update;
    }
}
