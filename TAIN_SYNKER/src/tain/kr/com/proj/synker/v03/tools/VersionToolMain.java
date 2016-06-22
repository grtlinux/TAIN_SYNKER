/**
 * Copyright 2014, 2015, 2016 TAIN, Inc. all rights reserved.
 *
 * Licensed under the GNU GENERAL PUBLIC LICENSE, Version 3, 29 June 2007 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * -----------------------------------------------------------------
 * Copyright 2014, 2015, 2016 TAIN, Inc.
 *
 */
package tain.kr.com.proj.synker.v03.tools;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v01.common.Version;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : VersionToolMain.java
 *   -. Package    : tain.kr.com.proj.synker.v01.tools
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class VersionToolMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(VersionToolMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final String KEY_DESC = "tain.kr.tools.desc";
	private static final String KEY_TOOL_MAIN = "tain.kr.tools.version.tool.main";
	
	private String desc = null;
	private String toolMain = null;

	private VersionToolMain() throws Exception {
		if (flag) {
			String clsName = this.getClass().getName();
			
			ResourceBundle rb = ResourceBundle.getBundle(clsName.replace('.', '/').replaceAll("VersionToolMain", "tools"));
			
			this.desc = rb.getString(KEY_DESC);
			this.toolMain = rb.getString(KEY_TOOL_MAIN);
		}
	}
	
	public String getDesc() throws Exception {
		return this.desc;
	}
	
	public String getToolMain() throws Exception {
		return this.toolMain;
	}
	
	public void print() throws Exception {
		if (flag) {
			log.info("name     > " + this.getClass().getName());
			log.info("canonical name     > " + this.getClass().getCanonicalName());
			log.info("simple    name     > " + this.getClass().getSimpleName());
			log.info("desc     > " + this.desc);
			log.info("toolMain > " + this.toolMain);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static VersionToolMain instance = null;
	
	public static synchronized VersionToolMain getInstance() throws Exception {
		
		if (instance == null) {
			instance = new VersionToolMain();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Version.getInstance().print();
		}
		
		if (flag) {
			log.debug("* desc = " + Version.getInstance().getDesc());
			log.debug("* date = " + Version.getInstance().getDate());
			log.debug("* version = " + Version.getInstance().getVersion());
		}
		
		if (flag) {
			VersionToolMain.getInstance().print();
		}
		
		if (!flag) {
			/*
			 * TODO : 2016.06.02 : to change for satisfaction
			 */
			Class<?> cls = Class.forName("tain.kr.com.test.clazz.v01.UseMethod");
			Method method = cls.getDeclaredMethod("strAdd", new Class[] { String[].class });
			
			String[] arg = { "One", "Two", "Three", "Four", "Five" };
			String ret = (String) method.invoke(cls.newInstance(), new Object[] { arg });

			if (flag) log.debug(">" + ret);
			if (flag) log.debug("\n-----------------------------------------------\n");
		}
	}

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
