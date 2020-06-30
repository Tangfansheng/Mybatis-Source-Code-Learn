package com.ordo.mybatis.sqlSession.impl;


import com.ordo.mybatis.cfg.Mapper;
import com.ordo.mybatis.proxy.MapperProxy;
import com.ordo.mybatis.sqlSession.SqlSession;
import com.ordo.mybatis.cfg.Configuration;
import com.ordo.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;


public class SqlSessionImpl implements SqlSession {
    Configuration cfg;
    Connection connection;

    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        this.connection  = DataSourceUtil.getConnection(cfg);
    }

    /*
    创建需要的代理对象
    这里需要匹配dao的全类名和configuration中的mapper中的信息
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));

    }

    /*
    释放资源
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
