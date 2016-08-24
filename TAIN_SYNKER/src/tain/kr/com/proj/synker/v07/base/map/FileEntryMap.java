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
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v07.base.bean.FileEntryBean;
import tain.kr.com.proj.synker.v07.base.bean.GateBean;
import tain.kr.com.proj.synker.v07.base.bean.SystemBean;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FileEntryMap.java
 *   -. Package    : tain.kr.com.proj.synker.v07.base.map
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FileEntryMap {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FileEntryMap.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Map<String, FileEntryBean> mapFileEntry = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private FileEntryMap() throws Exception {
		
		if (flag) {
			/*
			 * create mapFileEntry map
			 */
			createMapFileEntry();
		}
		
		if (flag) {
			/*
			 * print mapFileEntry
			 */
			
			for (Map.Entry<String, FileEntryBean> entry : this.mapFileEntry.entrySet()) {
				String key = entry.getKey();
				FileEntryBean bean = entry.getValue();
				
				System.out.format("[%s] => %s%n", key, bean);
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private String systemName;
	private String gateName;
	private String parentPath;
	private int sizParentPath;
	private String childPath;
	private String fileName;
	
	private long size;
	private long date;
	private long crc;
	
	private char step;
	private char type;
	
	private void createMapFileEntry() throws Exception {
		
		if (flag) {
			/*
			 * create mapFileEntry
			 */
			if (this.mapFileEntry == null) {
				this.mapFileEntry = new HashMap<String, FileEntryBean>();
			}
		}
		
		if (flag) {
			/*
			 * 
			 */
			Map<String, SystemBean> mapSystem = SystemMap.getInstance().getMapSystem();
			
			for (Map.Entry<String, SystemBean> entrySystem : mapSystem.entrySet()) {
				String keySystem = entrySystem.getKey();
				SystemBean beanSystem = entrySystem.getValue();
				
				if (!flag) log.debug(String.format(">>>>> [%s] = [%s]", keySystem, beanSystem));
				
				Map<String, GateBean> mapGate = beanSystem.getMapGate();
				
				for (Map.Entry<String, GateBean> entryGate : mapGate.entrySet()) {
					String keyGate = entryGate.getKey();
					GateBean beanGate = entryGate.getValue();
					
					if (!flag) log.debug(String.format(">>>>>>>>>> [%s] = [%s]", keyGate, beanGate));
					
					this.systemName = beanSystem.getSystemName();
					this.gateName = beanGate.getGateName();
					this.parentPath = beanGate.getGateFolder();
					this.sizParentPath = parentPath.length();
					
					if (flag) log.debug(String.format("[%s] [%s] [%s](%d)", this.systemName, this.gateName, this.parentPath, this.sizParentPath));
					
					
					if (flag) {
						/*
						 * TODO 2016.08.24
						 */

						fileEntryBean(new File(this.parentPath));
					}
					
					if (flag) return;
				}
			}
		}
	}
	
	private void fileEntryBean(File folder) throws Exception {
		
		if (flag) {
			try {
				folder.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File file) {
						
						if (flag) {
							/*
							 * logic for checking filters
							 */
						}
						
						makeFileEntry(file);
						
						if (file.isDirectory()) {
							try {
								fileEntryBean(file);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						
						return false;
					}
					
					/*
					 * make FileEntry
					 */
					private void makeFileEntry(File file) {
						
						if (flag) {
							/*
							 * new FileEntryBean
							 */
							String fullName = file.getAbsolutePath().replace('\\', '/');
							if (!flag) log.debug(">>>>> " + fullName);
							
							if (file.isDirectory()) {
								childPath = fullName.substring(sizParentPath);
								fileName = "";
								size = 0;
								date = file.lastModified();
								crc = 0;
								step = 'C';
								type = 'D';
							} else {
								int last = fullName.lastIndexOf('/');
								
								childPath = fullName.substring(sizParentPath, last);
								fileName = fullName.substring(last+1);
								size = file.length();
								date = file.lastModified();
								crc = 0;
								step = 'C';
								type = 'F';
							}

							if (!flag) log.debug(String.format(">>>>>>>>>> [%s] [%s] [%s] [%s] [%s] [%d] [%d] [%d] [%c] [%c]"
									, systemName
									, gateName
									, parentPath
									, childPath
									, fileName
									, size
									, date
									, crc
									, step
									, type
									));
							
							FileEntryBean bean = new FileEntryBean(systemName, gateName, parentPath, childPath, fileName, size, date, crc, step, type);
							
							mapFileEntry.put(bean.getMapKey(), bean);
						}
					}
				});
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static FileEntryMap instance = null;
	
	public static synchronized FileEntryMap getInstance() throws Exception {
		
		if (instance == null) {
			instance = new FileEntryMap();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * instance of system map
			 */
			FileEntryMap.getInstance();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
