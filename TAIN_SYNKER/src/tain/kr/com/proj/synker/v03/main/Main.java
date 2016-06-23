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
package tain.kr.com.proj.synker.v03.main;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v01.common.Version;
import tain.kr.com.proj.synker.v03.util.SynkerProperties;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Main.java
 *   -. Package    : tain.kr.com.test.filesync.v02.main
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final String KEY_DESC = "tain.kr.main.desc";
	private static final String KEY_MAIN = "tain.kr.main";
	
	private String desc = null;
	private String main = null;

	private Main() throws Exception {
		
		if (flag) {
			String clsName = this.getClass().getName();
			
			ResourceBundle rb = ResourceBundle.getBundle(clsName.replace('.', '/'));
			
			this.desc = rb.getString(KEY_DESC);
		}
		
		if (flag) {
			/*
			 * to get the value of a main key
			 */
			this.main = SynkerProperties.getInstance().getSystem(KEY_MAIN);
			if (this.main == null) {
				String errMsg = "ERROR : there is no main entry value of a key [" + KEY_MAIN + "] : ex) java -Dtain.kr.main=..... -jar tain-synker-1.0.jar";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
			
			if (flag) log.debug("main entry value -> " + this.main);
		}
		
		if (flag) {
			/*
			 * to execute the main program from the value of a main key
			 */
			Class<?> cls = Class.forName(main);
			if (cls == null) {
				String errMsg = "ERROR : there is no class.. Not found [" + this.main + "]";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
			
			Method method = cls.getDeclaredMethod("execute", new Class[] { String[].class });
			if (method == null) {
				String errMsg = "ERROR : there is no method.. Not found [execute]";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
			
			/*
			 * to execute
			 */
			String[] arg = { "FileSynker" };
			Integer ret = (Integer) method.invoke(cls.newInstance(), new Object[] { arg });    // RUN 

			if (flag) log.debug("STATUS : return value of execute = " + ret);
		}
	}
	
	public String getDesc() throws Exception {
		return this.desc;
	}
	
	public void print() throws Exception {
		if (flag) {
			log.info("desc    > " + this.desc);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static Main instance = null;
	
	public static synchronized Main getInstance() throws Exception {
		
		if (instance == null) {
			instance = new Main();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (!flag) {
			/*
			 * old version before 2016.06.22
			 */
			Main.getInstance().print();
			Version.getInstance().print();
		}
		
		if (flag) {
			Main.getInstance();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
