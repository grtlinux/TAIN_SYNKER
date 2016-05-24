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
package tain.kr.com.proj.synker.v01.tools;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v01.common.Version;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : VersionToolMain.java
 *   -. Package    : tain.kr.com.proj.synker.v01.tools
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class VersionToolMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(VersionToolMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Version.getInstance().print();
		}
		
		if (flag) {
			log.debug("* desc = " + Version.getInstance().getDesc());
			log.debug("* date = " + Version.getInstance().getDate());
			log.debug("* version = " + Version.getInstance().getVersion());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
