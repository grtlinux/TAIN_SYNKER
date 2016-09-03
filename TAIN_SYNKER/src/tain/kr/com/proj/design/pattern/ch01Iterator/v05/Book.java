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
package tain.kr.com.proj.design.pattern.ch01Iterator.v05;

import org.apache.log4j.Logger;

import tain.kr.com.proj.design.pattern.ch01Iterator.v04.TestMain;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Book.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch01Iterator.v05
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 3. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Book {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String key;
	private final String name;
	private final int cost;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Book(String name) {
		this.name = name;
		this.key = name;
		this.cost = (int) (Math.random() * 10000);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String getName() {
		return this.name;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return String.format("Book('%s', '%s', %d)", this.getKey(), this.getName(), this.getCost());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Book book = new Book("Daddy-long-legs");
			if (flag) log.debug(book);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
