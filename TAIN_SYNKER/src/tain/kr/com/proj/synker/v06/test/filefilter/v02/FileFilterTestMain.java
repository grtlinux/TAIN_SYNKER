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
import java.util.Date;

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

	private static final Logger log = Logger
			.getLogger(FileFilterTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String gateFolder;
	private final int gateSize;
	
	private FileFilterTestMain() {

		this.gateFolder = "N:\\TEMP\\_synker_test".replace('\\', '/');
		this.gateSize = this.gateFolder.length();
	}
	
	public void execute() throws Exception {
		
		if (flag) {
			
			entryList(new File(gateFolder));
		}
	}
	
	private void entryList(File folder) throws Exception {
		
		if (flag) {
			@SuppressWarnings("unused")
			File[] files = null;
			
			try {
				
				/*
				 * check points
				 *    1. gateFolder
				 *    2. folder
				 *    3. file
				 */
				@SuppressWarnings("unused")
				FileFilter fileFilter = new FileFilter() {
					
					@Override
					public boolean accept(File file) {
						
						if (!flag) {
							String tmCal = null;
							
							if (flag) {
								long lm = file.lastModified();
								long ms = lm % 1000;
								long sec = (lm / 1000) % 60;
								long min = (lm / 1000 / 60) % 60;
								long hour = (lm / 1000 / 60 / 60 + 9) % 24;
								tmCal = String.format("[%02d:%02d:%02d.%03d]", hour, min, sec, ms);
							}
							
							try {
								StringBuffer sb = new StringBuffer();
								sb.append(String.format("1 > "));
								sb.append(String.valueOf(file.getName())).append(" - ");
								sb.append(String.valueOf(file.getAbsolutePath())).append(" - ");
								sb.append(String.valueOf(file.getCanonicalPath())).append(" - ");
								sb.append(String.valueOf(file.lastModified())).append(" - ").append(String.valueOf(new Date(file.lastModified()))).append(" - ").append(tmCal).append(" - ");
								sb.append(String.valueOf(file.length())).append(" - ");
								
								log.debug(sb.toString());
							} catch (Exception e) {
								e.printStackTrace();
							}

							// get name of file
							String name = file.getName();
							
							// get last index of '.' char.
							int lastIndex = name.lastIndexOf('.');
							
							if (lastIndex > 0) {
								// get extension
								String ext = name.substring(lastIndex);
								
								// match each name extension
								if (".iso".equals(ext)) {
									return true;
								}
							}
						}
						
						if (flag) {
							
						}
						
						return false;
					}
				};
				
				files = folder.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File file) {
						
						if (flag) {
							/*
							 * logic for checking filters
							 */
						}
						
						printInfo(file);
						
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
					 * print information
					 */
					private void printInfo(File file) {
						
						if (flag) {
							
							StringBuffer sb = new StringBuffer();

							try {
								String strFileName = file.getAbsolutePath().replace('\\', '/');
								//int len = strFileName.length();
								
								sb.append(String.format("%s \t", file.isDirectory() ? "FOLDER" : "FILE  "));
								
								String strGateFolder = strFileName.substring(0, gateSize);

								String strFolder = "";
								String strFile = "";
								
								if (file.isDirectory()) {
									strFolder = strFileName.substring(gateSize);
									strFile = "";
								
									sb.append(String.format("[%s]\t[%s]\t[%s]", strGateFolder, strFolder, strFile));
								} else {
									int idx = strFileName.lastIndexOf('/');
									
									strFolder = strFileName.substring(gateSize, idx);
									strFile = strFileName.substring(idx);
									
									sb.append(String.format("[%s]\t[%s]\t[%s]", strGateFolder, strFolder, strFile));
								}
								
								if (flag) System.out.println(sb.toString());

								
								
								
								
								if (!flag) {
									/*
									 * appendix
									 */
									if (!flag) sb.append(String.valueOf(file.getName())).append(" - ");
									if (!flag) sb.append(String.valueOf(file.getAbsolutePath())).append(" - ");
									if (!flag) sb.append(String.valueOf(file.getCanonicalPath())).append(" - ");
									if (!flag) sb.append(String.valueOf(file.lastModified())).append(" - ").append(String.valueOf(new Date(file.lastModified()))).append(" - ");
									if (!flag) sb.append(String.valueOf(file.length())).append(" - ");
								}
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				});
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
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
