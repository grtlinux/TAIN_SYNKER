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
public class SystemBean {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SystemBean.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String systemNo;
	private final String systemName;
	private final String systemDesc;

	private final Map<String, GateBean> mapGate;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public SystemBean(String systemNo, String systemName, String systemDesc) throws Exception {
		
		this.systemNo = systemNo;
		this.systemName = systemName;
		this.systemDesc = systemDesc;

		this.mapGate = new HashMap<String, GateBean>();
	}
	
	public String getSystemNo() {
		return systemNo;
	}

	public String getSystemName() {
		return systemName;
	}

	public String getSystemDesc() {
		return systemDesc;
	}

	public GateBean get(String key) {
		return this.mapGate.get(key);
	}
	
	public void put(String key, GateBean bean) {
		this.mapGate.put(key, bean);
	}
	
	public Map<String, GateBean> getMapGate() {
		return this.mapGate;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return String.format("[NO,NAME,DESC]=[%s,%s,%s]"
				, this.systemNo
				, this.systemName
				, this.systemDesc
				);
	}
	
	public void print() {
		if (flag) {
			log.info(toString());
		}
	}
	
	public void printGate() {
		
		for (Map.Entry<String, GateBean> entry : mapGate.entrySet()) {
			
			String gateKey = entry.getKey();
			GateBean gateBean = entry.getValue();
			
			if (flag) log.debug(String.format("########## [%s] => %s", gateKey, gateBean));
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Map<String, SystemBean> mapSystem = new HashMap<String, SystemBean>();
			
			mapSystem.put("01", new SystemBean("01", "FIRST", "first system"));
			mapSystem.put("02", new SystemBean("02", "SECOND", "second system"));
			mapSystem.put("03", new SystemBean("03", "THIRD", "third system"));
			
			for (Map.Entry<String,SystemBean> entryBean : mapSystem.entrySet()) {
				String systemNo = entryBean.getKey();
				SystemBean bean = (SystemBean) entryBean.getValue();
				
				log.debug(">>> " + systemNo + "  " + bean);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
