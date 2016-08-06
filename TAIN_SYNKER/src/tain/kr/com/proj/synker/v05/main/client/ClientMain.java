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
package tain.kr.com.proj.synker.v05.main.client;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v05.util.GlobalParam;
import tain.kr.com.proj.synker.v05.util.ServiceMap;
import tain.kr.com.proj.synker.v05.util.ServiceProperties;
import tain.kr.com.proj.synker.v05.version.Version;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ClientMain.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.client
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ClientMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ClientMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String KEY_CONNECT_HOST = "tain.kr.client.connect.host";
	private static final String KEY_CONNECT_PORT = "tain.kr.client.connect.port";

	private static String host = null;
	private static String port = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void clientModule() throws Exception {
		
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * print for checking arguments
			 */
			for (String arg : args) {
				log.debug("ARG [" + arg + "]");
			}
		}
		
		if (flag) {
			/*
			 * to set the name of service
			 */
			GlobalParam.getInstance().setServiceType(args[0]);
			GlobalParam.getInstance().setServiceName(args[1]);
		}
		
		if (flag) {
			/*
			 * to print the version info
			 */
			Version.getInstance().print();
		}
		
		if (flag) {
			/*
			 * to print the info of version service
			 */
			ServiceMap.getInstance().getBean(GlobalParam.getInstance().getServiceName()).print();
		}
		
		if (flag) {
			/*
			 * to check the service properties
			 */
			
			ServiceProperties.getInstance().print();
		}
		
		if (flag) {
			/*
			 * to get the information of connection
			 */
			ClientMain.host = ServiceProperties.getInstance().get(KEY_CONNECT_HOST);
			if (flag) log.info(" CLIENT : connect host is '" + ClientMain.host + "'");

			ClientMain.port = ServiceProperties.getInstance().get(KEY_CONNECT_PORT);
			if (flag) log.info(" CLIENT : connect port is '" + ClientMain.port + "'");
		}
		
		if (flag) clientModule();
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (args.length < 2) {
			args = new String[] { "TEST-2", "client" };
		}

		if (flag) test01(args);
	}
}
