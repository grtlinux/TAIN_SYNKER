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
package tain.kr.com.proj.synker.v06.main.trlist;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v06.util.GlobalParam;
import tain.kr.com.proj.synker.v06.util.TrMap;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TrListMain.java
 *   -. Package    : tain.kr.com.proj.synker.v06.main.trlist
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 17. {time}
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

		if (flag) {
			/*
			 * to set the name of service
			 */
			GlobalParam.getInstance().setServiceType(args[0]);
			GlobalParam.getInstance().setServiceName(args[1]);
		}
		
		if (flag) {
			/*
			 * to print the version info
			 */
			TrMap.getInstance().print();
		}
		
		if (flag) {
			if (flag) {
				/*
				 * check trKey = trName(trCode)
				 */
			}
			
			if (flag) {
				/*
				 * check trCliClass, trSvrClass
				 */
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (args.length < 2) {
			args = new String[] { "TEST-2", "trlist" };
		}

		if (flag) test01(args);
	}
}
