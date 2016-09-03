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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BookMap.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch01Iterator.v05
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 3. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BookMap {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unused")
	private final List<Book> lstBook;
	
	private final Map<String, Book> mapBook;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public BookMap(List<Book> lstBook) {
		this.lstBook = lstBook;
		
		this.mapBook = new HashMap<String, Book>();
		
		for (Book book : lstBook) {
			this.mapBook.put(book.getKey(), book);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Book get(String key) {
		return this.mapBook.get(key);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
