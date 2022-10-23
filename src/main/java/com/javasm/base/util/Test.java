package com.javasm.base.util;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/10/17-16:57
 * @Since：jdk1.8
 * @Description：
 */
public class Test {
    public static void main(String[] args) {
        String s = "[1,3,5]";
        int[] ints = JSON.parseObject(s, int[].class);
        System.out.println(Arrays.toString(ints));
    }
}
