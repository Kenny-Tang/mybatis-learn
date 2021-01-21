package com.tky.ibatis.config.properties;

import java.util.Properties;

import org.junit.Test;

import com.tky.ibatis.BaseTest;

public class PropertiesLoadTest extends BaseTest {

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
