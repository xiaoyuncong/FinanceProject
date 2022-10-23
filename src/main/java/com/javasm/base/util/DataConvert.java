package com.javasm.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/9/30-17:40
 * @Since：jdk1.8
 * @Description：
 */
public class DataConvert {

    /**
     * 将string 装为 Integer
     *
     * @param value
     * @return
     */
    public static Integer stringConvertInteger(String value) {
        return value != null && value.length() > 0 ? Integer.valueOf(value) : null;
    }

    /**
     * 将string 装为 Float
     *
     * @param value
     * @return
     */
    public static Float stringConvertFloat(String value) {
        return value != null && value.length() > 0 ? Float.valueOf(value) : null;
    }

    /**
     * 将string 装为 Boolean
     *
     * @param value
     * @return
     */
    public static Boolean stringConvertBoolean(String value) {
        return value != null && value.length() > 0 ? Boolean.valueOf(value) : null;
    }

    /**
     * 将string 装为 date
     *
     * @param value
     * @return
     */
    public static Date stringConvertDate(String value) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return value != null && value.length() > 0 ? simpleDateFormat.parse(value) : null;
    }


    /**
     * 将string 装为 DateTime
     *
     * @param value
     * @return
     */
    public static Date stringConvertDateTime(String value) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return value != null && value.length() > 0 ? simpleDateFormat.parse(value) : null;
    }

    /**
     * 将string 装为 DateTime
     *
     * @param value
     * @return
     */
    public static java.sql.Date stringConvertSqlDate(String value) throws ParseException {
        return value != null && value.length() > 0 ? java.sql.Date.valueOf(value) : null;
    }

}
