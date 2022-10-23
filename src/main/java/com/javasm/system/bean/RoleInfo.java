package com.javasm.system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/14-17:22
 * @Since：jdk1.8
 * @Description：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleInfo {

    private Integer roleId;
    private String roleName;
    private Integer roleState;

}
