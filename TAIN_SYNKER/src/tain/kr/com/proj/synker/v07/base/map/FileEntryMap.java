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
package tain.kr.com.proj.synker.v07.base.map;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v07.base.bean.GateBean;
import tain.kr.com.proj.synker.v07.base.bean.SystemBean;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FileEntryMap.java
 *   -. Package    : tain.kr.com.proj.synker.v07.base.map
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FileEntryMap {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FileEntryMap.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Map<String, FileEntryMap> mapFileEntry = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private FileEntryMap() throws Exception {
		
		if (flag) {
			/*
			 * create mapFileEntry
			 */
			if (this.mapFileEntry == null) {
				this.mapFileEntry = new HashMap<String, FileEntryMap>();
			}
		}
		
		if (flag) {
			checkMap();
		}
	}
	
	private void checkMap() throws Exception {
		
		if (flag) {
			Map<String, SystemBean> mapSystem = SystemMap.getInstance().getMapSystem();
			
			for (Map.Entry<String, SystemBean> entrySystem : mapSystem.entrySet()) {
				String keySystem = entrySystem.getKey();
				SystemBean beanSystem = entrySystem.getValue();
				
				if (!flag) log.debug(String.format(">>>>> [%s] = [%s]", keySystem, beanSystem));
				
				Map<String, GateBean> mapGate = beanSystem.getMapGate();
				
				for (Map.Entry<String, GateBean> entryGate : mapGate.entrySet()) {
					String keyGate = entryGate.getKey();
					GateBean beanGate = entryGate.getValue();
					
					if (!flag) log.debug(String.format(">>>>>>>>>> [%s] = [%s]", keyGate, beanGate));
					
					String systemName = beanSystem.getSystemName();
					String gateName = beanGate.getGateName();
					String parentPath = beanGate.getGateFolder();
					
					if (flag) log.debug(String.format("[%s] [%s] [%s]", systemName, gateName, parentPath));
					
					
					/*
					 * TODO 2016.08.24
					 */
					
					
					
					
					
					
					if (flag) return;
				}
			}
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static FileEntryMap instance = null;
	
	public static synchronized FileEntryMap getInstance() throws Exception {
		
		if (instance == null) {
			instance = new FileEntryMap();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * instance of system map
			 */
			FileEntryMap.getInstance();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
