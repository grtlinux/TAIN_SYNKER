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
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FileFilterTestMain.java
 *   -. Package    : tain.kr.com.proj.synker.v06.test.filefilter.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 17. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FileFilterTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FileFilterTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String gateFolder;
	
	private Map<String, FileEntry> mapTest = null;
	
	private FileFilterTestMain() {

		if (flag || true) {
			this.gateFolder = FileEntry.GATE_FOLDER.replace('\\', '/');
			
			this.mapTest = new HashMap<String, FileEntry>();
		}
	}
	
	public void execute() throws Exception {
		
		if (flag) {
			
			entryList(new File(this.gateFolder));
		}
	}
	
	private void entryList(File folder) throws Exception {
		
		if (flag) {
			try {
				
				folder.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File file) {
						
						if (flag) {
							/*
							 * logic for checking filters
							 */
						}
						
						makeFileEntry(file);
						
						if (file.isDirectory()) {
							try {
								entryList(file);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						
						return false;
					}
					
					/*
					 * make FileEntry
					 */
					private void makeFileEntry(File file) {
						
						if (flag) {
						
							new FileEntry(file);
						}
					}
				});
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
	}
	
	public Map<String, FileEntry> getMapTest() throws Exception {
		return this.mapTest;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static FileFilterTestMain instance = null;
	
	public static synchronized FileFilterTestMain getInstance() throws Exception {
		
		if (FileFilterTestMain.instance == null) {
			FileFilterTestMain.instance = new FileFilterTestMain();
		}
		
		return FileFilterTestMain.instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			FileFilterTestMain.getInstance().execute();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
