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
package tain.kr.com.proj.synker.v06.common;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : GlobalVariable.java
 *   -. Package    : tain.kr.com.proj.synker.v06.main.test.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class GlobalVars {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(GlobalVars.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String trCode = null;
	private String cliTrClass = null;
	private String svrTrClass = null;

	///////////////////////////////////////////////////////////////////////////////////////////////

	private GlobalVars() {}
	
	public String getTrCode() {
		return trCode;
	}

	public String getCliTrClass() {
		return cliTrClass;
	}

	public String getSvrTrClass() {
		return svrTrClass;
	}

	public void setTrCode(String trCode) {
		this.trCode = trCode;
	}

	public void setCliTrClass(String cliTrClass) {
		this.cliTrClass = cliTrClass;
	}

	public void setSvrTrClass(String svrTrClass) {
		this.svrTrClass = svrTrClass;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		sb.append(String.format("\t[trCode    =%s]\n", trCode));
		sb.append(String.format("\t[cliTrClass=%s]\n", cliTrClass));
		sb.append(String.format("\t[svrTrClass=%s]\n", svrTrClass));
		
		return sb.toString();
	}
	
	public void print() throws Exception {
		
		if (flag) log.debug(">>>>> " + toString());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static GlobalVars instance = null;
	
	public synchronized static GlobalVars getInstance() throws Exception {
		
		if (instance == null) {
			instance = new GlobalVars();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			GlobalVars.getInstance().print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
