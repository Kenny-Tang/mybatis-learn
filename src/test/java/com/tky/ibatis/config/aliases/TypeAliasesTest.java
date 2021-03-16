package com.tky.ibatis.config.aliases;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.tky.ibatis.BaseTest;
import com.tky.ibatis.model.User;

/**
 * <a href="https://blog.csdn.net/TangKenny/article/details/113649366">MyBatis 源码解读（二）自定义变量的加载</a>
 * 
 * @author Kenny
 *
 */
public class TypeAliasesTest extends BaseTest {

	@Override
	public String getResource() {
		return "com/tky/perperties/mybatis-config.xml";
	}

	@Test
	public void testAliases() {
		Map<String, Class<?>> types = sqlSessionFactory.getConfiguration().getTypeAliasRegistry().getTypeAliases();
		assertEquals(User.class, types.get("typealias_user"));
		assertEquals(User.class, types.get("user"));
	}

}
