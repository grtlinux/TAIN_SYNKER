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
package tain.kr.com.proj.design.pattern.ch03Template.v02;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DisplayString.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch03Template.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 3. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class DisplayString extends DisplayAbstract {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	private final int width;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public DisplayString(String name) {
		this.name = name;
		this.width = name.getBytes().length + 2;	
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void open() {
		printLine();
	}
	
	protected void print() {
		System.out.println("| " + this.name + " |");
	}
	
	protected void close() {
		printLine();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void printLine() {
		System.out.print("+");
		
		for (int i=0; i < this.width; i++) {
			System.out.print("-");
		}
		
		System.out.println("+");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
