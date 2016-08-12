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
public class ServiceBean {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ServiceBean.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String serviceNo = null;
	private String serviceName = null;
	private String serviceClass = null;
	private String propFile = null;

	public ServiceBean() {}
	
	public ServiceBean(String serviceNo, String serviceName, String serviceClass, String propFile) {
		
		if (flag) {
			this.serviceNo = serviceNo;
			this.serviceName = serviceName;
			this.serviceClass = serviceClass;
			this.propFile = propFile;
		}
	}
	
	public String getServiceNo() {
		return serviceNo;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	public String getServiceClass() {
		return serviceClass;
	}
	
	public String getPropFile() {
		return propFile;
	}
	
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}
	
	public void setPropFile(String propFile) {
		this.propFile = propFile;
	}
	
	public String toString() {
		return String.format("[NO,NAME,CLASS,FILE]=[%s,%s,%s,%s]"
				, this.serviceNo
				, this.serviceName
				, this.serviceClass
				, this.propFile
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
			Map<String, ServiceBean> mapService = new HashMap<String, ServiceBean>();
			
			mapService.put("version", new ServiceBean("01", "version", "tain.kr.com.proj.synker.v06.main.tool.VersionMain", "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/VersionMain.properties"));
			mapService.put("server", new ServiceBean("02", "server", "tain.kr.com.proj.synker.v06.main.server.ServerMain", "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/ServerMain.properties"));
			mapService.put("client", new ServiceBean("03", "client", "tain.kr.com.proj.synker.v06.main.client.ClientMain", "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/ClientMain.properties"));
			
			for (Map.Entry<String,ServiceBean> entryBean : mapService.entrySet()) {
				String serviceNo = entryBean.getKey();
				ServiceBean bean = (ServiceBean) entryBean.getValue();
				
				log.debug(">>> " + serviceNo + "  " + bean);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
