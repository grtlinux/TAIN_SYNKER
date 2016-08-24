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
 *   -. FileName   : Ch11Entry.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch00Temp.tmp02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class Ch11Entry {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract String getName();
	public abstract int getSize();
	
	protected abstract void printList(String prefix);
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return String.format("%s (%d)", this.getName(), this.getSize());
	}
	
	public Ch11Entry add(Ch11Entry entry) throws Ch11FileTreatmentException {
		throw new Ch11FileTreatmentException();
	}

	public void printList() {
		printList("");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Ch11Entry parent = null;
	
	public String getFullName() {
		StringBuffer fullName = new StringBuffer();
		
		Ch11Entry entry = this;
		do {
			fullName.insert(0, "/" + entry.getName());
			entry = entry.parent;
		} while (entry != null);
		
		return fullName.toString();
	}
}
