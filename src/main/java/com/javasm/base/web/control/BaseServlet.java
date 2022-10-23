package com.javasm.base.web.control;


import com.javasm.base.annotation.RequestParam;
import com.javasm.base.util.DataConvert;
import com.javasm.base.util.RequestDataConvertEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.ParseException;
import java.util.Map;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/10/8-16:10
 * @Since：jdk1.8
 * @Description：
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 methodName （子类中的方法的方法名）
        String methodName = req.getParameter("methodName");


        try {
            // 获取子类的Method
            Method method = getMethod(methodName);

            if (method != null) {
                // 获取所有需要传递到method中的参数列表
                Object[] methodParameters = getMethodParameters(method, req, resp);
                // 调用子类的方法
                Object result = method.invoke(this, methodParameters);

                // 将子类中的方法的放回值响应到页面
                if (result != null && result.getClass().getName().equals(String.class.getName())) {
                    PrintWriter out = resp.getWriter();
                    out.write(result.toString());
                    out.flush();
                    out.close();
                }
            } else {
                resp.sendError(404, "要调用的方法还未实现（通过 methodName 为在子类中找Method）");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取子类中要调用的方法
     *
     * @param methodName
     * @return
     */
    public Method getMethod(String methodName) {
        // 获取子类的Class
        Class sonServletClass = this.getClass();
        // 获取子类中所有的方法
        Method[] methods = sonServletClass.getDeclaredMethods();
        //  遍历 methods
        for (Method method : methods) {
            //  如果方法名和methodName返回当前的 method
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }

    /**
     * 获取参数数据
     *
     * @param method
     * @param request
     * @param response
     * @return
     */
    public Object[] getMethodParameters(Method method, HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, ParseException, InstantiationException {
        // 实例化返回值，method.getParameterCount()：获取方法上参数个数
        Object[] objects = new Object[method.getParameterCount()];

        if (method.getParameterCount() > 0) {
            // 获取 参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            Parameter[] parameters = method.getParameters();

            // 遍历 parameterTypes
            for (int i = 0; i < parameterTypes.length; i++) {
                // 获取 参数类型
                Class parameterClazz = parameterTypes[i];


                if (parameterClazz.getName().equals(HttpServletRequest.class.getName())) {
                    objects[i] = request;
                } else if (parameterClazz.getName().equals(HttpServletResponse.class.getName())) {
                    objects[i] = response;
                } else if (parameterClazz.getName().equals(HttpSession.class.getName())) {
                    objects[i] = request.getSession();
                } else if (parameterClazz.getName().contains("entity") || parameterClazz.getName().contains("bean") || parameterClazz.getName().contains("pojo")) {
                    // 获取页面提交到服务器的所有的数据
                    Map<String, String[]> parameterMap = request.getParameterMap();
                    // 将 parameterMap 存储到Usesrinfo
                    Object obj = RequestDataConvertEntity.mapConvertEntity(parameterClazz, parameterMap);
                    objects[i] = obj;
                } else if (parameterClazz.getName().equals(String.class.getName())) {
                    // 获取当前参数对象
                    Parameter parameter = parameters[i];
                    // 获取参数上的注解 ServletMethodParameterName
                    RequestParam parameterAnnotation = parameter.getAnnotation(RequestParam.class);
                    if (parameterAnnotation != null) {
                        // 获取 客户端提交到服务器的name
                        String name = parameterAnnotation.value();
                        // 获取客户端提交到服务器的数据
                        String value = request.getParameter(name);

//                        System.out.println(value);
                        objects[i] = value;
                    }
                } else if (parameterClazz.getName().equals(Integer.class.getName())) {
                    // 获取当前参数对象
                    Parameter parameter = parameters[i];
                    // 获取参数上的注解 ServletMethodParameterName
                    RequestParam parameterAnnotation = parameter.getAnnotation(RequestParam.class);
                    if (parameterAnnotation != null) {
                        // 获取 客户端提交到服务器的name
                        String name = parameterAnnotation.value();
                        // 获取客户端提交到服务器的数据
                        String value = request.getParameter(name);

//                        System.out.println(value);
                        objects[i] = DataConvert.stringConvertInteger(value);
                    }
                }

            }

        }

        return objects;

    }

}
