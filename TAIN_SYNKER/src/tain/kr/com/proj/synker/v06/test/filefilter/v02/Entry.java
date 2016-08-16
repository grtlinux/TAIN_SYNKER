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
package tain.kr.com.proj.synker.v06.test.filefilter.v02;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v06.test.composite.v02.FileTreatmentException;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Entry.java
 *   -. Package    : tain.kr.com.proj.synker.v06.test.filefilter.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 17. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class Entry {

	private static boolean flag = true;

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(Entry.class);
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract String getType();
	public abstract String getGateDirName();
	public abstract String getChildDirName();
	public abstract String getFileName();
	
	public abstract long getLongDate();
	public abstract long getLongSize();
	public abstract long getLongCRC();
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("[" + getType() + "] ");
		sb.append(getGateDirName()).append(getChildDirName()).append(getFileName());
		sb.append(String.format("      [%d] [%d] [%d]", getLongDate(), getLongSize(), getLongCRC()));
		
		return sb.toString();
	}
	
	public void printList() {
		printList("");
	}
	
	protected abstract void printList(String prefix);
	
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	protected Entry parent;
	
	public String getFullName() {
		
		if (flag) {
			StringBuffer fullName = new StringBuffer();
			
			Entry entry = this;
			do {
				fullName.insert(0,  "/" + entry.getFileName());
				entry = entry.parent;
			} while (entry != null);
			
			return fullName.toString();
		}
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(getGateDirName()).append(getChildDirName()).append(getFileName());
		
		return sb.toString();
	}
}
