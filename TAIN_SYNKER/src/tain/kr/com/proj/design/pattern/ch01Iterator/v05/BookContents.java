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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BookContents.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch01Iterator.v05
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 3. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BookContents {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(BookContents.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final List<Book> lstBook;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public BookContents() {
		this.lstBook = new ArrayList<Book>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void add(Book book) {
		this.lstBook.add(book);
	}
	
	public Book get(int index) {
		return this.lstBook.get(index);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("[\n");
		
		for (Book book : this.lstBook) {
			sb.append("\t" + book + ",\n");
		}

		sb.append("]\n");
		
		return sb.toString();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			BookContents content = new BookContents();
			
			content.add(new Book("Around the world in 80 days"));
			content.add(new Book("Bible"));
			content.add(new Book("Cinderella"));
			content.add(new Book("Daddy-long-legs"));
			content.add(new Book("East of Eden"));
			content.add(new Book("Frankestein"));
			content.add(new Book("Guliver's travels"));
			content.add(new Book("Hamlet"));
			
			System.out.println(content);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
