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
 *   -. FileName   : Th01Gate.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch00Temp.tmp02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 26. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Th01Gate {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private int counter = 0;
	private String name = "Nobody";
	private String addr = "Nowhere";
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public synchronized void pass(String name, String addr) {
		this.counter ++;
		this.name = name;
		this.addr = addr;
		check();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void check() {
		if (name.charAt(0) != addr.charAt(0)) {
			System.out.println("##### BROKEN ##### " + this.toString());
		}
	}
	
	public synchronized String toString() {
		return String.format("[No.%d : %s : %s]", this.counter, this.name, this.addr);
	}
}
