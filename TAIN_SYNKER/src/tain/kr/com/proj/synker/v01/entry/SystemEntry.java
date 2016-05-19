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
package tain.kr.com.proj.synker.v01.entry;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SystemEntry.java
 *   -. Package    : tain.kr.com.test.filesync.v02.entry
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SystemEntry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SystemEntry.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private String name = new String();
	private Map<String, FolderEntry> folderEntries = new HashMap<String, FolderEntry>();
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String getName() {
		return name;
	}

	public Map<String, FolderEntry> getFolderEntries() {
		return folderEntries;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFolderEntries(Map<String, FolderEntry> folderEntries) {
		this.folderEntries = folderEntries;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public void print() {
		
		if (flag) {
			log.debug("SystemEntry.name = " + name);

			for (Map.Entry<String, FolderEntry> folderEntry : folderEntries.entrySet()) {
				String key = folderEntry.getKey();
				FolderEntry val = folderEntry.getValue();
				
				log.debug(">>> " + key);
				val.print();
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
