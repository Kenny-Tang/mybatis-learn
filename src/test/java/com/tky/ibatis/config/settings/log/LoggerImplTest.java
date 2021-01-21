package com.tky.ibatis.config.settings.log;

import java.util.Properties;

import org.junit.Test;

import com.tky.ibatis.BaseTest;

public class LoggerImplTest extends BaseTest {

	@Override
	public String getResource() {
		return "com/tky/environments/mybatis-config.xml";
	}

	@Test
	public void testProperties() {
		Properties properties = sqlSessionFactory.getConfiguration().getVariables();
		logger.info(properties.toString());
	}

}
