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
package tain.kr.com.proj.synker.v01.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SynkerProp.java
 *   -. Package    : tain.kr.com.proj.synker.v01.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 22. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SynkerProp {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SynkerProp.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private Properties prop = null;
	
	private SynkerProp(String fileName) throws Exception {
		
		if (flag) {
			File file = new File(fileName);
			if (!file.exists()) {
				String errMsg = "ERROR : couldn't find the properties file [" + fileName + "]";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
		}
		
		if (flag) {
			this.prop = new Properties();
			
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream(fileName);
				this.prop.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try { fis.close(); } catch (Exception e) {}
				}
			}
		}
	}

	public String get(String key) throws Exception {
		return this.prop.getProperty(key);
	}
	
	public String get(String key, String defValue) throws Exception {
		return this.prop.getProperty(key, defValue);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static SynkerProp instance = null;
	
	public static synchronized SynkerProp getInstance(String fileName) throws Exception {
		
		if (instance == null) {
			instance = new SynkerProp(fileName);
		}
		
		return instance;
	}
	
	public static synchronized SynkerProp getInstance() throws Exception {
		
		if (instance == null) {
			String errMsg = "ERROR : SynkerProp class instance is null value";
			if (flag) log.error(errMsg);
			if (flag) System.err.println(errMsg);
			
			System.exit(-1);
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String fileName = "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/Synker.properties";  // Synker.properties file
			SynkerProp.getInstance(fileName);
			
			if (flag) log.debug(">>>>> " + SynkerProp.getInstance().get("tain.kr.synker.system.01.folder.01"));
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
