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

import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v06.common.GlobalVars;
import tain.kr.com.proj.synker.v06.stream.PipedStream;
import tain.kr.com.proj.synker.v06.stream.SocketStream;
import tain.kr.com.proj.synker.v06.util.ThreadInvoke;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ServerThread.java
 *   -. Package    : tain.kr.com.proj.synker.v06.main.test.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ServerThread extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ServerThread.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unused")
	private int idxThr = -1;
	private Socket socket = null;
	
	private SocketStream ss = null;
	private PipedStream ps = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public ServerThread(int idxThr, Socket socket) throws Exception {
		
		super(String.format("SERVER_THREAD_%010d", idxThr));
		
		if (flag) {
			this.idxThr = idxThr;
			this.socket = socket;
			this.ss = new SocketStream(this.socket);
			this.ps = new PipedStream();
			
			if (flag) log.debug(String.format("########## START <%s> ########## socket=%s ", this.getName(), this.socket.toString()));
		}

		if (flag) {
			/*
			 * use class
			 * elements class, constructor, run method
			 */
			// ThreadInvoke.execute(ps, "tain.kr.com.proj.synker.v06.main.test.v06.SVRTR");
			ThreadInvoke.execute(ps, GlobalVars.getInstance().getSvrTrClass());
		}
	}
	
	public void run() {
		
		if (flag) {
			
			String req = null;
			String res = null;
			
			try {

				if (flag) {
					/*
					 * read req from socket
					 */
					req = this.ss.read();
				}
				
				if (flag) {
					/*
					 * parent thread, main thread
					 */
					
					if (flag) log.debug(">>>>> REQ = [" + req + "]");

					if (flag) {
						/*
						 * ReqWrite to piped stream IN
						 */
						
						this.ps.reqWrite(req);
					}
					
					if (flag) {
						/*
						 * ResRead from piped stream OUT
						 */
						
						res = this.ps.resRead();
					}
					
					if (flag) log.debug(">>>>> RES = [" + res + "]");
				}
				
				if (flag) {
					/*
					 * write res to socket
					 */
					this.ss.setHeader("RES", "TR0000", "00000", "SUCCESS");
					
					this.ss.write(res);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { this.ps.close(); } catch (Exception e) {}
				try { this.ss.close(); } catch (Exception e) {}

				if (flag) log.debug(String.format("########## FINISH <%s> ##########\n", this.getName()));
			}
		}
	}
}
