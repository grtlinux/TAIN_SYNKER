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
package tain.kr.com.proj.design.thread.ch01SingleThreadedExecution.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Gete.java
 *   -. Package    : tain.kr.com.test.designpattern.thread.ch01SingleThreadedExecution.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
@SuppressWarnings("unused")
public class Gate {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Gate.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private int counter = 0;
	private String name = "Nobody";
	private String address = "Nowhere";
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public synchronized void pass(String name, String address) {
		this.counter ++;
		this.name = name;
		this.address = address;
		check();
	}
	
	public synchronized String toString() {
		return "No." + counter + ": " + name + ", " + address;
	}
	
	private void check() {
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("***** BROKEN ***** " + toString());
		}
		
		// try { Thread.sleep(1000); } catch (InterruptedException e) {}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
