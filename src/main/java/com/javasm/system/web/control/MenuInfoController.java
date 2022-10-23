package com.javasm.system.web.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javasm.base.annotation.RequestParam;
import com.javasm.base.bean.PageInfo;
import com.javasm.base.web.control.BaseServlet;
import com.javasm.system.bean.MenuInfo;
import com.javasm.system.service.MenuInfoService;
import com.javasm.system.service.impl.MenuInfoServiceImpl;

import javax.servlet.annotation.WebServlet;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/15-23:18
 * @Since：jdk1.8
 * @Description：
 */

@WebServlet("/menu.do")
public class MenuInfoController extends BaseServlet {


    private MenuInfoService menuInfoService =new MenuInfoServiceImpl();

    /**
     * 添加菜单
     * @param menuInfo
     * @return
     */
    public  String addMenu(MenuInfo menuInfo){
        int i = menuInfoService.addMenu(menuInfo);
        if(i>0){
            return "true";
        }

        return "false";
    }


    /**
     * 按条件分页查询
     * @param nowPage
     * @param pageSize
     * @param menuInfo
     * @return
     */
    public  String selectAll(@RequestParam("nowPage") String nowPage, @RequestParam("pageSize") String pageSize, MenuInfo menuInfo){
        PageInfo<MenuInfo> pageInfo = menuInfoService.selectMenInfoByConditionForPage(nowPage, pageSize, menuInfo);

        String s = JSONObject.toJSONString(pageInfo);

        return s;
    }


    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    public  String deleteMenu(@RequestParam("menuId") String menuId){
        int i = menuInfoService.removeMenu(Integer.parseInt(menuId));
        if(i>0){
            return "true";
        }else {

            return "false";
        }
    }

    public String editMenu(MenuInfo menuInfo){
        int i = menuInfoService.updateMenuInfo(menuInfo);
        if(i>0){
            return "true";
        }else {
            return "false";
        }
    }

}
