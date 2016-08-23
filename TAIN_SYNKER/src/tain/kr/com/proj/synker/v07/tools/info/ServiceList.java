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
package tain.kr.com.proj.synker.v07.tools.info;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v07.base.map.ServiceMap;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ServiceList.java
 *   -. Package    : tain.kr.com.proj.synker.v07.tools.info
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ServiceList {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ServiceList.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String KEY_DESC = "tain.kr.service.list.desc";
	private static final String KEY_DATE = "tain.kr.service.list.date";
	private static final String KEY_VERSION = "tain.kr.service.list.ver";
	
	private String desc = null;
	private String date = null;
	private String version = null;
	
	public ServiceList() throws Exception {
		if (flag) {
			String clsName = this.getClass().getName();
			
			ResourceBundle rb = ResourceBundle.getBundle(clsName.replace('.', '/'));
			
			this.desc = rb.getString(KEY_DESC);
			this.date = rb.getString(KEY_DATE);
			this.version = rb.getString(KEY_VERSION);
		}
	}
	
	public String getDesc() throws Exception {
		return this.desc;
	}
	
	public String getDate() throws Exception {
		return this.date;
	}
	
	public String getVersion() throws Exception {
		return this.version;
	}
	
	public void print() throws Exception {
		if (flag) {
			/*
			 * base properties
			 */
			log.info("desc    > " + this.desc);
			log.info("date    > " + this.date);
			log.info("version > " + this.version);
		}
		
		if (flag) {
			/*
			 * 
			 */
			ServiceMap.getInstance();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static ServiceList instance = null;
	
	public static synchronized ServiceList getInstance() throws Exception {
		
		if (instance == null) {
			instance = new ServiceList();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			ServiceList.getInstance().print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
