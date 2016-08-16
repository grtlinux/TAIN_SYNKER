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
package tain.kr.com.proj.design.pattern.ch01Iterator.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TestMain.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch01Iterator.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * make source sequencely
	 * 
	 *    1. Book
	 *    2. Iterator
	 *    3. Aggregate
	 *    4. BookShelfIterator
	 *    5. BookShelfAggregate
	 *    6. TestMain
	 */
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			BookShelfAggregate bookShelfAggregate = new BookShelfAggregate(2);
			
			bookShelfAggregate.appendBook(new Book("Around the world in 80 days"));
			bookShelfAggregate.appendBook(new Book("Bible"));
			bookShelfAggregate.appendBook(new Book("Cinderella"));
			bookShelfAggregate.appendBook(new Book("Daddy-Long-Legs"));
			bookShelfAggregate.appendBook(new Book("East of Eden"));
			bookShelfAggregate.appendBook(new Book("Frankestein"));
			bookShelfAggregate.appendBook(new Book("Guliver's Travels"));
			bookShelfAggregate.appendBook(new Book("Hamlet"));
			
			Iterator iterator = bookShelfAggregate.iterator();
			while (iterator.hasNext()) {
				Book book = (Book) iterator.next();
				System.out.println(book);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
