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
package tain.kr.com.proj.design.pattern.ch02Adapter.v03;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TestMain.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch02Adapter.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 3. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * abstract
			 */
			PrintAbstract print = new BannerPrintAbstract("Hello");
			print.printWeak();
			print.printStrong();
		}
		
		System.out.println();
		
		if (flag) {
			/*
			 * interface
			 */
			PrintInterface print = new BannerPrintInterface("Hello");
			print.printWeak();
			print.printStrong();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
