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
package tain.kr.com.proj.synker.v07.base.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : GlobalVariable.java
 *   -. Package    : tain.kr.com.proj.synker.v06.main.test.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class GlobalVars {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(GlobalVars.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Map<String, String> mapVars;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private GlobalVars() {
		
		this.mapVars = new HashMap<String, String>();
	}
	
	public void put(String key, String value) {
		this.mapVars.put(key, value);
	}
	
	public String get(String key) {
		return this.get(key);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("############################## GlobalParam ##############################\n");
		
		for (Map.Entry<String, String> entry : this.mapVars.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			sb.append(String.format("\t[%s] => [%s]\n", key, value));
		}
		
		sb.append("\n");
		
		return sb.toString();
	}
	
	public void print() throws Exception {
		
		if (flag) log.debug(">>>>> " + toString());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static GlobalVars instance = null;
	
	public synchronized static GlobalVars getInstance() throws Exception {
		
		if (instance == null) {
			instance = new GlobalVars();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * set values of the GlobalVars 
			 */
			GlobalVars.getInstance().put("author.name", "Seok Kang");
			GlobalVars.getInstance().put("author.age", "33");
			GlobalVars.getInstance().put("author.comment", "Programmer");
		}
		
		if (flag) {
			/*
			 * print the list of the GlobalVars
			 */
			GlobalVars.getInstance().print();
		}
		
		if (flag) {
			/*
			 * change values of the GlobalVars 
			 */
			GlobalVars.getInstance().put("author.age", "30");
			GlobalVars.getInstance().put("author.hobby", "playing");
			GlobalVars.getInstance().put("author.name", "Kiea Seok Kang");
		}
		
		if (flag) {
			/*
			 * print the list of the GlobalVars
			 */
			GlobalVars.getInstance().print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
