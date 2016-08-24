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
package tain.kr.com.proj.synker.v07.base.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FileEntryBean.java
 *   -. Package    : tain.kr.com.proj.synker.v07.base.bean
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FileEntryBean {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * main key of mapFileEntry
	 */
	private final String mapKey;       // key of map
	
	/*
	 * entry information 1
	 */
	private final String systemName;   // System Name
	private final String gateName;     // Gate Name
	private final String childPath;    // Child Path or Sub Path
	private final String fileName;     // File Name
	
	/*
	 * entry information 2
	 */
	private final long size;          // File size
	private final long date;          // File modified date
	private final long crc;           // File crc value
	
	private final char step;           // Step : (1)Upload / (2)Download / (3)Check
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public FileEntryBean(String systemName, String gateName, String childPath, String fileName, long size, long date, long crc, char step) {
		
		this.systemName = systemName;
		this.gateName = gateName;
		this.childPath = childPath;
		this.fileName = fileName;
		
		this.mapKey = this.systemName + this.gateName + this.childPath + this.fileName;
		
		this.size = size;
		this.date = date;
		this.crc = crc;
		
		this.step = step;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public String getSystemName() {
		return systemName;
	}

	public String getGateName() {
		return gateName;
	}

	public String getChildPath() {
		return childPath;
	}

	public String getFileName() {
		return fileName;
	}

	public long getSize() {
		return size;
	}

	public long getDate() {
		return date;
	}

	public long getCrc() {
		return crc;
	}

	public char getStep() {
		return step;
	}
	
	public String getMapKey() {
		return this.mapKey;
	}
	
	public String toString() {
		return String.format("[KEY,SYS,GATE,PATH,NAME,SIZ,DAT,CRC,STP] = [%s, %s, %s, %s, %s, %d, %d, %d, %c]"
				, this.mapKey
				, this.systemName
				, this.gateName
				, this.childPath
				, this.fileName
				, this.size
				, this.date
				, this.crc
				, this.step
				);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FileEntryBean.class);

	private static void test01(String[] args) throws Exception {
		
		if (!flag) {
			for (int i=0; i < 20; i++) {
				System.out.format("[%3d]%n", (int) (Math.random() * 100));
			}
		}
		
		if (flag) {
			// create
			Map<String, FileEntryBean> mapFileEntry = new HashMap<String, FileEntryBean>();
			
			// put beans into map
			for (int i=0; i < 100; i++) {
				FileEntryBean bean = new FileEntryBean("SYSTEM", "GATE", "SUBPATH", String.format("FILENAME_%02d", (int)(Math.random() * 50)), 12345, 67890, 0, 'C');
				mapFileEntry.put(bean.getMapKey(), bean);
			}
			
			for (Map.Entry<String, FileEntryBean> entry : mapFileEntry.entrySet()) {
				System.out.format("%s%n", entry.getValue());
			}
			
			System.out.format("##### mapFileEntry.size() = %d", mapFileEntry.size());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
