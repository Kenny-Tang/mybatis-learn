package com.tky.ibatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {

	protected SqlSessionFactory sqlSessionFactory;
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before
	public void tesCreateSessionFactory() {
		try (Reader reader = Resources.getResourceAsReader(getResource())) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			logger.info(sqlSessionFactory.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract String getResource();
}
