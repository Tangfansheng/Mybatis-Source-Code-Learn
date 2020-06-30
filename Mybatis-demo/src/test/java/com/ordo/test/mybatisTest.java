package com.ordo.test;


import com.ordo.domain.User;
import com.ordo.mapper.UserMapper;
import com.ordo.mybatis.io.Resources;
import com.ordo.mybatis.sqlSession.SqlSession;
import com.ordo.mybatis.sqlSession.SqlSessionFactory;
import com.ordo.mybatis.sqlSession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);//代理模式
        List<User> userlist = mapper.findAll();
        for (User user : userlist) {
            System.out.println(user.toString());
        }
    }
}
