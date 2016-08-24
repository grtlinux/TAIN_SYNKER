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
 *   -. FileName   : Ch01BookTool.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch00Temp.tmp02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Ch01BookTool {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Ch01BookContent content;
	private int index;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Ch01BookTool(Ch01BookContent content) {
		this.content = content;
		this.index = 0;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	// abstract
	public boolean hasNext() {
		
		if (this.index < this.content.getLength()) {
			return true;
		}
		
		return false;
	}
	
	// abstract
	public Object next() {
		return this.content.get(this.index++);
	}
}
