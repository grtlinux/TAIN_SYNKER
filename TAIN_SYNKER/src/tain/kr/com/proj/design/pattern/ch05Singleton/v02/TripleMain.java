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
package tain.kr.com.proj.design.pattern.ch05Singleton.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TripleMain.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch05Singleton.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TripleMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TripleMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final int id;
	
	private TripleMain(int id) {
		this.id = id;
		System.out.println("The instance " + id + " is created...");
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		return String.format("[Triple id = %d]", this.id);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final int CNT = 3;
	
	private static TripleMain[] tripleMain = null;
	
	public static synchronized TripleMain getInstance(int no) {
		int id = no % CNT;
		
		if (tripleMain == null) {
			
//			if (flag) {
//				/*
//				 * 
//				 */
//				tripleMain = new TripleMain[] {
//					new TripleMain(0),	
//					new TripleMain(1),	
//					new TripleMain(2),	
//				};
//			}
			
			if (flag) {
				/*
				 * 
				 */
				tripleMain = new TripleMain[CNT];
				
				for (int i=0; i < CNT; i++) {
					tripleMain[i] = new TripleMain(i);
				}
			}
		}
		
		return tripleMain[id];
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			System.out.println("Start...");
			
			for (int i=0; i < 10; i++) {
				TripleMain triple = TripleMain.getInstance(i);
				System.out.println(i + ":" + triple);
			}
			
			System.out.println("End.....");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
