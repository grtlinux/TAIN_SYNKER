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
package tain.kr.com.proj.synker.v07.base.bean;

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
public class GateBean {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(GateBean.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String gateNo = null;
	private String gateName = null;
	private String gateFolder = null;
	private String gateType = null;
	private String gateDesc = null;

	public GateBean() {}
	
	public GateBean(String gateNo, String gateName, String gateFolder, String gateType, String gateDesc) {
		
		if (flag) {
			this.gateNo = gateNo;
			this.gateName = gateName;
			this.gateFolder = gateFolder;
			this.gateType = gateType;
			this.gateDesc = gateDesc;
		}
	}

	public String getGateNo() {
		return gateNo;
	}

	public String getGateName() {
		return gateName;
	}

	public String getGateFolder() {
		return gateFolder;
	}

	public String getGateType() {
		return gateType;
	}

	public String getGateDesc() {
		return gateDesc;
	}

	public void setGateNo(String gateNo) {
		this.gateNo = gateNo;
	}

	public void setGateName(String gateName) {
		this.gateName = gateName;
	}

	public void setGateFolder(String gateFolder) {
		this.gateFolder = gateFolder;
	}

	public void setGateType(String gateType) {
		this.gateType = gateType;
	}

	public void setGateDesc(String gateDesc) {
		this.gateDesc = gateDesc;
	}

	public String toString() {
		return String.format("[NO,NAME,FOLDER,TYPE,DESC]=[%s,%s,%s,%s,%s]"
				, this.gateNo
				, this.gateName
				, this.gateFolder
				, this.gateType
				, this.gateDesc
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
			Map<String, GateBean> mapGate = new HashMap<String, GateBean>();
			
			mapGate.put("01", new GateBean("01", "FIRST", "FOLDER", "TYPE-1", "first system"));
			mapGate.put("02", new GateBean("02", "SECOND", "FOLDER", "TYPE-1",  "second system"));
			mapGate.put("03", new GateBean("03", "THIRD", "FOLDER", "TYPE-1",  "third system"));
			
			for (Map.Entry<String,GateBean> entryBean : mapGate.entrySet()) {
				String gateNo = entryBean.getKey();
				GateBean bean = (GateBean) entryBean.getValue();
				
				log.debug(">>> " + gateNo + "  " + bean);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
