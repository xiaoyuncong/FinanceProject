package com.javasm.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/10-14:39
 * @Since：jdk1.8
 * @Description：
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RequestParam {

    /**
     * 获取客户端数据的name
     *
     * @return
     */
    String value();

}
