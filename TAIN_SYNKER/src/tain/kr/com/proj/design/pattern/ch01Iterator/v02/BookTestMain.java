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
package tain.kr.com.proj.design.pattern.ch01Iterator.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BookTestMain.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch01Iterator.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 21. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BookTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(BookTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			ContentBooks contentBooks = new ContentBooks();
			
			contentBooks.add(new Book("Around the world in 80 days"));
			contentBooks.add(new Book("Bible"));
			contentBooks.add(new Book("Cinderella"));
			contentBooks.add(new Book("Daddy-long-legs"));
			contentBooks.add(new Book("East of Eden"));
			contentBooks.add(new Book("Frankestein"));
			contentBooks.add(new Book("Guliver's travels"));
			contentBooks.add(new Book("Hamlet"));
			
			ToolBooks tool = contentBooks.getTool();
			while (tool.hasNext()) {
				Book book = (Book) tool.next();
				System.out.println(book);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
