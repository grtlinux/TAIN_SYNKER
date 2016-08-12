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

import tain.kr.com.proj.synker.v05.bean.ServiceBean;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ServiceMap.java
 *   -. Package    : tain.kr.com.proj.synker.v05.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TrMap {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TrMap.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String KEY_RANGE = "tain.kr.service.range";
	private static final String KEY_SERVICE = "tain.kr.service";
	
	private int rangeBegin = -1;
	private int rangeEnd = -1;
	
	private Map<String, ServiceBean> mapService = null;
	
	private TrMap() throws Exception {
		
		if (flag) {
			/*
			 * to get the values of range
			 */
			String values = SynkerProperties.getInstance().get(KEY_RANGE);
			String[] value = values.split("-");
			
			this.rangeBegin = Integer.parseInt(value[0].trim());
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
			
			for (int idx = this.rangeBegin; idx <= this.rangeEnd; idx ++) {
				String serviceNo = String.format("%02d", idx);
				String serviceKey = KEY_SERVICE + "." + serviceNo;
				
				String serviceStr = SynkerProperties.getInstance().get(serviceKey);
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
			log.debug("Range Begin : " + this.rangeBegin);
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
	///////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static TrMap instance = null;
	
	public static synchronized TrMap getInstance() throws Exception {
		
		if (instance == null) {
			instance = new TrMap();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (!flag) {
			String str = "  01 - 05  ";
			String[] items = str.split("\\s*-\\s*");
			
			for (String item : items) {
				log.debug(">>>>> [" + item + "]");
			}
		}
		
		if (flag) {
			TrMap.getInstance().print();
		}
		
		if (flag) {
			log.debug(">>> " + TrMap.getInstance().getBean("version"));
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
