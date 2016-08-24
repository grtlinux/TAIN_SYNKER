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

import java.util.Vector;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Ch11Folder.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch00Temp.tmp02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Ch11Folder extends Ch11Entry {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	private final Vector<Ch11Entry> entries;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Ch11Folder(String name) {
		this.name = name;
		this.entries = new Vector<Ch11Entry>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getSize() {
		
		int size = 0;
		
		for (Ch11Entry entry : this.entries) {
			size += entry.getSize();
		}
		
		return size;
	}
	
	@Override
	public Ch11Entry add(Ch11Entry entry) {
		this.entries.addElement(entry);
		entry.parent = this;
		
		return this;
	}
	
	@Override
	protected void printList(String prefix) {
		
		System.out.println(prefix + "/" + this);
		
		for (Ch11Entry entry : this.entries) {
			entry.printList(prefix + "/" + this.name);
		}
	}
}
