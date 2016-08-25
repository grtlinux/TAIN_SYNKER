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
 *   -. FileName   : Ch04ProductCard.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch00Temp.tmp02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 26. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class Ch04ProductCard extends Ch04Product {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String owner;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Ch04ProductCard(String name) {
		this.owner = name;
		System.out.println(this.owner + "의 카드를 만듭니다.");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getOwner() {
		return this.owner;
	}
	
	public String toString() {
		return String.format("[Card : %s]", this.getOwner());
	}
	
	@Override
	public void use() {
		System.out.println(this.getOwner() + "의 카드를 사용합니다.");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
