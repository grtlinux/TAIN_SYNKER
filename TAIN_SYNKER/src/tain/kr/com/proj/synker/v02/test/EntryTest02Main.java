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
package tain.kr.com.proj.synker.v02.test;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : EntryTest02Main.java
 *   -. Package    : tain.kr.com.proj.synker.v02.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class EntryTest02Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(EntryTest02Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private EntryTest02Main() throws Exception {
		
	}
	
	public void print() throws Exception {
		
		if (flag) {
			log.info("print.....");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static EntryTest02Main instance = null;
	
	public static synchronized EntryTest02Main getInstance() throws Exception {
		
		if (instance == null) {
			instance = new EntryTest02Main();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			EntryTest02Main.getInstance().print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
