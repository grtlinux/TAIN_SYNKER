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

import tain.kr.com.proj.synker.v05.bean.ServiceBean;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ServiceProperties.java
 *   -. Package    : tain.kr.com.proj.synker.v05.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ServiceProperties {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ServiceProperties.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	private Properties propSystem = null;
	private Properties prop = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String serviceName = null;
	private String strSynkerPropertiesFile = null;
	
	private ServiceProperties() throws Exception {
		
		if (flag) {
			this.serviceName = GlobalParam.getInstance().getServiceName();
			if (this.serviceName == null) {
				String errMsg = "ERROR : there is no service name.";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
		}
		
		if (flag) {
			/*
			 * to get the bean of ServiceBean of the serviceName
			 */
			
			ServiceBean serviceBean = ServiceMap.getInstance().getBean(this.serviceName);
			this.strSynkerPropertiesFile = serviceBean.getPropFile();
		}
		
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
			
			if (this.strSynkerPropertiesFile == null) {
				String errMsg = "ERROR : have no property of the key [" + this.strSynkerPropertiesFile +"]";
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
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static ServiceProperties instance = null;
	
	public static synchronized ServiceProperties getInstance() throws Exception {
		
		if (instance == null) {
			instance = new ServiceProperties();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {

		String serviceName = null;
		serviceName = "server";
		serviceName = "client";
		serviceName = "version";
		
		if (flag) {
			/*
			 * set the value of service name in the global parameters
			 */
			
			GlobalParam.getInstance().setServiceName(serviceName);
		}
		
		if (flag) {
			/*
			 * to print the system properties
			 */
			
			ServiceProperties.getInstance().printSystem();
		}
		
		if (flag) {
			/*
			 * to print the private properties
			 */

			ServiceProperties.getInstance().print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
