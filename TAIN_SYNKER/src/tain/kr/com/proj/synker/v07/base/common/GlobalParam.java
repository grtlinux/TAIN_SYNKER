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
package tain.kr.com.proj.synker.v07.base.common;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : GlobalParam.java
 *   -. Package    : tain.kr.com.proj.synker.v06.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class GlobalParam {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(GlobalParam.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String KEY_CONF_FOLDER = "tain.kr.synker.conf.folder";
	private static final String KEY_MAIN_SERVICE = "tain.kr.main.service";
	
	
	/*
	 * Global Fixed Parameters set in command execute file
	 */
	
	private final String confFolder;
	private final String mainService;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private GlobalParam() {
		
		if (flag) {
			/*
			 * SystemProperties
			 */
			Properties prop = System.getProperties();
			
			this.confFolder = prop.getProperty(KEY_CONF_FOLDER, "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER//synker/conf");
			switch (0) {
			case 1:  this.mainService = prop.getProperty(KEY_MAIN_SERVICE, "server"); break;
			case 2:  this.mainService = prop.getProperty(KEY_MAIN_SERVICE, "client"); break;
			default: this.mainService = prop.getProperty(KEY_MAIN_SERVICE, "version"); break;
			}
		} else {
			this.confFolder = "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER//synker/conf";
			this.mainService = "version";
		}
	}
	
	public String getConfFolder() {
		return this.confFolder;
	}

	public String getMainService() {
		return this.mainService;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(String.format("[%s=%s],", KEY_CONF_FOLDER, this.getConfFolder()));
		sb.append(String.format("[%s=%s],", KEY_MAIN_SERVICE, this.getMainService()));
		
		return sb.toString();
	}
	
	public void print() {
		
		if (!flag) {
			log.debug("GlobalParam(Fixed Params) => " + this);
		}
		
		if (flag) {
			log.debug("GlobalParam.getInstance().getConfFolder() = " + this.getConfFolder());
			log.debug("GlobalParam.getInstance().getMainService() = " + this.getMainService());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static GlobalParam instance = null;
	
	public static synchronized GlobalParam getInstance() throws Exception {
		
		if (instance == null) {
			instance = new GlobalParam();
			
			log.debug("############################## GlobalParam ##############################");
			if (flag) instance.print();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * do the first
			 */
			GlobalParam.getInstance();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
