package com.ordo.mybatis.sqlSession;



public interface SqlSession {
    /*
    根据一个dao接口的字节码文件创建代理对象
     */
    public <T> T getMapper (Class<T> daoInterfaceClass);
    public void close();
}
