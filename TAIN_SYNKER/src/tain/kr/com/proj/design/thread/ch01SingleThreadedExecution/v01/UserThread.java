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
package tain.kr.com.proj.design.thread.ch01SingleThreadedExecution.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : UserThread.java
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
public class UserThread extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(UserThread.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Gate gate;
	private final String myName;
	private final String myAddress;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public UserThread(Gate gate, String myName, String myAddress) {
		this.gate = gate;
		this.myName = myName;
		this.myAddress = myAddress;
	}

	public void run() {
		System.out.println(this.myName + " BEGIN");
		while (true) {
			gate.pass(this.myName, this.myAddress);;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
