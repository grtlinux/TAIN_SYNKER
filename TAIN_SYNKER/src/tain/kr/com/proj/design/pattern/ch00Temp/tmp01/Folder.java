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
package tain.kr.com.proj.design.pattern.ch00Temp.tmp01;

import java.util.Iterator;
import java.util.Vector;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Folder.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch00Temp.tmp01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 21. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Folder extends Entry {

	private static boolean flag = true;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	private final Vector<Entry> folder;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Folder(String name) {
		this.name = name;
		this.folder = new Vector<Entry>();
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getSize() {
		
		int size = 0;
		
		if (!flag) {
			Iterator<Entry> iter = this.folder.iterator();
			while (iter.hasNext()) {
				Entry entry = iter.next();
				size += entry.getSize();
			}
		}

		if (flag) {
			for (Entry entry : this.folder) {
				size += entry.getSize();
			}
		}
		
		return size;
	}
	
	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);

		if (!flag) {
			Iterator<Entry> iter = this.folder.iterator();
			while (iter.hasNext()) {
				Entry entry = iter.next();
				entry.printList(prefix + "/" + this.name);
			}
		}
		
		if (flag) {
			for (Entry entry : folder) {
				entry.printList(prefix + "/" + this.name);
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Entry add(Entry entry) {
		if (!flag) {
			this.folder.add(entry);
		}
		
		if (flag) {
			this.folder.add(entry);
			entry.parent = this;
		}
		return this;
	}
}
