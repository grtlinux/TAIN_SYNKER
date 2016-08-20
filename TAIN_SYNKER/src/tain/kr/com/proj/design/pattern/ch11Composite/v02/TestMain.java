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
package tain.kr.com.proj.design.pattern.ch11Composite.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TestMain.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch11Composite.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			System.out.println("Making root entries...");
			
			Folder rootdir = new Folder("root");
			Folder bindir = new Folder("bin");
			Folder tmpdir = new Folder("tmp");
			Folder usrdir = new Folder("usr");
			
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			
			bindir.add(new File("vi", 10000));
			bindir.add(new File("latex", 20000));
			
			rootdir.printList();
			
			System.out.println();
			
			System.out.println("Making user entries...");
			
			Folder kim = new Folder("kim");
			Folder lee = new Folder("lee");
			Folder kang = new Folder("kang");
			
			usrdir.add(kim);
			usrdir.add(lee);
			usrdir.add(kang);
			
			kim.add(new File("diary.html", 100));
			kim.add(new File("Composite.java", 200));
			lee.add(new File("memo.txt", 300));
			kang.add(new File("game.doc", 400));
			kang.add(new File("junk.mail", 500));
			
			rootdir.printList();

			System.out.println();
		}
		
		if (flag) {
			
			Folder root = new Folder("root");
			
			Folder usr = new Folder("usr");
			root.add(usr);
			
			Folder kim = new Folder("kim");
			usr.add(kim);
			
			File file = new File("Composite.java", 100);
			kim.add(file);
			
			root.printList();
			
			System.out.println();
			System.out.println("file = " + file.getFullName());
			System.out.println("kim = " + kim.getFullName());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
