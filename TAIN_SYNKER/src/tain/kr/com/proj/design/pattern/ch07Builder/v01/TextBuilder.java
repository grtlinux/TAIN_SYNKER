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
package tain.kr.com.proj.design.pattern.ch07Builder.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TextBuilder.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch07Builder.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 11. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TextBuilder extends Builder {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final StringBuffer buffer;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public TextBuilder() {
		this.buffer = new StringBuffer();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void makeTitle(String title) {

		this.buffer.append("========================================================================\n");
		this.buffer.append("<" + title + ">\n");
		this.buffer.append("\n");
	}
	
	@Override
	public void makeString(String string) {
		
		this.buffer.append("*" + string + "\n");
		this.buffer.append("\n");
	}
	
	@Override
	public void makeItems(String[] items) {
		
		for (String item : items) {
			this.buffer.append("-" + item + "\n");
		}
		this.buffer.append("\n");
	}
	
	@Override
	public Object getResult() {
		
		this.buffer.append("========================================================================\n");
		return this.buffer.toString();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
