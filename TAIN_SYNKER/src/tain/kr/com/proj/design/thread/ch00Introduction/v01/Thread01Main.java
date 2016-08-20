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
package tain.kr.com.proj.design.thread.ch00Introduction.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Thread01Main.java
 *   -. Package    : tain.kr.com.test.designpattern.thread.ch00Introduction.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Thread01Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Thread01Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * 1. MyThread
			 */
			Thread thread = new MyThread("KANG-1");
			thread.start();
		}
		
		if (flag) {
			/*
			 * 2. Thread
			 */
			Thread thread = new Thread() {
				public void run() {
					System.out.println("THREAD-2 start thread...");
					try { Thread.sleep(1000); } catch (InterruptedException e) {}
					System.out.println("THREAD-2 end   thread...");
				}
			};
			thread.start();
		}
		
		if (flag) {
			/*
			 * 3. MyRunnable
			 */
			Thread thread = new Thread(new MyRunnable("KANG-2"));
			thread.start();
		}
		
		if (flag) {
			/*
			 * 4. Runnable
			 */
			Thread thread = new Thread(new Runnable(){
				public void run() {
					System.out.println("RUNNABLE-4 start thread...");
					try { Thread.sleep(1000); } catch (InterruptedException e) {}
					System.out.println("RUNNABLE-4 end   thread...");
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}

class MyThread extends Thread {
	
	private final String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println("THREAD-1 start thread...[name=" + this.name + "]");
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		System.out.println("THREAD-1 end   thread...[name=" + this.name + "]");
	}
}

class MyRunnable implements Runnable {
	
	private final String name;
	
	public MyRunnable(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println("RUNNABLE-3 start thread...[name=" + this.name + "]");
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		System.out.println("RUNNABLE-3 end   thread...[name=" + this.name + "]");
	}
}