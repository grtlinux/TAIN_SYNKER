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
package tain.kr.com.proj.synker.v03.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v02.util.SynkerProp;
import tain.kr.com.proj.synker.v03.bean.EntryBean;
import tain.kr.com.proj.synker.v03.bean.InfoBean;
import tain.kr.com.proj.synker.v03.util.SynkerProperties;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : EntryTest02Main.java
 *   -. Package    : tain.kr.com.proj.synker.v02.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class EntryTest02Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(EntryTest02Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private List<InfoBean> lstInfoBean = null;

	private List<String> lstMapKey = new ArrayList<String>();
	private Map<String, EntryBean> mapEntryBean = new HashMap<String, EntryBean>();
	
	private EntryTest02Main() throws Exception {}
	
	public void execute() throws Exception {
		
		if (flag) {
			this.lstInfoBean = SynkerProperties.getInstance().getListInfoBean();

			if (!flag) {
				for (InfoBean bean : this.lstInfoBean) {
					bean.print();
				}
			}
		}
		
		if (flag) {
			for (InfoBean bean : this.lstInfoBean) {
				if (!flag) bean.print();
				
				getEntries(bean.getSystemName(), bean.getFolderName());
			}
			
			if (flag) log.debug("lstMapKey.size() = " + lstMapKey.size() + ", mapEntryBean.size() = " + mapEntryBean.size());
		}
	}

	private void getEntries(String sysName, String fldName) throws Exception {
		
		if (!flag) log.debug(String.format("FOLDER (SYS, FLD) = (%s, %s)", sysName, fldName));
		
		if (flag) {
			File file = new File(fldName);
			File[] files = null;
			
			try {
				files = file.listFiles(new FileFilter() {
					@Override
					public boolean accept(File file) {
						return true;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
			
			for (File f : files) {
				if (f.isDirectory()) {
					/*
					 * folder
					 */
					getEntries(sysName, f.getPath());
				} else {
					/*
					 * file
					 */
					getEntry(sysName, f);
				}
			}
		}
	}
	
	private void getEntry(String sysName, File file) throws Exception {
		
		if (!flag) log.debug(String.format("FILE (SYS, FILE) = (%s, %s)", sysName, file.getPath()));

		if (!flag) {
			String mapKeyName = String.format("%s_%s_%s", sysName, file.getParent(), file.getName());
			if (!flag) log.debug("mapKeyName = " + mapKeyName);
			
			if (!flag) lstMapKey.add(mapKeyName);
			
			if (flag) mapEntryBean.put(mapKeyName, null);
		}
		
		if (flag) {
			String mapKeyName = String.format("%s_%s_%s", sysName, file.getParent(), file.getName());
			long crc = 0;

			if (flag) {
				// CRC value of file - 2
				FileInputStream fis = new FileInputStream(file.getPath());
				
				byte[] bytBuffer = new byte[1024];
				int n;
				
				while ((n = fis.read(bytBuffer)) >= 0) {
					for (int i=0; i < n; i++) {
						crc += (int) (0xFF & bytBuffer[i]);
					}
				}
				
				fis.close();
			}

			EntryBean bean = new EntryBean();
			
			bean.setSystemName(sysName);
			bean.setFolderName(file.getParent());
			bean.setFileName(file.getName());
			bean.setMapKeyName(mapKeyName);
			bean.setSize(file.length());
			bean.setDate(file.lastModified());
			bean.setCrc(crc);
			bean.setStep(1);
			
			if (flag) mapEntryBean.put(mapKeyName, bean);
		}
	}
	
	public void print() throws Exception {
		
		if (flag) {
			log.info("print.....");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static EntryTest02Main instance = null;
	
	public static synchronized EntryTest02Main getInstance() throws Exception {
		
		if (instance == null) {
			instance = new EntryTest02Main();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String fileName = "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/Synker.properties";  // Synker.properties file
			SynkerProp.getInstance(fileName);
		}
		
		if (flag) {
			for (int i=0; i < 1000; i++) {
				EntryTest02Main.getInstance().execute();
				
				try { Thread.sleep(5000); } catch (InterruptedException e) {}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
