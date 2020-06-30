package com.ordo.mybatis.sqlSession.impl;

import com.ordo.mybatis.cfg.Configuration;
import com.ordo.mybatis.sqlSession.SqlSession;
import com.ordo.mybatis.sqlSession.SqlSessionFactory;

public class SqlSessionFactoryImpl implements SqlSessionFactory {
    /*
    创建一个新的操作数据库对象
    params：需要连接数据库的信息
    params: 数据库操作sql以及映射信息
    都封装在了Configuration中了
     */
    private Configuration cfg;

    public SqlSessionFactoryImpl(Configuration cfg) {
        this.cfg = cfg;
    }


    public SqlSession openSession() {
        return new SqlSessionImpl(cfg);
    }
}
