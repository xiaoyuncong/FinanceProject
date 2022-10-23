package com.javasm.system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-16:42
 * @Since：jdk1.8
 * @Description：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuInfo {

    private Integer menuId;
    private String menuIcon;
    private String menuName;
    private String menuUrl;
    private Integer parentId;
    private Integer menuState;

    private String parentName;//父级菜单名称

    private List<MenuInfo> sonList;// 存储当前菜单的子菜单


}
