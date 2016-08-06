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
package tain.kr.com.proj.synker.v05.main;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v05.util.SynkerProperties;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Main.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
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

	private String clsName = null;
	private String desc = null;
	private String main = null;
	
	private Main() throws Exception {
		
		if (flag) {
			this.clsName = this.getClass().getName();
			
			ResourceBundle rb = ResourceBundle.getBundle(this.clsName.replace('.', '/'));
			
			this.desc = rb.getString(KEY_DESC);
		}
	}
	
	public String getDesc() throws Exception {
		return this.desc;
	}
	
	public void print() throws Exception {
		if (flag) {
			log.info("class name   : " + this.clsName);
			log.info("desc         : " + this.desc);
		}
	}
	
	public void execute(String[] args) throws Exception {
		
		if (flag) {
			for (String arg : args) {
				log.debug("ARG [" + arg + "]");
			}
		}
		
		if (flag) {
			/*
			 * SynkerProperties
			 */
			
			SynkerProperties.getInstance();
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

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * 1st module entry point
			 */
			
			Main.getInstance().execute(args);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
