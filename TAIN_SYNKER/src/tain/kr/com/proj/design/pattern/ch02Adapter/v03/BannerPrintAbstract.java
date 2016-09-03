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
package tain.kr.com.proj.design.pattern.ch02Adapter.v03;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BannerPrintAbstract.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch02Adapter.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 3. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BannerPrintAbstract extends PrintAbstract {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Banner banner;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public BannerPrintAbstract(String name) {
		this.banner = new Banner(name);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void printWeak() {
		System.out.println("[" + this.getClass().getName() + "]");
		System.out.println(">>>>> printWeak() " + this.banner.getName());
	}

	@Override
	public void printStrong() {
		System.out.println("[" + this.getClass().getName() + "]");
		System.out.println(">>>>> printStrong() " + this.banner.getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
