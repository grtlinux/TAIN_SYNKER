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
package tain.kr.com.proj.synker.v01.util;

import java.util.Date;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v01.entry.FileEntry;
import tain.kr.com.proj.synker.v01.entry.FolderEntry;
import tain.kr.com.proj.synker.v01.entry.SystemEntry;

import com.google.gson.Gson;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : GsonTool.java
 *   -. Package    : tain.kr.com.test.filesync.v01.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 10. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class GsonTool {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(GsonTool.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Gson gson = null;
	
	private GsonTool() {
		if (flag) {
			gson = new Gson();
		}
	}
	
	public Gson instance() throws Exception {
		return this.gson;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static GsonTool instance = null;
	
	public static synchronized GsonTool getInstance() throws Exception {
		
		if (instance == null) {
			instance = new GsonTool();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String strJson = "{ 'name':'tain-cosmarter-1.0.jar', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }";
			
			Gson gson = new Gson();
			FileEntry entry = gson.fromJson(strJson, FileEntry.class);
			entry.print();
			String str = gson.toJson(entry);
			System.out.println("> " + str);
			
			System.out.println("\n\n\n");
		}
		
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
			
			Gson gson = new Gson();
			FolderEntry entry = gson.fromJson(strJson, FolderEntry.class);
			entry.print();
			String str = gson.toJson(entry);
			System.out.println("> " + str);
			
			System.out.println("\n\n\n");
		}
		
		if (flag) {
			String strJson = ""
					+ "{                                                                                                                                                                             "
					+ "    'name' : 'system_name-1',                                                                                                                                                 "
					+ "    'folderEntries' : {                                                                                                                                                       "
					+ "        'FILES' : {                                                                                                                                                           "
					+ "            'name' : 'folder_name-1',                                                                                                                                         "
					+ "            'desc' : 'folder_desc-1',                                                                                                                                         "
					+ "            'fileEntries' : {                                                                                                                                                 "
					+ "               'tain-cosmarter-1.0.jar1' : { 'name':'tain-cosmarter-1.0.jar1', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }, "
					+ "               'tain-cosmarter-1.0.jar2' : { 'name':'tain-cosmarter-1.0.jar2', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }  "
					+ "            }                                                                                                                                                                 "
					+ "        },                                                                                                                                                                    "
					+ "        'cfg' : {                                                                                                                                                             "
					+ "            'name' : 'folder_name-2',                                                                                                                                         "
					+ "            'desc' : 'folder_desc-2',                                                                                                                                         "
					+ "            'fileEntries' : {                                                                                                                                                 "
					+ "               'tain-cosmarter-1.0.jar3' : { 'name':'tain-cosmarter-1.0.jar3', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }, "
					+ "               'tain-cosmarter-1.0.jar4' : { 'name':'tain-cosmarter-1.0.jar4', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }  "
					+ "            }                                                                                                                                                                 "
					+ "        }                                                                                                                                                                     "
					+ "    }                                                                                                                                                                         "
					+ "}                                                                                                                                                                             "
					;
			
			Gson gson = new Gson();
			SystemEntry entry = gson.fromJson(strJson, SystemEntry.class);
			entry.print();
			String str = gson.toJson(entry);
			System.out.println("> " + str);
			
			System.out.println("\n\n\n");
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			FileEntry entry = new FileEntry();
			
			entry.setName("sample.file");
			entry.setPath("/home/test/FILE");
			entry.setSize(10241024);
			entry.setDate(new Date().getTime());
			entry.setCrc(1234567890L);
			entry.setStep(1);
			
			String str = GsonTool.getInstance().instance().toJson(entry);
			
			log.debug(">>>>>" + str + "<<<<<");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		if (flag) test02(args);
	}
}
