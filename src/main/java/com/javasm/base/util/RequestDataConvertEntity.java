package com.javasm.base.util;

import java.lang.reflect.Field;
import java.sql.Date;
import java.text.ParseException;
import java.util.Map;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/8-17:46
 * @Since：jdk1.8
 * @Description：
 */
public class RequestDataConvertEntity {

    /**
     * 将map集合装为实体类对象
     *
     * @param entityClazz
     * @param mapData
     * @param <T>
     * @return
     */
    public static <T> T mapConvertEntity(Class<T> entityClazz, Map<String, String[]> mapData) throws IllegalAccessException, InstantiationException, ParseException {
        // 1.获取实体类中所有的成员变量
        Field[] declaredFields = entityClazz.getDeclaredFields();

        // 实例化对象
        T entity = entityClazz.newInstance();
        for (Field declaredField : declaredFields) {
            // 获取成员变量名
            String fieldName = declaredField.getName();

            // 2.通过成员变量名到mapData集合获取value
            String[] valueArray = mapData.get(fieldName);

            if (valueArray != null && valueArray.length > 0) {
                // 暴力破解
                declaredField.setAccessible(true);
                if (valueArray.length == 1) {// 获取除checkbox以外的表单元素
                    // 获取到当前成员变量对应的数据
                    String valueStr = valueArray[0];

                    if (declaredField.getType().getName().equals(String.class.getName())) {
                        declaredField.set(entity, valueStr);
                    } else if (declaredField.getType().getName().equals(Integer.class.getName())) {
                        Integer value = DataConvert.stringConvertInteger(valueStr);
                        declaredField.set(entity, value);
                    } else if (declaredField.getType().getName().equals(Float.class.getName())) {
                        Float value = DataConvert.stringConvertFloat(valueStr);
                        declaredField.set(entity, value);
                    } else if (declaredField.getType().getName().equals(Date.class.getName())) {
                        Date value = DataConvert.stringConvertSqlDate(valueStr);
                        declaredField.set(entity, value);
                    }

                } else {
                    String value = "";
                    for (int i = 0; i < valueArray.length; i++) {
                        value += valueArray[i];
                        if (i < valueArray.length - 1) {
                            value += ",";
                        }
                    }
                }
            }
        }
        return entity;
    }

}
