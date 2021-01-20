package com.tky.ibatis.context;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.github.tky.kutils.Dates;
import com.tky.ibatis.mapper.UserMapper;
import com.tky.ibatis.model.User;

public class SqlSessionFactoryTest {
	Logger logger = LoggerFactory.getLogger(SqlSessionFactoryTest.class);
	SqlSessionFactory sqlSessionFactory;

	// @Before
	public void setUp() {
		String resource = "com/tky/environments/mybatis-config.xml";
		try (Reader reader = Resources.getResourceAsReader(resource)) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			logger.info(sqlSessionFactory.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		String resource = "com/tky/environments/mybatis-config.xml";
		try (Reader reader = Resources.getResourceAsReader(resource)) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			System.err.println(sqlSessionFactory.getConfiguration());
			logger.info(sqlSessionFactory.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testProperties() {
		Properties properties = sqlSessionFactory.getConfiguration().getVariables();
		logger.info(properties.toString());
	}

	@Test
	public void testTypeAliasesElement() {
		Map<String, Class<?>> types = sqlSessionFactory.getConfiguration().getTypeAliasRegistry().getTypeAliases();
		logger.info(JSON.toJSONString(types));
	}

	@Test
	public void testPluginElement() {
		Configuration configuration = sqlSessionFactory.getConfiguration();
		List<Interceptor> interceptors = configuration.getInterceptors();
		for (int i = 0; i < interceptors.size(); i++) {
			Interceptor interceptor = interceptors.get(i);
			logger.info(interceptor.toString());
		}
	}

	@Test
	public void testEnvironmentsElement() {
		Configuration configuration = sqlSessionFactory.getConfiguration();
		Environment environment = configuration.getEnvironment();
		logger.info("dataSource: {} .", environment.getDataSource());
		// current databaseId : mysql.
	}

	@Test
	public void testDatabaseIdProvider() {
		Configuration configuration = sqlSessionFactory.getConfiguration();
		String databaseId = configuration.getDatabaseId();
		logger.info("current databaseId : {}.", databaseId);
	}

	@Test
	public void testMapper() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findByUsername("kenny");
		sqlSession.close();
		logger.info(JSON.toJSONString(user));
	}

	@Test
	public void testTimezone() {
		logger.info(Dates.format(new Date(), Dates.FMT_YYYY_MM_DD_HH_MM_SS));
	}
}
