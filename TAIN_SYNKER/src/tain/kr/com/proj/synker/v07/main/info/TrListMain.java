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
package tain.kr.com.proj.synker.v07.main.info;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v07.base.common.GlobalParam;
import tain.kr.com.proj.synker.v07.tools.info.TrList;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TrListMain.java
 *   -. Package    : tain.kr.com.proj.synker.v07.main.info
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TrListMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TrListMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void serviceModule() throws Exception {
		
		if (flag) {
			/*
			 * test for loop
			 */
			TrList.getInstance().print();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * print for checking arguments
			 */
			for (String arg : args) {
				log.debug("ARG [" + arg + "]");
			}
		}

		if (flag) serviceModule();
	}

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (args.length == 0) {
			args = new String[] { "TEST-2" };

			//GlobalParam.getInstance(1);  // version
			//GlobalParam.getInstance(2);  // server
			//GlobalParam.getInstance(3);  // client
			GlobalParam.getInstance(4);  // trlist
			//GlobalParam.getInstance(5);  // svclist
			//GlobalParam.getInstance(6);  // syslist
			GlobalParam.getInstance();
		}

		if (flag) test01(args);
	}
}
