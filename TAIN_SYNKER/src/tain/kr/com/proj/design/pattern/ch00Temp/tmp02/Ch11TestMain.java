/**
 * Copyright 2014, 2015, 2016 TAIN, Inc. all rights reserved.
 *
 * Licensed under the GNU GENERAL PUBLIC LICENSE, Version 3, 29 June 2007 (the "License");
 * you may not use this Ch11File except in compliance with the License.
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

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. Ch11FileName   : Ch11TestMain.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch00Temp.tmp02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Ch11TestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Ch11TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			System.out.println("Making root entries...");
			
			Ch11Folder rootdir = new Ch11Folder("root");
			Ch11Folder bindir = new Ch11Folder("bin");
			Ch11Folder tmpdir = new Ch11Folder("tmp");
			Ch11Folder usrdir = new Ch11Folder("usr");
			
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			
			bindir.add(new Ch11File("vi", 10000));
			bindir.add(new Ch11File("latex", 20000));
			
			rootdir.printList();
			
			System.out.println();
			
			System.out.println("Making user entries...");
			
			Ch11Folder kim = new Ch11Folder("kim");
			Ch11Folder lee = new Ch11Folder("lee");
			Ch11Folder kang = new Ch11Folder("kang");
			
			usrdir.add(kim);
			usrdir.add(lee);
			usrdir.add(kang);
			
			kim.add(new Ch11File("diary.html", 100));
			kim.add(new Ch11File("Composite.java", 200));
			lee.add(new Ch11File("memo.txt", 300));
			kang.add(new Ch11File("game.doc", 400));
			kang.add(new Ch11File("junk.mail", 500));
			
			rootdir.printList();
		}

		if (flag) {
			
			Ch11Folder root = new Ch11Folder("root");
			
			Ch11Folder usr = new Ch11Folder("usr");
			root.add(usr);
			
			Ch11Folder kim = new Ch11Folder("kim");
			usr.add(kim);
			
			Ch11File Ch11File = new Ch11File("Composite.java", 100);
			kim.add(Ch11File);
			
			root.printList();
			
			System.out.println();
			System.out.println("Ch11File = " + Ch11File.getFullName());
			System.out.println("kim = " + kim.getFullName());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object() {}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
