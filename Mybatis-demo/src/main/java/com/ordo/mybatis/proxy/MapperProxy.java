package com.ordo.mybatis.proxy;
import com.ordo.mybatis.cfg.Mapper;
import com.ordo.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;
/*
SqlSession中的代理实现
用SelectList对方法增强
 */


public class MapperProxy implements InvocationHandler {
    Map<String, Mapper> mappers;
    Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className + "." + methodName;

        if (!mappers.containsKey(key)) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        //4.获取mapper
        Mapper mapper = mappers.get(key);
        return new Executor().selectList(mapper, conn);
    }
}
