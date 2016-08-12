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
package tain.kr.com.proj.synker.v06.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SynkerProperties.java
 *   -. Package    : tain.kr.com.proj.synker.v04.utils
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SynkerProperties {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SynkerProperties.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Properties propSystem = null;
	private Properties prop = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String KEY_SYNKER_PROPERTIES_FILE = "tain.kr.synker.properties.file";
	private static final String VAL_DEFAULT_FILE = "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/Synker.properties";
	
	private String strSynkerPropertiesFile = null;
	
	private SynkerProperties() throws Exception {
		
		if (flag) {
			/*
			 * SystemProperties
			 */
			this.propSystem = System.getProperties();
		}
		
		if (flag) {
			/*
			 * File Properties
			 */
			if (!flag)
				this.strSynkerPropertiesFile = this.propSystem.getProperty(KEY_SYNKER_PROPERTIES_FILE);
			else
				this.strSynkerPropertiesFile = this.propSystem.getProperty(KEY_SYNKER_PROPERTIES_FILE, VAL_DEFAULT_FILE);
			
			if (this.strSynkerPropertiesFile == null) {
				String errMsg = "ERROR : have no property of the key [" + KEY_SYNKER_PROPERTIES_FILE +"]";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
			
			File file = new File(this.strSynkerPropertiesFile);
			if (!file.exists()) {
				String errMsg = "ERROR : couldn't find the properties file [" + this.strSynkerPropertiesFile + "]";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
			
			this.prop = new Properties();
			
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream(this.strSynkerPropertiesFile);
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
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String getSystem(String key) throws Exception {
		return this.propSystem.getProperty(key);
	}
	
	public String getSystem(String key, String defValue) throws Exception {
		return this.propSystem.getProperty(key, defValue);
	}
	
	public void printSystem() throws Exception {
		
		if (flag) {
			System.out.println("\n\n");
			System.out.println("--------------------------------------- SYSTEM PROPERTIES --------------------------------------------------------");
			this.propSystem.list(System.out);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String get(String key) throws Exception {
		return this.prop.getProperty(key);
	}
	
	public String get(String key, String defValue) throws Exception {
		return this.prop.getProperty(key, defValue);
	}
	
	public void print() throws Exception {
		
		if (flag) {
			System.out.println("\n\n");
			System.out.println("--------------------------------------- PROPERTIES --------------------------------------------------------");
			this.prop.list(System.out);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Properties getProp() throws Exception {
		
		return this.prop;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static SynkerProperties instance = null;
	
	public static synchronized SynkerProperties getInstance() throws Exception {
		
		if (instance == null) {
			instance = new SynkerProperties();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {

		if (flag) {
			/*
			 * to print the system properties
			 */
			
			SynkerProperties.getInstance().printSystem();
		}
		
		if (flag) {
			/*
			 * to print the private properties
			 */

			SynkerProperties.getInstance().print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
