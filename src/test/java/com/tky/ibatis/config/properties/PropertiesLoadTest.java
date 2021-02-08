package com.tky.ibatis.config.properties;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.junit.Test;

import com.tky.ibatis.BaseTest;

/**
 * <a href="https://blog.csdn.net/TangKenny/article/details/113649366">MyBatis
 * 源码解读（二）自定义变量的加载</a>
 * 
 * @author Kenny
 *
 */
public class PropertiesLoadTest extends BaseTest {

	@Override
	public String getResource() {
		return "com/tky/perperties/mybatis-config.xml";
	}

	@Test
	public void testProperties() {
		Properties properties = sqlSessionFactory.getConfiguration().getVariables();
		logger.info(properties.toString());
		assertEquals("kenny", properties.get("system.username"));
	}

}
