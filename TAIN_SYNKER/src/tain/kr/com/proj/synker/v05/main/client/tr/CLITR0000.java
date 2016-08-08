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
package tain.kr.com.proj.synker.v05.main.client.tr;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CLITR0000.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.client.tr
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class CLITR0000 {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(CLITR0000.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * redirect definition
			 */
			InputStream is = null;
			//is = new ByteArrayInputStream("DATETIME KANG SEOK".getBytes());
			//is = new ByteArrayInputStream("DATETIME KANG SEOK         \n".getBytes());
			//is = new ByteArrayInputStream("DATETIME KANG SEOK         \n        123".getBytes());
			is = new ByteArrayInputStream("GET_DATE_TIME".getBytes());
			
			System.setIn(is);
			
			PrintStream ps = null;
			//ps = new PrintStream("N:/123");
			ps = new PrintStream(System.out);
			
			System.setOut(ps);
			System.setErr(ps);
		}
		
		if (flag) {
			/*
			 * execute class code after redirection
			 */
			String clsName = "tain.kr.com.proj.synker.v05.main.server.tr.SVRTR0000";
			
			Class<?> cls = Class.forName(clsName);
			
			Method main = cls.getDeclaredMethod("main", new Class[] { String[].class });
			
			main.invoke(null, (Object) new String[] { "TR0000", "GET_DATE_TIME" });
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
