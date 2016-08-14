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
package tain.kr.com.proj.design.pattern.ch11Composite.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Entry.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch11Composite.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class Entry {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract String getName();
	public abstract int getSize();
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return getName() + " (" + getSize() + ")";
	}
	
	public void printList() {
		printList("");
	}
	
	protected abstract void printList(String prefix);
	
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}
