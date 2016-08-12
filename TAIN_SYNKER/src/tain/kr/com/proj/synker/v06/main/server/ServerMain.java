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
package tain.kr.com.proj.synker.v06.main.server;

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ServerMain.java
 *   -. Package    : tain.kr.com.proj.synker.v06.main.test.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ServerMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ServerMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void serverModule() throws Exception {
		
		if (flag) {
			/*
			 * Server Module
			 * to create server socket
			 */
			
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(12345);
			if (flag) log.info(String.format(" SERVER : listening by port '12345' [%s]", serverSocket.toString()));
			
			for (int idxThr=0; ; idxThr++) {
				if (idxThr > 100000000)
					idxThr = 0;
				
				Socket socket = serverSocket.accept();
				if (flag) log.info(String.format(" SERVER : accept the connection (%s)", socket));

				if (flag) {
					/*
					 * execute thread
					 * close socket after finishing
					 */
					try {
						Thread thr = new ServerThread(idxThr, socket);
						thr.start();
						
						if (flag) {
							/*
							 * wait for ending of thread
							 */
							thr.join();
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (socket != null) try { socket.close(); socket = null; } catch (Exception e) {}
					}
				}
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
		
		if (flag) serverModule();
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (args.length < 2) {
			args = new String[] { "TEST-2", "server" };
		}

		if (flag) test01(args);
	}
}
