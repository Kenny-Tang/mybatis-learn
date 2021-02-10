package com.tky.ibatis.config.vfs;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.ibatis.io.VFS;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Kenny
 *
 */
public class CustomVfsLoadTest {

	public Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testVfs() throws Exception {
		VFS vfs = VFS.getInstance();
		List<String> paths = vfs.list("com/tky/perperties");
		assertTrue(paths.contains("com/tky/perperties/system.properties"));
		logger.info("testVfs : {} .", paths);
	}

}
