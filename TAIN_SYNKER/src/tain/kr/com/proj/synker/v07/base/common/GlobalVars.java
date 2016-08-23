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

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v07.base.bean.ServiceBean;
import tain.kr.com.proj.synker.v07.base.map.ServiceMap;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : GlobalVariable.java
 *   -. Package    : tain.kr.com.proj.synker.v06.main.test.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class GlobalVars {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(GlobalVars.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Map<String, String> mapVars;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private GlobalVars() {
		
		this.mapVars = new HashMap<String, String>();
	}
	
	public void setProperties(String serviceName) throws Exception {
		
		if (!flag) log.debug(">>>>> serviceName = " + serviceName);
		
		if (flag) {
			/*
			 * set the GlobalVars
			 */
			ServiceBean bean = ServiceMap.getInstance().getBean(serviceName);
			if (!flag) log.debug(String.format("[%s] => %s", serviceName, bean));
			
			File file = new File(bean.getPropFile());
			if (!file.exists()) {
				String errMsg = "ERROR : couldn't find the properties file [" + bean.getPropFile() + "]";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
			
			Properties prop = new Properties();
			
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream(bean.getPropFile());
				prop.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try { fis.close(); } catch (Exception e) {}
				}
			}
			
			for (Entry<Object, Object> entry : prop.entrySet()) {
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				
				this.mapVars.put(key, value);
			}
		}
	}
	
	public void put(String key, String value) {
		this.mapVars.put(key, value);
	}
	
	public String get(String key) {
		return this.get(key);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("############################## GlobalVars ##############################\n");
		
		for (Map.Entry<String, String> entry : this.mapVars.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			sb.append(String.format("%s = %s\n", key, value));
		}
		
		sb.append("\n");
		
		return sb.toString();
	}
	
	public void print() throws Exception {
		
		if (!flag) log.debug(">>>>> " + toString());
		
		if (flag) {
			log.debug("############################## GlobalVars ##############################");
			
			for (Map.Entry<String, String> entry : this.mapVars.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				
				log.debug(String.format("##### [%s] => [%s]", key, value));
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static GlobalVars instance = null;
	
	public synchronized static GlobalVars getInstance() throws Exception {
		
		if (instance == null) {
			instance = new GlobalVars();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * set values of the GlobalVars 
			 */
			GlobalVars.getInstance().put("author.name", "Seok Kang");
			GlobalVars.getInstance().put("author.age", "33");
			GlobalVars.getInstance().put("author.comment", "Programmer");
		}
		
		if (flag) {
			/*
			 * print the list of the GlobalVars
			 */
			GlobalVars.getInstance().print();
		}
		
		if (flag) {
			/*
			 * change values of the GlobalVars 
			 */
			GlobalVars.getInstance().put("author.age", "30");
			GlobalVars.getInstance().put("author.hobby", "playing");
			GlobalVars.getInstance().put("author.name", "Kiea Seok Kang");
		}
		
		if (flag) {
			/*
			 * print the list of the GlobalVars
			 */
			GlobalVars.getInstance().print();
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * set the GlobalVars from VersionMap.properties
			 */
			GlobalVars.getInstance().setProperties("version");
			GlobalVars.getInstance().setProperties("client");
			GlobalVars.getInstance().setProperties("server");
		}
		
		if (flag) {
			/*
			 * print the list of the GlobalVars
			 */
			GlobalVars.getInstance().print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (!flag) test01(args);
		if (flag) test02(args);
	}
}
