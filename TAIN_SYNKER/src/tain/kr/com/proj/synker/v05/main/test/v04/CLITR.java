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
package tain.kr.com.proj.synker.v05.main.test.v04;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CLITR.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class CLITR {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(CLITR.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * redirect definition
			 */
			InputStream is = null;
			is = new ByteArrayInputStream("GET_DATE_TIME".getBytes());
			
			PrintStream ps = null;
			//ps = new PrintStream("N:/123");
			ps = new PrintStream(System.out);
			
			System.setIn(is);
			System.setOut(ps);
			System.setErr(ps);
		}
		
		if (flag) {
			/*
			 * execute the class of server module after redirection
			 */
			String clsName = GlobalVars.getInstance().getClsServer();
			
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
