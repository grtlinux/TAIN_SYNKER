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
package tain.kr.com.proj.synker.v03.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v02.bean.InfoBean;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SynkerProperties.java
 *   -. Package    : tain.kr.com.proj.synker.v03.util
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
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String get(String key) throws Exception {
		return this.prop.getProperty(key);
	}
	
	public String get(String key, String defValue) throws Exception {
		return this.prop.getProperty(key, defValue);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final String KEY_SYSTEM_RANGE = "tain.kr.synker.system.range";
	private static final String KEY_FOLDER_RANGE = "tain.kr.synker.folder.range";
	
	public List<InfoBean> getListInfoBean() throws Exception {
		
		List<InfoBean> lstInfoBean = new ArrayList<InfoBean>();
		
		int sysBegin = 0;
		int sysEnd = 0;
		int fldBegin = 0;
		int fldEnd = 0;
		
		if (flag) {
			String val = this.prop.getProperty(KEY_SYSTEM_RANGE);
			String[] items = val.split("~");
			
			sysBegin = Integer.parseInt(items[0]);
			sysEnd = Integer.parseInt(items[1]);
		}
		
		if (flag) {
			String val = this.prop.getProperty(KEY_FOLDER_RANGE);
			String[] items = val.split("~");
			
			fldBegin = Integer.parseInt(items[0]);
			fldEnd = Integer.parseInt(items[1]);
		}
		
		if (!flag) log.debug("SYSTEM_RANGE [" + sysBegin + "~" + sysEnd + "], FOLDER_RANGE = [" + fldBegin + "~" + fldEnd + "]");

		for (int sysIdx=sysBegin; sysIdx <= sysEnd; sysIdx ++) {
			String key = null;
			String val = null;

			key = String.format("tain.kr.synker.system.%d", sysIdx);
			val = this.prop.getProperty(key);
			if (val == null)
				continue;
			
			String sysName = val;

			for (int fldIdx=fldBegin; fldIdx <= fldEnd; fldIdx ++) {
				key = String.format("tain.kr.synker.system.%d.folder.%d", sysIdx, fldIdx);
				val = this.prop.getProperty(key);
				if (val == null)
					continue;
				
				String fldName = val;
				
				if (!flag) log.debug(String.format("[SYS, FLD] = [%s, %s]", sysName, fldName));
				
				lstInfoBean.add(new InfoBean(sysName, fldName));
			}
		}
		
		if (!flag) {
			/*
			 * print list of InfoBean
			 */
			
			for (InfoBean bean : lstInfoBean) {
				bean.print();
			}
		}
		
		return lstInfoBean;
	}

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
			List<InfoBean> lstInfoBean = SynkerProperties.getInstance().getListInfoBean();
			
			if (flag) {
				/*
				 * print list of InfoBean
				 */
				
				for (InfoBean bean : lstInfoBean) {
					bean.print();
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
