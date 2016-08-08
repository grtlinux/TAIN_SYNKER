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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
	
	@SuppressWarnings("unused")
	private int idxThr = -1;
	private Socket socket = null;
	
	private SocketStream sm = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public ServerThread(int idxThr, Socket socket) throws Exception {
		
		super(String.format("SERVER_THREAD_%010d", idxThr));
		
		if (flag) {
			this.idxThr = idxThr;
			this.socket = socket;
			this.sm = new SocketStream(this.socket);
			
			if (flag) log.debug(String.format("########## START <%s> ########## socket=%s ", this.getName(), this.socket.toString()));
		}
	}
	
	public void run() {
		
		if (flag) {
			
			try {
				if (flag) {
					/*
					 * read
					 */
					byte[] buf = new byte[50];
					
					int cntRead = this.sm.read(buf);
					if (cntRead <= 0) {
						throw new Exception("ERROR : reading error");
					}
				}
				
				if (!flag) {
					/*
					 * to set redirection and to run the class of server module
					 */
					
					if (flag) {
						/*
						 * redirect definition
						 */
						InputStream is = null;
						is = new ByteArrayInputStream("GET_DATE_TIME".getBytes());
						
						PrintStream ps = null;
						//ps = new PrintStream("N:/123");
						ps = new PrintStream(System.out);
						
						System.setIn(is);
						System.setOut(ps);
						System.setErr(ps);
					}
					
					if (flag) {
						/*
						 * execute the class of server module after redirection
						 */
						String clsName = GlobalVars.getInstance().getClsServer();
						
						Class<?> cls = Class.forName(clsName);
						
						Method main = cls.getDeclaredMethod("main", new Class[] { String[].class });
						
						main.invoke(null, (Object) new String[] { "Hello", "World!!!" });
					}
				}
				
				if (flag) {
					/*
					 * write
					 */
					this.sm.setHeader("PACKET_SERVER_HEADER");
					
					byte[] buf = "SERVER RESULT".getBytes();
					
					this.sm.write(buf);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { this.sm.close(); } catch (Exception e) {}
			}
		}
		
		if (flag) {
			if (flag) log.debug(String.format("########## FINISH <%s> ##########\n\n", this.getName()));
		}
		
		if (flag) {
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
