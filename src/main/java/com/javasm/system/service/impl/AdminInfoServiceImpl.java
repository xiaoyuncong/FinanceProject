package com.javasm.system.service.impl;

import com.javasm.base.bean.PageInfo;
import com.javasm.base.bean.ResultCode;
import com.javasm.base.util.DataConvert;
import com.javasm.system.bean.AdminInfo;
import com.javasm.system.dao.AdminInfoDao;
import com.javasm.system.dao.impl.AdminInfoDaoImpl;
import com.javasm.system.service.AdminInfoService;

import java.util.List;


/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-14:58
 * @Since：jdk1.8
 * @Description：
 */


public class AdminInfoServiceImpl implements AdminInfoService {

    private AdminInfoDao adminInfoDao = new AdminInfoDaoImpl();




    @Override
    public ResultCode login(String adminName, String adminPwd) {
        AdminInfo adminInfo = adminInfoDao.selectAdminByName(adminName);

        ResultCode<AdminInfo> resultCode = new ResultCode();

        resultCode.setCode(200);
        resultCode.setMessage("登录失败");
        if (adminInfo != null) {
            if (adminInfo.getAdminPwd().equals(adminPwd) && adminInfo.getAdminState()!=0) {
                resultCode.setMessage("登录成功");
                resultCode.setData(adminInfo);
            }else if(adminInfo.getAdminState()==0){
                resultCode.setMessage("账号状态异常!");

            }
        }

        return resultCode;
    }

    @Override
    public PageInfo<AdminInfo> queryAdminInfoByPage(String nowPage, String pageSize, AdminInfo adminInfo) {
        Integer _nowPage = DataConvert.stringConvertInteger(nowPage);
        Integer _pageSize = DataConvert.stringConvertInteger(pageSize);
        int total = adminInfoDao.selectTotal(adminInfo);

        PageInfo pageInfo = new PageInfo(_nowPage,_pageSize,total);
        List list = adminInfoDao.selectAdminInfoByPage(pageInfo, adminInfo);

        pageInfo.setData(list);
        return pageInfo;
    }

    @Override
    public int saveAdmin(AdminInfo adminInfo) {
        if (adminInfo != null) {
            return adminInfoDao.saveAdmin(adminInfo);
        }

        return -1;

    }

    @Override
    public int deleteAdmin(int adminId) {
        int i = adminInfoDao.updateAdminByAdminId(adminId);

        return i;
    }

    @Override
    public int updateAdminInfo(AdminInfo adminInfo) {
        int i = adminInfoDao.updateAdminInfoBySelected(adminInfo);
        return i;
    }

    @Override
    public int updatePwd(String pwd, int adminId) {
        int i = adminInfoDao.updatePwdById(pwd, adminId);

        return i;
    }


}
