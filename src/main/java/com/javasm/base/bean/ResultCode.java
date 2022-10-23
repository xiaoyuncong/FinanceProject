package com.javasm.base.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/13-14:55
 * @Since：jdk1.8
 * @Description：
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultCode<T> {

    private String message;// 处理结果
    private Integer code;// 请求状态
    private T data;// 查询对象
    private List<T> dataList;//  查询的集合

}
