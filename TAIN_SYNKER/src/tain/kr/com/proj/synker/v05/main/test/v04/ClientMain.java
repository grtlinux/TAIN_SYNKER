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
package tain.kr.com.proj.synker.v05.main.test.v04;

import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ClientMain.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ClientMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ClientMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void clientModule() throws Exception {
		
		if (flag) {
			
			Socket socket = null;
			SocketStream sm = null;
			
			try {
				
				socket = new Socket("127.0.0.1", 12345);
				if (flag) log.info(String.format(" CLIENT : connection by port '12345' [%s]", socket.toString()));
				
				sm = new SocketStream(socket);

				if (flag) {
					/*
					 * write
					 */
					
					sm.setHeader("PACKET_CLIENT_HEADER");

					byte[] buf = "CLIENT REQUEST".getBytes();
					
					sm.write(buf);
				}

				if (flag) {
					/*
					 * read
					 */
					byte[] buf = new byte[50];
					
					int cntRead = sm.read(buf);
					if (cntRead <= 0) {
						throw new Exception("ERROR : reading error");
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sm.close();
			}
		}
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
