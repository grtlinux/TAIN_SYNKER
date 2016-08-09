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
package tain.kr.com.proj.synker.v05.main.test.v06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ServerThread.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v02
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
	
	private static final int BUF_SIZ = 1024;
	
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
			 * job thread, tr thread
			 */
			
			// class
			Class<?> cls = Class.forName("tain.kr.com.proj.synker.v05.main.test.v06.SVRTR");
			
			// constructor argument types
			Class<?>[] types = new Class[] { PipedStream.class };
			Object[] constructorArgs = new Object[] { this.ps };

			// execute constructor
			Constructor<?> constructor = cls.getConstructor(types);
			Object instance = constructor.newInstance(constructorArgs);
			
			// execute run method of thread
			//Method method = cls.getMethod("run");
			Method method = cls.getMethod("start");
			method.invoke(instance);
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
					byte[] buf = new byte[BUF_SIZ];
					
					int cntRead = this.ss.read(buf);
					if (cntRead <= 0) {
						throw new Exception("ERROR : reading error");
					}
					
					req = new String(buf, 0, cntRead);
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
						
						ps.reqWrite(req);
					}
					
					if (flag) {
						/*
						 * ResRead from piped stream OUT
						 */
						
						res = ps.resRead();
					}
					
					if (flag) log.debug(">>>>> RES = [" + res + "]");
				}
				
				if (flag) {
					/*
					 * write res to socket
					 */
					this.ss.setHeader("PACKET_SERVER_HEADER");
					
					byte[] buf = res.getBytes();
					
					this.ss.write(buf);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { this.ps.close(); } catch (Exception e) {}
				try { this.ss.close(); } catch (Exception e) {}
			}
		}
		
		if (flag) {
			if (flag) log.debug(String.format("########## FINISH <%s> ##########\n\n", this.getName()));
		}
		
		if (!flag) {
			/*
			 * TODO 2016.08.09 : for testing
			 * clear STD_IO for testing.
			 */
			System.out.println("before clearation of STD_IO");
			System.setIn(null);
			System.setOut(null);
			System.out.println("after clearation of STD_IO");
		}
	}
}
