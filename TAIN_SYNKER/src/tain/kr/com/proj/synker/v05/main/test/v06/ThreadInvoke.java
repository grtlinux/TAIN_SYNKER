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
package tain.kr.com.proj.synker.v05.main.test.v06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThreadInvoke.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v06
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ThreadInvoke {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThreadInvoke.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void execute(PipedStream ps, String clsName) throws Exception {
		
		if (flag) {
			/*
			 * use class
			 * elements class, constructor, run method
			 */
			
			// class
			Class<?> cls = Class.forName(clsName);
			
			// constructor argument types
			Class<?>[] types = new Class[] { PipedStream.class };
			Object[] constructorArgs = new Object[] { ps };

			// execute constructor
			Constructor<?> constructor = cls.getConstructor(types);
			Object instance = constructor.newInstance(constructorArgs);
			
			// execute run method of thread
			//Method method = cls.getMethod("run");
			Method method = cls.getMethod("start");
			method.invoke(instance);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		PipedStream ps = null;

		if (flag) {
			/*
			 * Test
			 */
			ps = new PipedStream();
			
			ThreadInvoke.execute(ps, "tain.kr.com.proj.synker.v05.main.test.v06.SVRTR");

		}
		
		if (flag) {
			/*
			 * parent thread, main thread
			 */
			
			String req = "GET_DATE_TIME(" + (int) (Math.random() * 200) + ")";
			String res = null;
			
			if (flag) log.debug(">>>>> REQ = [" + req + "]");

			if (flag) {
				/*
				 * ReqWrite
				 */
				
				ps.reqWrite(req);
			}
			
			if (flag) {
				/*
				 * ResRead
				 */
				
				res = ps.resRead();
			}
			
			if (flag) log.debug(">>>>> RES = [" + res + "]");
		}
		
		if (flag) {
			/*
			 * close piped stream object
			 */
			ps.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
