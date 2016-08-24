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
package tain.kr.com.proj.synker.v07.base.utils;

import java.util.Map;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v07.base.bean.FileEntryBean;
import tain.kr.com.proj.synker.v07.base.map.FileEntryMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FileEntryMapUtil.java
 *   -. Package    : tain.kr.com.proj.synker.v07.base.utils
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 25. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FileEntryMapUtil {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FileEntryMapUtil.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void printList() throws Exception {
		
		if (flag) {
			/*
			 * print all lists
			 */
			
			for (Map.Entry<String, FileEntryBean> entry : FileEntryMap.getInstance().entrySet()) {
				// String key = entry.getKey();
				FileEntryBean bean = entry.getValue();
				
				if (bean.getType() == 'D') {
					/*
					 * Directory
					 */
					if (flag) System.out.format("[%c] [%-6s] [%-12s] [%-100s]  %15s  [%s]%n"
							, bean.getType()
							, bean.getSystemName()
							, bean.getGateName()
							, bean.getChildPath() + "" + bean.getFileName()
							, ""
							, DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", bean.getDate())
							);
				} else {
					/*
					 * File
					 */
					if (flag) System.out.format("[%c] [%-6s] [%-12s] [%-100s] [%,15d] [%s]%n"
							, bean.getType()
							, bean.getSystemName()
							, bean.getGateName()
							, bean.getChildPath() + "/" + bean.getFileName()
							, bean.getSize()
							, DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", bean.getDate())
							);
				}
			}
		}
	}
	
	public static String getJsonFromMap() throws Exception {
		
		String ret = null;
		
		if (flag) {
			Gson gson = new Gson();
			
			ret = gson.toJson(FileEntryMap.getInstance().getMap());
		}
		
		return ret;
	}
	
	public static Map<String, FileEntryBean> getMapFromJson(String strJson) throws Exception {
		
		Map<String, FileEntryBean> map = null;
		
		if (flag) {
			Gson gson = new Gson();
			
			map = gson.fromJson(strJson, new TypeToken<Map<String, FileEntryBean>>(){}.getType());
		}
		
		return map;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * use json
	 */
	private static void test01(String[] args) throws Exception {
		
		if (!flag) {
			/*
			 * print list of mapFileEntry
			 */
			FileEntryMapUtil.printList();
		}
		
		if (flag) {
			/*
			 * check gson
			 */
			Map<String, FileEntryBean> map1 = FileEntryMap.getInstance().getMap();  // original
			
			String strMap = FileEntryMapUtil.getJsonFromMap();
			
			Map<String, FileEntryBean> map2 = FileEntryMapUtil.getMapFromJson(strMap);
			
			boolean checkOk = true;
			
			for (Map.Entry<String, FileEntryBean> entry : map1.entrySet()) {
				String key = entry.getKey();
				
				if (map2.get(key) == null) {
					
					checkOk = false;
					break;
				}
			}
			
			if (checkOk) {
				System.out.println("to transfer map info using gson : OK");
			} else {
				System.out.println("to transfer map info using gson : FAIL");
			}
		}
		
		if (!flag) {
			/*
			 * string from json
			 */
			String strJson = FileEntryMapUtil.getJsonFromMap();
			System.out.println(strJson);
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * print list of mapFileEntry
			 */
			FileEntryMapUtil.printList();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		if (!flag) test02(args);
	}
}
