package cn.alexander.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionFactoryUtil {
    //单例的对象实例
    private static SqlSessionFactory sessionFactory;
    //私有化构造
    private SessionFactoryUtil(){}
    //对外访问接口(SESSION)
    public static synchronized SqlSession getSession(){
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            if(sessionFactory==null){
                sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory.openSession();
    }
}
