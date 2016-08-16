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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FileEntry.java
 *   -. Package    : tain.kr.com.proj.synker.v06.test.filefilter.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 17. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FileEntry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FileEntry.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * TODO 2016.08.16 : have to change before long
	 */
	public static final String SYSTEM_NAME = "SYNKER_TEST";
	public static final String GATE_FOLDER = "N:/TEMP/_synker_test";
	
	private final String type;      // F:FILE   D:DIR
	private final String fullName;
	private final String gateDirName;
	private final String childDirName;
	private final String fileName;
	
	private final long longDate;
	private final long longSize;
	private final long longCRC;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public FileEntry(File file) {

		if (flag || true) {
			/*
			 * TODO 2016.08.16 : have to change before long
			 */
			int gateSize = FileEntry.GATE_FOLDER.length();
			
			this.fullName = file.getAbsolutePath().replace('\\', '/');
			
			this.gateDirName = this.fullName.substring(0, gateSize);

			if (file.isDirectory()) {
				this.type = "DIR";
				
				this.childDirName = this.fullName.substring(gateSize);
				this.fileName = "";
				
				this.longDate = file.lastModified();
				this.longSize = file.length();
				this.longCRC = 0;
			} else {
				this.type = "FILE";

				int idx = this.fullName.lastIndexOf('/');
				
				this.childDirName = this.fullName.substring(gateSize, idx);
				this.fileName = this.fullName.substring(idx + 1);

				this.longDate = file.lastModified();
				this.longSize = file.length();
				this.longCRC = 0;
			}
		}
		
		if (flag) log.debug(this);
	}

	public String getType() {
		return type;
	}

	public String getFullName() {
		return fullName;
	}

	public String getGateDirName() {
		return gateDirName;
	}

	public String getChildDirName() {
		return childDirName;
	}

	public String getFileName() {
		return fileName;
	}

	public long getLongDate() {
		return longDate;
	}

	public long getLongSize() {
		return longSize;
	}

	public long getLongCRC() {
		return longCRC;
	}
	
	public String toString() {
		
		return String.format("FileEntry INFO => [%c] [%s] [%s] [%s] [%s] [%d] [%d] [%d]"
				, this.type.charAt(0)
				, this.fullName
				, this.gateDirName
				, this.childDirName
				, this.fileName
				, this.longDate
				, this.longSize
				, this.longCRC
				);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		Map<String, FileEntry> mapFileEntry = new HashMap<String, FileEntry>();
		
		FileEntry entry = null;

		if (flag) {
			entry = new FileEntry(new File("N:/TEMP/_synker_test/bin"));
			mapFileEntry.put(entry.getFullName(), entry);

			entry = new FileEntry(new File("N:/TEMP/_synker_test/bin/mvnDebug.cmd"));
			mapFileEntry.put(entry.getFullName(), entry);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}