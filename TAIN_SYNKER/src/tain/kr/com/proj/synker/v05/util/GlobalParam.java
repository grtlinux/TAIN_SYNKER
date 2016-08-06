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
package tain.kr.com.proj.synker.v05.util;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : GlobalParam.java
 *   -. Package    : tain.kr.com.proj.synker.v05.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class GlobalParam {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(GlobalParam.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String serviceType = null;  // TEST-1, TEST-2, REAL
	private String serviceName = null;  // version, client, server etc
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private GlobalParam() {}
	
	public String getServiceType() {
		return serviceType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return String.format("[%s,%s]"
				, this.serviceType
				, this.serviceName
				);
	}
	
	public void print() {
		
		if (flag) {
			log.debug("GlobalParam is " + this);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static GlobalParam instance = null;
	
	public static synchronized GlobalParam getInstance() throws Exception {
		
		if (instance == null) {
			instance = new GlobalParam();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
