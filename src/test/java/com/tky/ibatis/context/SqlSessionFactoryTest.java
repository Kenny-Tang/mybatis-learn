package com.tky.ibatis.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.github.tky.kutils.Dates;
import com.tky.ibatis.mapper.UserMapper;
import com.tky.ibatis.model.User;

public class SqlSessionFactoryTest {
    Logger logger = LoggerFactory.getLogger(SqlSessionFactoryTest.class) ;
    SqlSessionFactory sqlSessionFactory ;
    
    @Before
    public void setUp() {
        String  resource = "mybatis-config.xml" ;
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream) ;
            logger.info(sqlSessionFactory.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testProperties() {
        Properties properties = sqlSessionFactory.getConfiguration().getVariables() ;
        logger.info(properties.toString());
    }
    
    @Test
    public void testTypeAliasesElement() {
        Map<String, Class<?>> types = sqlSessionFactory.getConfiguration().getTypeAliasRegistry().getTypeAliases() ;
        logger.info(JSON.toJSONString(types));
    }
    
    @Test
    public void testPluginElement() {
        Configuration configuration = sqlSessionFactory.getConfiguration() ;
        List<Interceptor> interceptors = configuration.getInterceptors() ;
        for (int i = 0; i < interceptors.size(); i++) {
            Interceptor interceptor = interceptors.get(i) ;
            logger.info(interceptor.toString());
        }
    }
    @Test
    public void testMapper() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession() ;
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class) ;
        User user = userMapper.findByUsername("kenny") ;
        sqlSession.close();
        logger.info(JSON.toJSONString(user));
    }
    
    
    @Test
    public void testTimezone() {
        logger.info(Dates.format(new Date(), Dates.FMT_YYYY_MM_DD_HH_MM_SS));
    }
}
