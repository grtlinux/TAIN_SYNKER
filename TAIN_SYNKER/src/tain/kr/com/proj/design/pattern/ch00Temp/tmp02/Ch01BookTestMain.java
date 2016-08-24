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

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Ch01BookTestMain.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch00Temp.tmp02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Ch01BookTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Ch01BookTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			Ch01BookContent content = new Ch01BookContent();
			
			content.add(new Ch01Book("Around the world in 80 days"));;
			content.add(new Ch01Book("Bible"));;
			content.add(new Ch01Book("Cinderella"));;
			content.add(new Ch01Book("Daddy-long-legs"));;
			content.add(new Ch01Book("East of Eden"));;
			content.add(new Ch01Book("Frankestein"));;
			content.add(new Ch01Book("Guliver's travels"));;
			content.add(new Ch01Book("Hamlet"));;
			
			Ch01BookTool tool = content.getTool();
			while (tool.hasNext()) {
				log.debug(tool.next());
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object() {}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
