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
package tain.kr.com.proj.synker.v05.main.test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : RedirectMain.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class RedirectMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(RedirectMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * redirect definition
			 */
			System.setIn(new ByteArrayInputStream("DATETIME KANG SEOK   \n    123".getBytes()));
			PrintStream ps = new PrintStream("N:/123");
			System.setOut(ps);
			System.setErr(ps);
		}
		
		if (flag) {
			/*
			 * execute class code after redirection
			 */
			String clsName = "tain.kr.com.proj.synker.v05.main.tool.GetTimeMain";
			
			Class<?> cls = Class.forName(clsName);
			
			Method main = cls.getDeclaredMethod("main", new Class[] { String[].class });
			
			main.invoke(null, (Object) new String[] { "Hello", "World!!!" });
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
