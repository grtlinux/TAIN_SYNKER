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
package tain.kr.com.proj.synker.v03.server;

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v03.util.SynkerProperties;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SynkerServer.java
 *   -. Package    : tain.kr.com.proj.synker.v02.Server
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SynkerServer {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SynkerServer.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String KEY_LISTEN_PORT = "tain.kr.synker.server.listen.port";
	
	private String strListenPort = null;
	
	private SynkerServer() throws Exception {
		
		if (flag) {
			this.strListenPort = SynkerProperties.getInstance().get(KEY_LISTEN_PORT);
		}
		
		if (flag) {
			log.debug("[LISTEN PORT = " + this.strListenPort + "]");
		}
	}
	
	public void execute() throws Exception {
		
		if (flag) {
			/*
			 * server socket program
			 */
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(this.strListenPort));

			if (flag) log.debug(String.format("SERVER : listening by port %s [%s]", this.strListenPort, serverSocket.toString()));
			
			for (int idxThr = 0; ; idxThr ++) {
				if (idxThr > 100000000)
					idxThr = 0;
				
				Socket socket = serverSocket.accept();
				if (flag) log.debug(String.format("SERVER : accept the connection(%d)", idxThr));
				
				Thread thr = new SynkerServerThread(idxThr, socket);
				thr.start();
				thr.join();
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static SynkerServer instance = null;
	
	public static synchronized SynkerServer getInstance() throws Exception {
		
		if (instance == null) {
			instance = new SynkerServer();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}
