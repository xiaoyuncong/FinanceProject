package com.javasm.system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-14:45
 * @Since：jdk1.8
 * @Description：
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminInfo {

    private Integer adminId;
    private String adminName;
    private String adminPwd;
    private Integer adminState;
    private String loginTime;
    private String adminImage;
    private Integer roleId;
    private Integer adminSex;

}
