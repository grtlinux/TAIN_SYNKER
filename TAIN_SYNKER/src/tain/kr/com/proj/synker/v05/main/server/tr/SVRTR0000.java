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
package tain.kr.com.proj.synker.v05.main.server.tr;

import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SVRTR0000.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.server.tr
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SVRTR0000 {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SVRTR0000.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * to print the list of arguments
			 */
			
			for (String arg : args) {
				log.debug("ARG [" + arg + "]");
			}
		}
		
		if (flag) {
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			scanner.close();
			
			Date date = new Date();
			
			long lVal = date.getTime();
			String strVal = date.toString();
			
			System.out.format("%s|%d|%s%n", line, lVal, strVal);
		}
		
		if (!flag) {
			throw new Exception("ERROR : error information...");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
