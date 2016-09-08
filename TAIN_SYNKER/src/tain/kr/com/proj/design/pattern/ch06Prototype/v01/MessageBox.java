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
package tain.kr.com.proj.design.pattern.ch06Prototype.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MessageBox.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch06Prototype.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 8. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MessageBox implements Product {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final char decoChar;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public MessageBox(char decoChar) {
		this.decoChar = decoChar;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void use(String string) {
		
		int length = string.getBytes().length;
		
		for (int i=0; i < length + 4; i++) {
			System.out.print(this.decoChar);
		}
		System.out.println();
		
		System.out.println(this.decoChar + " " + string + " " + this.decoChar);
		
		for (int i=0; i < length + 4; i++) {
			System.out.print(this.decoChar);
		}
		System.out.println();
	}
	
	@Override
	public Product createClone() {
		
		Product product = null;
		
		try {
			product = (Product) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
