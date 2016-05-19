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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v01.util.GsonTool;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FolderEntry.java
 *   -. Package    : tain.kr.com.test.filesync.v02.entry
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FolderEntry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FolderEntry.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private String name = new String();
	private String desc = new String();
	private Map<String, FileEntry> fileEntries = new HashMap<String, FileEntry>();
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public Map<String, FileEntry> getFileEntries() {
		return fileEntries;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setFileEntries(Map<String, FileEntry> fileEntries) {
		this.fileEntries = fileEntries;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public void print() {
		
		if (flag) {
			log.debug("FolderEntry.name = " + name);
			log.debug("FolderEntry.desc = " + desc);
			
			for (Map.Entry<String, FileEntry> fileEntry : fileEntries.entrySet()) {
				String key = fileEntry.getKey();
				FileEntry val = fileEntry.getValue();
				
				log.debug(">>>>> " + key);
				val.print();
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String strJson = ""
					+ "{                                                                                                                                                                     "
					+ "    'name' : 'folder_name-1',                                                                                                                                         "
					+ "    'desc' : 'folder_desc-1',                                                                                                                                         "
					+ "    'fileEntries' : {                                                                                                                                                 "
					+ "       'tain-cosmarter-1.0.jar1' : { 'name':'tain-cosmarter-1.0.jar1', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }, "
					+ "       'tain-cosmarter-1.0.jar2' : { 'name':'tain-cosmarter-1.0.jar2', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }  "
					+ "    }                                                                                                                                                                 "
					+ "}                                                                                                                                                                     "
					;
			
			FolderEntry entry = GsonTool.getInstance().instance().fromJson(strJson, FolderEntry.class);
			entry.print();
			String str = GsonTool.getInstance().instance().toJson(entry);
			System.out.println("> " + str);
			
			System.out.println("\n\n\n");
		}

		if (flag) {
			FileEntry entry1 = new FileEntry();
			entry1.setName("sample.file-1");
			entry1.setPath("/home/test/FILE");
			entry1.setSize(10241024);
			entry1.setDate(new Date().getTime());
			entry1.setCrc(1234567890L);
			entry1.setStep(1);
			
			FileEntry entry2 = new FileEntry();
			entry2.setName("sample.file-2");
			entry2.setPath("/home/test/FILE");
			entry2.setSize(10241024);
			entry2.setDate(new Date().getTime());
			entry2.setCrc(1234567890L);
			entry2.setStep(1);
			
			FileEntry entry3 = new FileEntry();
			entry3.setName("sample.file-3");
			entry3.setPath("/home/test/FILE");
			entry3.setSize(10241024);
			entry3.setDate(new Date().getTime());
			entry3.setCrc(1234567890L);
			entry3.setStep(1);

			FolderEntry entry = new FolderEntry();
			entry.setName("sample.folder");
			entry.setDesc("description");
			entry.getFileEntries().put(entry1.getName(), entry1);
			entry.getFileEntries().put(entry2.getName(), entry2);
			entry.getFileEntries().put(entry3.getName(), entry3);
			
			String str = GsonTool.getInstance().instance().toJson(entry);
			
			log.debug(">>>>>" + str + "<<<<<");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
