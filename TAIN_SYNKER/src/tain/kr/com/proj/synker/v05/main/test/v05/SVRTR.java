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
package tain.kr.com.proj.synker.v05.main.test.v05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SVRTR.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SVRTR extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SVRTR.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private PipedInputStream pis = null;
	private PipedOutputStream pos = null;
	
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	public SVRTR(PipedInputStream pis, PipedOutputStream pos) {
		
		if (flag) log.debug(">>>>> Constructor of " + this.getName());
		
		if (flag) {
			this.pis = pis;
			this.pos = pos;
			
			this.dis = new DataInputStream(this.pis);
			this.dos = new DataOutputStream(this.pos);
		}
	}
	
	public void run() {
		
		if (flag) log.debug(">>>>> run method of " + this.getName());
		
		try {
			
			if (flag) {
				/*
				 * read from pipe
				 */
				byte[] buf = new byte[20];
				
				int rcnt = this.dis.read(buf);
				
			}
			
			if (flag) {
				/*
				 * job processing
				 */
			}
			
			if (flag) {
				/*
				 * write to pipe
				 */
				byte[] buf = "PIPED_OUTPUT_STREAM".getBytes();
				
				this.dos.write(buf, 0, buf.length);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
			/*
			 * job process
			 */
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			scanner.close();
			
			Date date = new Date();
			
			long lVal = date.getTime();
			String strVal = date.toString();
			
			System.out.format("%s|%d|%s\n", line, lVal, strVal);
		}
		
		if (flag) {
			/*
			 * waiting
			 */
			long msec = 1000;
			if (flag) log.debug("sleeping msec = " + msec);
			try { Thread.sleep(msec); } catch (InterruptedException e) {}
		}

		if (flag) {
			/*
			 * occur a exception event
			 */
			throw new Exception("ERROR : error information... by KIEA");
		}
	}
	
	@SuppressWarnings({ "unused", "resource" })
	private static void test02(String[] args) throws Exception {
		
		PipedInputStream pisIn = new PipedInputStream();
		PipedOutputStream posIn = new PipedOutputStream(pisIn);    // posIn -> pisIn
		
		PipedInputStream pisOut = new PipedInputStream();
		PipedOutputStream posOut = new PipedOutputStream(pisOut);    // posOut -> pisOut

		if (flag) {
			/*
			 * use class
			 * elements class, constructor, run method
			 */
			
			// class
			Class<?> cls = Class.forName("tain.kr.com.proj.synker.v05.main.test.v04.SVRTR");
			
			// constructor argument types
			Class<?>[] types = new Class[] { PipedInputStream.class, PipedOutputStream.class };
			Object[] constructorArgs = new Object[] { pisIn, posOut };

			// execute constructor
			Constructor<?> constructor = cls.getConstructor(types);
			Object instance = constructor.newInstance(constructorArgs);
			
			// execute run method of thread
			//Method method = cls.getMethod("run");
			Method method = cls.getMethod("start");
			method.invoke(instance);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (!flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (!flag) test01(args);
		if (flag) test02(args);
	}
}
