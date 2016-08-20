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

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v06.bean.SystemBean;

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
	
	private static final String KEY_RANGE = "tain.kr.system.range";
	private static final String KEY_SERVICE = "tain.kr.system";
	
	private int rangeBeg = -1;
	private int rangeEnd = -1;
	
	private Map<String, SystemBean> mapSystem = null;
	
	private SystemMap() throws Exception {
		
		if (flag) {
			/*
			 * to get the values of range
			 */
			String values = SynkerProperties.getInstance().get(KEY_RANGE);
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
			
			mapSystem = new HashMap<String, SystemBean>();
			
			for (int idx = this.rangeBeg; idx <= this.rangeEnd; idx ++) {
				String systemNo = String.format("%02d", idx);
				String systemKey = KEY_SERVICE + "." + systemNo + ".info";
				
				String systemStr = SynkerProperties.getInstance().get(systemKey);
				if (systemStr == null)
					continue;
				
				String[] info = systemStr.split(";");
				if (info.length != 2)
					continue;
				
				String systemName = info[0].trim();
				String systemDesc = info[1].trim();
				
				mapSystem.put(systemName, new SystemBean(systemNo, systemName, systemDesc));
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
			for (Map.Entry<String, SystemBean> entryBean : this.mapSystem.entrySet()) {
				
				String systemKey = entryBean.getKey();
				SystemBean systemBean = entryBean.getValue();

				log.debug(">>>>> [" + systemKey + "]  " + systemBean);
				
				if (flag) {
					systemBean.printGate();
				}
			}
		}
	}
	
	public SystemBean getBean(String systemName) throws Exception {
		return this.mapSystem.get(systemName);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static SystemMap instance = null;
	
	public static synchronized SystemMap getInstance() throws Exception {
		
		if (instance == null) {
			instance = new SystemMap();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String str = "  01 - 05  ";
			String[] items = str.split("\\s*-\\s*");
			
			for (String item : items) {
				log.debug(">>>>> [" + item + "]");
				log.debug(">>>>> [" + item.trim() + "]");
			}
		}
		
		if (flag) {
			SystemMap.getInstance().print();
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
