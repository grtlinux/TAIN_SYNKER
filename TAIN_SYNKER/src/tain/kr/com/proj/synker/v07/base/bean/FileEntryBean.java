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
	private final String systemName;   // System Name
	private final String gateName;     // Gate Name
	private final String childPath;    // Child Path or Sub Path
	private final String fileName;     // File Name
	
	/*
	 * entry information
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
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
}
