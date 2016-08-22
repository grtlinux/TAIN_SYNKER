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
package tain.kr.com.proj.synker.v07.base.map;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v07.base.bean.ServiceBean;
import tain.kr.com.proj.synker.v07.base.common.GlobalParam;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ServiceMap.java
 *   -. Package    : tain.kr.com.proj.synker.v06.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ServiceMap {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ServiceMap.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String PROP_FILE = "ServiceMap.properties";

	private String propFileName = null;
	
	private static final String KEY_RANGE = "tain.kr.service.range";
	private static final String KEY_SERVICE = "tain.kr.service";
	
	private int rangeBeg = -1;
	private int rangeEnd = -1;
	
	private Map<String, ServiceBean> mapService = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private ServiceMap() throws Exception {
		
		Properties prop = null;
		
		if (flag) {
			/*
			 * get the properties information
			 */
			this.propFileName = GlobalParam.getInstance().getConfFolder() + "/" + PROP_FILE;

			File file = new File(this.propFileName);
			if (!file.exists()) {
				String errMsg = "ERROR : couldn't find the properties file [" + this.propFileName + "]";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
			
			prop = new Properties();
			
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream(this.propFileName);
				prop.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try { fis.close(); } catch (Exception e) {}
				}
			}
		}
		
		if (flag) {
			/*
			 * to get the values of range
			 */
			String values = prop.getProperty(KEY_RANGE, " 01 - 99  ");
			String[] value = values.split("-");
			
			this.rangeBeg = Integer.parseInt(value[0].trim());
			this.rangeEnd = Integer.parseInt(value[1].trim());
		}
		
		if (!flag) {
			/*
			 * TODO 2016.08.06
			 * validate the value of range
			 */
		}
		
		if (flag) {
			/*
			 * make a map info of service
			 */
			
			mapService = new HashMap<String, ServiceBean>();
			
			for (int idx = this.rangeBeg; idx <= this.rangeEnd; idx ++) {
				String serviceNo = String.format("%02d", idx);
				String serviceKey = KEY_SERVICE + "." + serviceNo;
				
				String serviceStr = prop.getProperty(serviceKey);
				if (serviceStr == null)
					continue;
				
				String[] info = serviceStr.split(";");
				if (info.length != 3)
					continue;
				
				String serviceName = info[0].trim();
				String serviceClass = info[1].trim();
				String propFile = info[2].trim();
				
				mapService.put(serviceName, new ServiceBean(serviceNo, serviceName, serviceClass, propFile));
			}
		}
		
		if (!flag) {
			/*
			 * validate the service map
			 */
		}
	}
	
	public void print() throws Exception {
		
		if (flag) {
			log.debug("Range Beg   : " + this.rangeBeg);
			log.debug("Range End   : " + this.rangeEnd);
		}
		
		if (flag) {
			for (Map.Entry<String, ServiceBean> entryBean : this.mapService.entrySet()) {
				log.debug(">>>>> [" + entryBean.getKey() + "]  " + entryBean.getValue());
			}
		}
	}
	
	public ServiceBean getBean(String serviceName) throws Exception {
		return this.mapService.get(serviceName);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static ServiceMap instance = null;
	
	public static synchronized ServiceMap getInstance() throws Exception {
		
		if (instance == null) {
			instance = new ServiceMap();
			
			if (flag) {
				/*
				 * print for checking
				 */
				log.debug("############################## ServiceMap.Properties ##############################");
				instance.print();
			}
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * instance of service map
			 */
			ServiceMap.getInstance();
		}
		
		if (flag) {
			log.debug(">>> service of 'version' : " + ServiceMap.getInstance().getBean("version"));
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			String str = "  01 - 05  ";
			String[] items = str.split("\\s*-\\s*");
			
			for (String item : items) {
				log.debug(">>>>> [" + item + "]");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		if (!flag) test02(args);
	}
}
