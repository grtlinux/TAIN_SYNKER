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
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v07.base.bean.TrBean;
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
public class TrMap {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TrMap.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String PROP_FILE = "TrMap.properties";

	private String propFileName = null;
	
	private static final String KEY_MAP_STR = "tain.kr.tr.map.";
	
	private Map<String, TrBean> mapTr = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private TrMap() throws Exception {
		
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
			
			mapTr = new HashMap<String, TrBean>();
			
			for (Entry<Object, Object> entry : prop.entrySet()) {
				String key = (String) entry.getKey();
				if (!key.startsWith(KEY_MAP_STR))
					continue;
				
				/*
				 * tr map contents
				 */
				String trKey = key.substring(KEY_MAP_STR.length());
				String value = (String) entry.getValue();
				
				String[] vals = value.split(";");
				
				String name = vals[0].trim();
				String clsClass = vals[1].trim();
				String svrClass = vals[2].trim();
				String desc = vals[3].trim();
				
				mapTr.put(trKey, new TrBean(trKey, name, clsClass, svrClass, desc));
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
			for (Map.Entry<String, TrBean> entryBean : this.mapTr.entrySet()) {
				log.debug(String.format("##### [%s] => [%s]", entryBean.getKey(), entryBean.getValue()));
			}
		}
	}
	
	public TrBean getBean(String trName) throws Exception {
		return this.mapTr.get(trName);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static TrMap instance = null;
	
	public static synchronized TrMap getInstance() throws Exception {
		
		if (instance == null) {
			instance = new TrMap();

			if (flag) {
				/*
				 * print for checking
				 */
				log.debug("############################## TrMap.Properties ##############################");
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
			 * 
			 */
			TrMap.getInstance();
		}
		
		if (flag) {
			log.debug(">>> TR information of 'TT0000' " + TrMap.getInstance().getBean("TT0000"));
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
