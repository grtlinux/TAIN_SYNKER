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
package tain.kr.com.proj.synker.v06.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ServiceBean.java
 *   -. Package    : tain.kr.com.proj.synker.v06.bean
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TrBean {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TrBean.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String trKey = null;      //  trKey = trName
	private String trName = null;
	private String trCliClass = null;
	private String trSvrClass = null;
	private String trDesc = null;

	public TrBean() {}
	
	public TrBean(String trKey, String trName, String trCliClass, String trSvrClass, String trDesc) {
		
		if (flag) {
			this.trKey = trKey;
			this.trName = trName;
			this.trCliClass = trCliClass;
			this.trSvrClass = trSvrClass;
			this.trDesc = trDesc;
		}
	}
	
	public String getTrKey() {
		return trKey;
	}

	public String getTrName() {
		return trName;
	}

	public String getTrCliClass() {
		return trCliClass;
	}

	public String getTrSvrClass() {
		return trSvrClass;
	}

	public String getTrDesc() {
		return trDesc;
	}

	public void setTrKey(String trKey) {
		this.trKey = trKey;
	}

	public void setTrName(String trName) {
		this.trName = trName;
	}

	public void setTrCliClass(String trCliClass) {
		this.trCliClass = trCliClass;
	}

	public void setTrSvrClass(String trSvrClass) {
		this.trSvrClass = trSvrClass;
	}

	public void setTrDesc(String trDesc) {
		this.trDesc = trDesc;
	}

	public String toString() {
		return String.format("[KEY,NAME,CLICLS,SVRCLS,DESC]=[%s,%s,%s,%s,%s]"
				, this.trKey
				, this.trName
				, this.trCliClass
				, this.trSvrClass
				, this.trDesc
				);
	}
	
	public void print() {
		if (flag) {
			log.info(toString());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Map<String, TrBean> mapTr = new HashMap<String, TrBean>();
			
			mapTr.put("TT0000", new TrBean("TT0000", "TT0000", "tain.krtain.kr.com.proj.synker.v06.tr.cli.CLITR", "tain.krtain.kr.com.proj.synker.v06.tr.svr.SVRTR", "to get current date and time, long value"));
			
			for (Map.Entry<String,TrBean> entryBean : mapTr.entrySet()) {
				String trKey = entryBean.getKey();
				TrBean bean = (TrBean) entryBean.getValue();
				
				log.debug(">>> " + trKey + "  " + bean);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
