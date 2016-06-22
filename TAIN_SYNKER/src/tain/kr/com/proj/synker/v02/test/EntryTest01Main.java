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
package tain.kr.com.proj.synker.v02.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v01.util.DateTime;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : EntryTestMain.java
 *   -. Package    : tain.kr.com.proj.synker.v01.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 2. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class EntryTest01Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(EntryTest01Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final String STR_INDENT = "\t";
	
	private static final String KEY_DESC = "tain.kr.test.entrytestmain.desc";
	private static final String KEY_SYS_FDR = "tain.kr.tset.entrytestmain.system.folder";
	
	private String desc = null;
	private String sysFdr = null;

	private EntryTest01Main() throws Exception {
		if (flag) {
			String clsName = this.getClass().getName();
			
			ResourceBundle rb = ResourceBundle.getBundle(clsName.replace('.', '/'));
			
			this.desc = rb.getString(KEY_DESC);
			this.sysFdr = rb.getString(KEY_SYS_FDR);
		}
	}
	
	public String getDesc() throws Exception {
		return this.desc;
	}
	
	public String getSysFdr() throws Exception {
		return this.sysFdr;
	}
	
	public void print() throws Exception {
		if (flag) {
			log.info("desc    > " + this.desc);
			log.info("sysFdr  > " + this.sysFdr);
		}
	}

	public void getSystemEntry() throws Exception {
		
		if (flag ) log.info(" * sysFdr  >" + this.sysFdr + "<\n");

		if (flag) {
			/*
			 * system info / system entry
			 */
			File folder = new File(this.sysFdr);
			
			getFolder("", folder);
		}
	}
	
	private void getFolder(String strIndent, File folder) throws Exception {
		
		if (flag ) log.info(strIndent + "[" + folder.getName() + "]");

		if (flag) {
			File[] files = null;
			
			try {
				// List of files
				files = folder.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File file) {
						return true;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
			
			// for loop of files
			for (File f : files) {
				
				if (f.isDirectory()) {
					/*
					 * folder info / folder entry
					 */
					getFolder(strIndent + STR_INDENT, f);
				} else {
					/*
					 * file info / file entry
					 */
					log.debug(strIndent + STR_INDENT + f.getName());
				}
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static EntryTest01Main instance = null;
	
	public static synchronized EntryTest01Main getInstance() throws Exception {
		
		if (instance == null) {
			instance = new EntryTest01Main();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		/* ----------------------------------------------------------------
		 * 1. Folder / File
		 */

		if (flag) log.info("1. Folder / File");

		if (flag) {
			/*
			 *  # Folder
			 *  - getName() -------------> cosmarter
			 *  - getAbsolutePath() -----> N:\TEMP\cosmarter
			 *  - getCanonicalPath() ----> N:\TEMP\cosmarter
			 *  - getParent() -----------> N:\TEMP
			 *  - getPath() -------------> N:\TEMP\cosmarter
			 *  - lastModified() --------> 1461739269896
			 *  - yyyy/mm/dd hh:mm:ss ---> 2016/04/27 15:41:09
			 *  - length() --------------> 4096
			 *  - isDirectory() ---------> true
			 *  - isFile() --------------> false
			 */
			String strName = "N:/TEMP/cosmarter";
			File file = new File(strName);
			
			if (flag) log.debug(" # Folder");
			if (flag) log.debug(" - getName() -------------> " + file.getName());
			if (flag) log.debug(" - getAbsolutePath() -----> " + file.getAbsolutePath());
			if (flag) log.debug(" - getCanonicalPath() ----> " + file.getCanonicalPath());
			if (flag) log.debug(" - getParent() -----------> " + file.getParent());
			if (flag) log.debug(" - getPath() -------------> " + file.getPath());
			if (flag) log.debug(" - lastModified() --------> " + file.lastModified());
			if (flag) log.debug(" - yyyy/mm/dd hh:mm:ss ---> " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", file.lastModified()));
			if (flag) log.debug(" - length() --------------> " + file.length());
			if (flag) log.debug(" - isDirectory() ---------> " + file.isDirectory());
			if (flag) log.debug(" - isFile() --------------> " + file.isFile());
		}
		
		if (flag) {
			/*
			 *  # File
			 *  - getName() -------------> tain-cosmarter-1.0.jar
			 *  - getAbsolutePath() -----> N:\TEMP\cosmarter\tain-cosmarter-1.0.jar
			 *  - getCanonicalPath() ----> N:\TEMP\cosmarter\tain-cosmarter-1.0.jar
			 *  - getParent() -----------> N:\TEMP\cosmarter
			 *  - getPath() -------------> N:\TEMP\cosmarter\tain-cosmarter-1.0.jar
			 *  - lastModified() --------> 1461739170173
			 *  - yyyy/mm/dd hh:mm:ss ---> 2016/04/27 15:39:30
			 *  - length() --------------> 816528
			 *  - isDirectory() ---------> false
			 *  - isFile() --------------> true
			 */
			String strName = "N:/TEMP/cosmarter/tain-cosmarter-1.0.jar";
			File file = new File(strName);
			
			if (flag) log.debug(" # File");
			if (flag) log.debug(" - getName() -------------> " + file.getName());
			if (flag) log.debug(" - getAbsolutePath() -----> " + file.getAbsolutePath());
			if (flag) log.debug(" - getCanonicalPath() ----> " + file.getCanonicalPath());
			if (flag) log.debug(" - getParent() -----------> " + file.getParent());
			if (flag) log.debug(" - getPath() -------------> " + file.getPath());
			if (flag) log.debug(" - lastModified() --------> " + file.lastModified());
			if (flag) log.debug(" - yyyy/mm/dd hh:mm:ss ---> " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", file.lastModified()));
			if (flag) log.debug(" - length() --------------> " + file.length());
			if (flag) log.debug(" - isDirectory() ---------> " + file.isDirectory());
			if (flag) log.debug(" - isFile() --------------> " + file.isFile());
		}
		
		if (flag) System.out.println("\n\n");
	}
	
	private static void test02(String[] args) throws Exception {
		
		String strSystemFolder = "N:/TEMP/cosmarter";
		
		if (flag) {
			/* ----------------------------------------------------------------
			 * 2. String[] File.list(FilenameFilter)
			 */
			if (flag) log.info("2. String[] File.list(FilenameFilter) -> " + strSystemFolder);
			
			File file = null;
			String[] files = null;
			
			try {
				// System Folder
				file = new File(strSystemFolder);
				
				// List of files
				files = file.list(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {   // dir : folder name, name : file name
						
						if (flag) log.debug("\t2-1 > " + dir.getName() + "   " + name);
						if (flag) log.debug("\t2-2 > " + dir.getAbsolutePath() + "   " + name);
						if (flag) return true;
						
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
						
						return false;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
			
			// for loop of files
			for (String f : files) {
				
				// print file entry
				log.debug("\t2-3 > " + f);
			}
		}
		
		if (flag) System.out.println("\n\n");
	}
	
	private static void test03(String[] args) throws Exception {
		
		String strSystemFolder = "N:/TEMP/cosmarter";

		if (flag) {
			/* ----------------------------------------------------------------
			 * 3. File[] File.listFiles(FileFilter)
			 */
			if (flag) log.info("3. File[] File.listFiles(FileFilter) -> " + strSystemFolder);

			File file = null;
			File[] files = null;
			
			try {
				// System Folder
				file = new File(strSystemFolder);
				
				// List of files
				files = file.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File file) {
						
						if (flag) {
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
								sb.append(String.format("\t3-1 > "));
								sb.append(String.valueOf(file.getName())).append(" - ");
								sb.append(String.valueOf(file.getAbsolutePath())).append(" - ");
								sb.append(String.valueOf(file.getCanonicalPath())).append(" - ");
								sb.append(String.valueOf(file.lastModified())).append(" - ").append(String.valueOf(new Date(file.lastModified()))).append(" - ").append(tmCal).append(" - ");
								sb.append(String.valueOf(file.length())).append(" - ");
								
								log.debug(sb.toString());
							} catch (Exception e) {
								e.printStackTrace();
							}
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
						
						return false;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
			
			// for loop of files
			for (File f : files) {
				
				// print file entry
				log.debug("\t3-2 > " + f);
			}
		}
		
		if (flag) System.out.println("\n\n");
	}
	
	private static void test04(String[] args) throws Exception {
		
		if (flag) {
			EntryTest01Main.getInstance().print();
			EntryTest01Main.getInstance().getSystemEntry();
		}
	}
	
	private static void test05(String[] args) throws Exception {
		
		String strSystemFolder = "N:/PROG/javadocs_1.6";
		strSystemFolder = "N:/PROG/libs";

		if (flag) {
			/* ----------------------------------------------------------------
			 * 3. File[] File.listFiles(FileFilter)
			 */
			if (flag) log.info("3. File[] File.listFiles(FileFilter) -> " + strSystemFolder);

			File file = null;
			File[] files = null;
			
			try {
				// System Folder
				file = new File(strSystemFolder);
				
				// List of files
				files = file.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File file) {
						
						if (flag) return true;
						
						if (flag) {
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
								sb.append(String.format("\t3-1 > "));
								sb.append(String.valueOf(file.getName())).append(" - ");
								sb.append(String.valueOf(file.getAbsolutePath())).append(" - ");
								sb.append(String.valueOf(file.getCanonicalPath())).append(" - ");
								sb.append(String.valueOf(file.lastModified())).append(" - ").append(String.valueOf(new Date(file.lastModified()))).append(" - ").append(tmCal).append(" - ");
								sb.append(String.valueOf(file.length())).append(" - ");
								
								log.debug(sb.toString());
							} catch (Exception e) {
								e.printStackTrace();
							}
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
						
						return false;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}

			if (!flag) {
				// for loop of files
				for (File f : files) {
					
					// print file entry
					log.debug("\t3-2 > " + f);
				}
			}
			
			if (flag) log.debug("size = " + files.length);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (!flag) test01(args);
		if (!flag) test02(args);
		if (!flag) test03(args);
		if (!flag) test04(args);
		if (flag) test05(args);
	}
}
