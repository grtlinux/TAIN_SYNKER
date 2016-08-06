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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v05.common.PacketHeader;
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
	
	private static Socket socket = null;
	private static DataInputStream dis = null;
	private static DataOutputStream dos = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void clientModule() throws Exception {
		
		if (flag) {
			socket = new Socket(host, Integer.parseInt(port));
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		}
		
		if (flag) {
			/*
			 * TODO : version 0.2 at 2016.02.29
			 *     
			 *     1. pre job
			 *     
			 *       2. send header
			 *       
			 *         3. send data
			 *         
			 *           4. execute job
			 *           
			 *         5. recv header
			 *         
			 *       6. recv data
			 *       
			 *     7. post job
			 *     
			 */
			try {
				
				byte[] header = null;
				byte[] body = null;
				int bodyLen = 0;
				
				if (flag) {
					/*
					 * 1. pre job
					 */
					
					body = "DEPLOY TIME".getBytes("EUC-KR");
					bodyLen = body.length;
					
					if (flag) log.debug(String.format("-- 1. DATA [%d:%s]", bodyLen, new String(body)));
				}
				
				if (flag) {
					/*
					 * 2. send header
					 */
					
					header = PacketHeader.makeBytes();
					PacketHeader.TR_CODE.setVal(header, "TR0000");
					PacketHeader.BODY_LEN.setVal(header, String.valueOf(bodyLen));
					
					dos.write(header, 0, header.length);
					if (flag) log.debug(String.format("-> 2. REQ SEND HEADER [%s]", new String(header)));
				}
				
				if (flag) {
					/*
					 * 3. send data
					 */
					
					dos.write(body, 0, bodyLen);
					if (flag) log.debug(String.format("-> 3. REQ SEND DATA   [%s]", new String(body)));
				}
				
				if (flag) {
					/*
					 * 4. execute job
					 */
					
					if (flag) log.debug(String.format("-- 4. don't execute local job"));
				}
				
				if (flag) {
					/*
					 * 5. recv header
					 */
					
					header = recv(header.length);
					if (flag) log.debug(String.format("<- 5. RES RECV HEADER [%s]", new String(header)));
					
					bodyLen = Integer.parseInt(PacketHeader.BODY_LEN.getString(header));
				}
				
				if (flag) {
					/*
					 * 6. recv data
					 */
					
					body = recv(bodyLen);
					if (flag) log.debug(String.format("<- 6. RES RECV DATA   [%s]", new String(body)));
				}
				
				if (flag) {
					/*
					 * 7. post job
					 */
					
					if (flag) log.debug(String.format("-- 7. DATA [%d:%s]", bodyLen, new String(body)));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (dis != null) try { dis.close(); } catch (Exception e) {}
				if (dos != null) try { dos.close(); } catch (Exception e) {}
				if (socket != null) try { socket.close(); } catch (Exception e) {}
			}
		}
	}
	
	private static byte[] recv(final int size) throws Exception {
		
		int ret = 0;
		int readed = 0;
		byte[] buf = new byte[size];
		
		socket.setSoTimeout(0);
		while (readed < size) {
			ret = dis.read(buf, readed, size - readed);
			if (!flag) log.debug("    size:" + size + "    readed:" + readed + "     ret:" + ret);
			
			if (ret <= 0) {
				try { Thread.sleep(1000); } catch (Exception e) {}
				continue;
			} else {
				if (flag) socket.setSoTimeout(1000);
			}
			
			readed += ret;
		}
		
		return buf;
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
