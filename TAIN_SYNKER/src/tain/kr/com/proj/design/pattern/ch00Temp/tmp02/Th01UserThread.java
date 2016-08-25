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
package tain.kr.com.proj.design.pattern.ch00Temp.tmp02;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Th01User.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch00Temp.tmp02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 26. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Th01UserThread extends Thread {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Th01Gate gate;
	private final String name;
	private final String addr;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Th01UserThread(Th01Gate gate, String name, String addr) {
		this.gate = gate;
		this.name = name;
		this.addr = addr;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void run() {
		System.out.format("[%s] BEGIN%n", this.name);
		
		while (true) {
			this.gate.pass(this.name, this.addr);
		}
	}

}
