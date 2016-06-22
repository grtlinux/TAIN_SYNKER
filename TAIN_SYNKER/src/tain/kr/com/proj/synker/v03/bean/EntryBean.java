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
package tain.kr.com.proj.synker.v03.bean;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : EntryBean.java
 *   -. Package    : tain.kr.com.proj.synker.v02.bean
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class EntryBean {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(EntryBean.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private String systemName = null;   // system name
	private String folderName = null;   // folder name
	private String fileName = null;     // file name
	
	private String mapKeyName = null;   // map key name

	private long size = 0;        // file size
	private long date = 0;        // file mdate
	private long crc = 0;         // file crc value
	
	private int step = 0;         // step
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public EntryBean() {}

	public String getSystemName() {
		return systemName;
	}


	public String getFolderName() {
		return folderName;
	}


	public String getFileName() {
		return fileName;
	}


	public String getMapKeyName() {
		return mapKeyName;
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


	public int getStep() {
		return step;
	}


	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}


	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public void setMapKeyName(String mapKeyName) {
		this.mapKeyName = mapKeyName;
	}


	public void setSize(long size) {
		this.size = size;
	}


	public void setDate(long date) {
		this.date = date;
	}


	public void setCrc(long crc) {
		this.crc = crc;
	}


	public void setStep(int step) {
		this.step = step;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return String.format("[SYS, FLD, FILE, KEY, SIZE, DT, CRC, STP] = [%s, %s, %s, %s, %d, %d, %d, %d]"
				, this.systemName, this.folderName, this.fileName, this.mapKeyName
				, this.size, this.date, this.crc, this.step);
	}
	
	public void print() {
		if (flag) {
			log.info(toString());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////


	private static void test01(String[] args) throws Exception {
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
