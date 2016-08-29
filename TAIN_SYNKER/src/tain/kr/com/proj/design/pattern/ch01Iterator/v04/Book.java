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
package tain.kr.com.proj.design.pattern.ch01Iterator.v04;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Book.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch01Iterator.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 30. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Book {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String key;
	
	private final String name;
	
	private final int cost;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Book(String key, String name, int cost) {
		this.key = key;
		this.name = name;
		this.cost = cost;
	}
	
	public Book(String name, int cost) {
		this.key = name;
		this.name = name;
		this.cost = cost;
	}
	
	public Book(String name) {
		this.key = name;
		this.name = name;
		this.cost = (int) (Math.random() * 100000);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String getKey() {
		return this.key;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public String toString() {
		return String.format("Book('%s', '%s', '%d');", this.getKey(), this.getName(), this.getCost());
	}
}
