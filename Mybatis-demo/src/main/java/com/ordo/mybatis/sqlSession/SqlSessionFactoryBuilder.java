package com.ordo.mybatis.sqlSession;

import com.ordo.mybatis.cfg.Configuration;
import com.ordo.mybatis.sqlSession.impl.SqlSessionFactoryImpl;
import com.ordo.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream in) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new SqlSessionFactoryImpl(cfg);
    }
}
