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
package tain.kr.com.proj.synker.v02.bean;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : InfoBean.java
 *   -. Package    : tain.kr.com.proj.synker.v02.bean
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class InfoBean {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(InfoBean.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String systemName = null;
	private String folderName = null;
	
	private String mapKeyName = null;

	///////////////////////////////////////////////////////////////////////////////////////////////

	public InfoBean() {}
	
	public InfoBean(String systemName, String folderName, String mapKeyName) {
		if (flag) {
			this.systemName = systemName;
			this.folderName = folderName;
			this.mapKeyName = mapKeyName;
		}
	}
	
	public InfoBean(String systemName, String folderName) {
		if (flag) {
			this.systemName = systemName;
			this.folderName = folderName;
			this.mapKeyName = this.systemName + "_" + this.folderName;
		}
	}
	
	public String getSystemName() {
		return systemName;
	}

	public String getFolderName() {
		return folderName;
	}

	public String getMapKeyName() {
		return mapKeyName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public void setMapKeyName(String mapKeyName) {
		this.mapKeyName = mapKeyName;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return String.format("[SYS, FLD, KEY] = [%s, %s, %s]", this.systemName, this.folderName, this.mapKeyName);
	}
	
	public void print() {
		if (flag) {
			log.info(toString());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			InfoBean ib = new InfoBean("hello", "world");
			
			ib.print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
