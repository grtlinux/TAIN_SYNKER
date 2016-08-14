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
package tain.kr.com.proj.synker.v06.tr.svr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v06.bean.TrBean;
import tain.kr.com.proj.synker.v06.common.GlobalVars;
import tain.kr.com.proj.synker.v06.stream.PipedStream;
import tain.kr.com.proj.synker.v06.util.ThreadInvoke;
import tain.kr.com.proj.synker.v06.util.TrMap;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SvrTr0000.java
 *   -. Package    : tain.kr.com.proj.synker.v06.tr.svr
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 13. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SvrTt1001 extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SvrTt1001.class);

	private PipedStream ps = null;
	
	public SvrTt1001(PipedStream ps) {
		
		if (flag) {
			this.ps = ps;
		}
	}
	
	public void run() {

		if (flag) {
			/*
			 * thread, job thread
			 */
			
			String req = null;
			String res = null;
			
			try {
				
				if (flag) {
					/*
					 * 1. ReqRead
					 */
					
					req = ps.reqRead();
				}
				
				if (flag) {
					/*
					 * 2. communicate from client
					 */
					communicate();
					
					res = String.format("%s|%s", req, "OK!!!!!");
					
					if (flag) log.debug("@@@@@ REQ [" + req + "] >>>>> RES [" + res + "]");
				}
				
				if (flag) {
					/*
					 * 3. ResWrite
					 */
					ps.resWrite(res);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void communicate() throws Exception {
		
		if (flag) {
			/*
			 * Server Module
			 * to create server socket
			 */

			ServerSocket serverSocket = null;
			Socket socket = null;
			DataInputStream dis = null;
			DataOutputStream dos = null;
			
			byte[] data = null;
			
			try {
				
				serverSocket = new ServerSocket(12346);
				/*
				 * SO_TIMEOUT : ServerSocket
				 * Enable/disable SO_TIMEOUT with the specified timeout, in milliseconds. With this operation set to a non-zero timeout,
				 * a call to accept() for this ServerSocket will block for only this amount of time.
				 * If the timeout expires, a java.net.SocketTimeoutException is raised, though the ServerSocket is still valid.
				 * The option must be enabled prior to entering the blocking operation to have effect. The timeout must be > 0.
				 * A timeout of zero is interpreted as an infinite timeout.
				 */
				serverSocket.setSoTimeout(2000);
				if (flag) log.info(String.format(" SUB SERVER : listening by port '12346' [%s]", serverSocket.toString()));
				
				socket = serverSocket.accept();
				if (flag) log.info(String.format(" SUB SERVER : accept the connection (%s)", socket));

				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				
				if (flag) {
					/*
					 * write
					 */
					data = "Hello, World(SERVER)".getBytes();
					dos.write(data);
					
					if (flag) log.debug(" SUB CLIENT : write[" + new String(data) + "]");
				}
				
				if (flag) {
					/*
					 * SO_TIMEOUT : Socket
					 * Enable/disable SO_TIMEOUT with the specified timeout, in milliseconds. With this operation set to a non-zero timeout,
					 * a read() call on the InputStream associated with this Socket will block for only this amount of time.
					 * If the timeout expires, a java.net.SocketTimeoutException is raised, though the Socket is still valid.
					 * The option must be enabled prior to entering the blocking operation to have effect. The timeout must be >0.
					 * A timeout of zero is interpreted as an infinite timeout.
					 */
					socket.setSoTimeout(2000);
				}
				
				if (flag) {
					/*
					 * read
					 */
					data = new byte[20];
					dis.read(data);
					
					if (flag) log.debug(" SUB CLIENT : read [" + new String(data) + "]");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (dis != null) try { dis.close(); dis = null; } catch (Exception e) {}
				if (dos != null) try { dos.close(); dos = null; } catch (Exception e) {}
				if (socket != null) try { socket.close(); socket = null; } catch (Exception e) {}
				if (serverSocket != null) try { serverSocket.close(); socket = null; } catch (Exception e) {}
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * 1. Test
	 */
	private static void test01(String[] args) throws Exception {
		
		PipedStream ps = null;
		
		if (flag) {
			/*
			 * create piped stream object
			 */
			ps = new PipedStream();
		}
		
		if (flag) {
			/*
			 * TrMap to set global vars
			 */
			TrBean bean = TrMap.getInstance().getBean("TR0000");   // TODO 2016.08.12
			
			GlobalVars.getInstance().setTrCode(bean.getTrName());
			GlobalVars.getInstance().setCliTrClass(bean.getTrCliClass());
			GlobalVars.getInstance().setSvrTrClass(bean.getTrSvrClass());
		}

		if (flag) {
			/*
			 * use class
			 * elements class, constructor, run method
			 */
			ThreadInvoke.execute(ps, GlobalVars.getInstance().getSvrTrClass());
		}

		/////////////////////////////////////////////////
		
		if (flag) {
			/*
			 * parent thread, main thread
			 */
			
			String req = "GET_DATE_TIME(" + (int) (Math.random() * 200) + ")";
			String res = null;
			
			try {
				
				if (flag) log.debug(">>>>> REQ = [" + req + "]");

				if (flag) {
					/*
					 * ReqWrite
					 */
					
					ps.reqWrite(req);
				}
				
				if (flag) {
					/*
					 * ResRead
					 */
					
					res = ps.resRead();
				}
				
				if (flag) log.debug(">>>>> RES = [" + res + "]");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (flag) {
			/*
			 * close piped stream object
			 */
			ps.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
