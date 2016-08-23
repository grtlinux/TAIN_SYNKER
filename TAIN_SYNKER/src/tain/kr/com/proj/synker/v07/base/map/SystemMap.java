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

import tain.kr.com.proj.synker.v07.base.bean.GateBean;
import tain.kr.com.proj.synker.v07.base.bean.SystemBean;
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
public class SystemMap {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SystemMap.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String PROP_FILE = "SystemMap.properties";

	private String propFileName = null;

	private static final String KEY_RANGE = "tain.kr.system.range";
	private static final String KEY_SYSTEM = "tain.kr.system";
	
	private int rangeBeg = -1;
	private int rangeEnd = -1;
	
	private Map<String, SystemBean> mapSystem = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private SystemMap() throws Exception {
		
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
			String values = prop.getProperty(KEY_RANGE, " 01  - 99  ");
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
			 * make a map info of system -> SystemMap
			 */
			
			this.mapSystem = new HashMap<String, SystemBean>();
			
			for (int idx = this.rangeBeg; idx <= this.rangeEnd; idx ++) {
				String systemNo = String.format("%02d", idx);
				String systemKey = KEY_SYSTEM + "." + systemNo + ".info";
				
				String systemStr = prop.getProperty(systemKey);
				if (systemStr == null)
					continue;
				
				String[] info = systemStr.split(";");
				if (info.length != 2)
					continue;
				
				String systemName = info[0].trim();
				String systemDesc = info[1].trim();
				
				SystemBean systemBean = new SystemBean(systemNo, systemName, systemDesc);
				
				if (flag) {
					/*
					 * make a map list of gate -> GateMap
					 */
					for (int subIdx = 1; subIdx <= 10; subIdx ++) {
						String gateNo = String.format("%02d", subIdx);
						String gateKey = KEY_SYSTEM + "." + systemNo + ".gate." + gateNo+ ".info";
						
						String gateStr = prop.getProperty(gateKey);
						if (gateStr == null)
							continue;
						
						String[] items = gateStr.split(";");
						if (items.length != 4)
							continue;
						
						String gateName = items[0].trim();
						String gateFolder = items[1].trim();
						String gateType = items[2].trim();
						String gateDesc = items[3].trim();
						
						systemBean.put(gateNo, new GateBean(gateNo, gateName, gateFolder, gateType, gateDesc));
					}
				}
				
				this.mapSystem.put(systemNo, systemBean);
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
			log.debug("Range Beg : " + this.rangeBeg);
			log.debug("Range End : " + this.rangeEnd);
		}
		
		if (flag) {
			/*
			 * print SystemMap
			 */
			for (Map.Entry<String, SystemBean> entryBean : this.mapSystem.entrySet()) {
				
				String systemKey = entryBean.getKey();
				SystemBean systemBean = entryBean.getValue();

				log.debug(String.format("##### [%s] => %s", systemKey, systemBean));
				
				if (flag) systemBean.printGate();
			}
		}
	}
	
	public SystemBean getBean(String systemName) throws Exception {
		return this.mapSystem.get(systemName);
	}
	
	public Map<String, SystemBean> getMapSystem() {
		return this.mapSystem;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static SystemMap instance = null;
	
	public static synchronized SystemMap getInstance() throws Exception {
		
		if (instance == null) {
			instance = new SystemMap();

			if (flag) {
				/*
				 * print for checking
				 */
				log.debug("############################## SystemMap.Properties ##############################");
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
			 * instance of system map
			 */
			SystemMap.getInstance();
		}
		
		if (flag) {
			log.debug(">>> service of 'syslist' : " + ServiceMap.getInstance().getBean("syslist"));
		}
		
		if (!flag) {
			//log.debug(">>> " + SystemMap.getInstance().getBean("01"));
			log.debug(">>> " + SystemMap.getInstance().getBean("FIRST"));
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
