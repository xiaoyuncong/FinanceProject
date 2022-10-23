package com.javasm.system.web.control;

import com.alibaba.fastjson.JSON;
import com.javasm.base.annotation.RequestParam;
import com.javasm.base.bean.PageInfo;
import com.javasm.base.web.control.BaseServlet;
import com.javasm.system.bean.MenuInfo;
import com.javasm.system.bean.RoleInfo;
import com.javasm.system.service.MenuInfoService;
import com.javasm.system.service.RoleInfoService;
import com.javasm.system.service.impl.MenuInfoServiceImpl;
import com.javasm.system.service.impl.RoleInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/16-19:40
 * @Since：jdk1.8
 * @Description：
 */

@WebServlet("/role.do")
public class RoleInfoController extends BaseServlet {

    private RoleInfoService roleInfoService = new RoleInfoServiceImpl();

    private MenuInfoService menuInfoService = new MenuInfoServiceImpl();

    /**
     * 添加角色
     *
     * @param roleInfo
     * @return
     */
    public String addRole(RoleInfo roleInfo) {
        int i = roleInfoService.addRole(roleInfo);
        if (i > 0) {
            return "true";
        } else {
            return "false";
        }

    }

    /**
     * 修改角色
     *
     * @param roleInfo
     * @return
     */
    public String updateRole(RoleInfo roleInfo) {
        int i = roleInfoService.updateRole(roleInfo);
        if (i > 0) {
            return "true";
        } else {
            return "false";
        }
    }


    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    public String deleteRole(@RequestParam("roleId") String roleId) {
        int i = roleInfoService.deleteRole(roleId);
        if (i > 0) {
            return "true";
        } else {
            return "false";
        }
    }


    /**
     * 按条件分页查询
     *
     * @param nowPage
     * @param pageSize
     * @param roleInfo
     * @return
     */
    public String selectAll(@RequestParam("nowPage") String nowPage, @RequestParam("pageSize") String pageSize, RoleInfo roleInfo) {
        PageInfo<RoleInfo> pageInfo = roleInfoService.selectRoleInfoByConditionForPage(nowPage, pageSize, roleInfo);

        String s = JSON.toJSONString(pageInfo);

        return s;
    }


    /**
     * 通过roleId获取权限
     *
     * @param roleId
     * @return
     */
    public String getQxByRoleId(@RequestParam("roleId") String roleId) {
        //查询角色所对应的菜单权限
//        List<MenuInfo> menuInfos = menuInfoService.showMenuByRoleId(Integer.parseInt(roleId));
        List<MenuInfo> menuInfos = menuInfoService.selectQxMenuByRoleId(Integer.parseInt(roleId));
        ArrayList<Integer> ints = new ArrayList<>();
        for (MenuInfo menuInfo : menuInfos) {
            ints.add(menuInfo.getMenuId());
//            for (MenuInfo info : menuInfo.getSonList()) {
//                ints.add(info.getMenuId());
//            }
        }

        //查询所有的菜单权限
        List<MenuInfo> menuInfos1 = menuInfoService.selectAllMenuInfo();


        HashMap<String, Object> map = new HashMap<>();
        map.put("ids", ints);
        map.put("data", menuInfos1);

        String s = JSON.toJSONString(map);


        return s;
    }

    public String updateQx(@RequestParam("roleId")String roleId,@RequestParam("checkedMenu") String checkedMenu){
        StringBuffer sb = new StringBuffer();
        sb.append("[").append(checkedMenu).append("]");

        int[] ints = JSON.parseObject(sb.toString(), int[].class);
//        System.out.println(Arrays.toString(ints));
        int i = roleInfoService.addQx(ints, Integer.parseInt(roleId));
        if(i>0){
            return "true";
        }
        return null;
    }
}
