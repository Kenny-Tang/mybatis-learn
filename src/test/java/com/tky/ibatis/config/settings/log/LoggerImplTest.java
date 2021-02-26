package com.tky.ibatis.config.settings.log;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tky.ibatis.BaseTest;

public class LoggerImplTest extends BaseTest {

	@Override
	public String getResource() {
		return "com/tky/settings/log/mybatis-config.xml";
	}

	@Test
	public void log() {
		Class<?> logImpl = sqlSessionFactory.getConfiguration().getLogImpl();
		assertEquals("Slf4jImpl", logImpl.getSimpleName());
	}

}
