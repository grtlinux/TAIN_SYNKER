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

import java.util.Vector;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BookShelfAggregate.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch01Iterator.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BookShelfAggregate implements Aggregate {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Vector<Book> books;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public BookShelfAggregate(int initSize) {
		this.books = new Vector<Book>(initSize);
	}
	
	public void appendBook(Book book) {
		this.books.add(book);
	}
	
	public Book getBookAt(int index) {
		return this.books.get(index);
	}
	
	public int getLength() {
		return books.size();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
}
