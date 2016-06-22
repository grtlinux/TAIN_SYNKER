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
package tain.kr.com.proj.synker.v02.util;

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
 *   -. FileName   : SynkerProp.java
 *   -. Package    : tain.kr.com.proj.synker.v01.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 22. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SynkerProp {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SynkerProp.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private Properties prop = null;
	
	private SynkerProp(String fileName) throws Exception {
		
		if (flag) {
			File file = new File(fileName);
			if (!file.exists()) {
				String errMsg = "ERROR : couldn't find the properties file [" + fileName + "]";
				if (flag) log.error(errMsg);
				if (flag) System.err.println(errMsg);
				
				System.exit(-1);
			}
		}
		
		if (flag) {
			this.prop = new Properties();
			
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream(fileName);
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
	
	private static SynkerProp instance = null;
	
	public static synchronized SynkerProp getInstance(String fileName) throws Exception {
		
		if (instance == null) {
			instance = new SynkerProp(fileName);
		}
		
		return instance;
	}
	
	public static synchronized SynkerProp getInstance() throws Exception {
		
		if (instance == null) {
			String errMsg = "ERROR : SynkerProp class instance is null value";
			if (flag) log.error(errMsg);
			if (flag) System.err.println(errMsg);
			
			System.exit(-1);
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (!flag) {
			String fileName = "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/Synker.properties";  // Synker.properties file
			SynkerProp.getInstance(fileName);
			
			if (flag) log.debug(">>>>> " + SynkerProp.getInstance().get("tain.kr.synker.system.1.folder.1"));
		}
		
		if (flag) {
			String fileName = "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/Synker.properties";  // Synker.properties file
			SynkerProp.getInstance(fileName);
			
			List<InfoBean> lstInfoBean = SynkerProp.getInstance().getListInfoBean();
			
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
