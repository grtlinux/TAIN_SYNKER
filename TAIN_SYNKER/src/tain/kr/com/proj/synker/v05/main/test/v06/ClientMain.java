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
			SocketStream ss = null;
			PipedStream ps = null;
			
			Thread thr = null;
			
			String req = null;
			String res = null;
			
			try {
				
				socket = new Socket("127.0.0.1", 12345);
				if (flag) log.info(String.format(" CLIENT : connection by port '12345' [%s]", socket.toString()));
				
				ss = new SocketStream(socket);
				ps = new PipedStream();
				
				if (flag) {
					/*
					 * use class
					 * elements class, constructor, run method
					 */
					// thr = ThreadInvoke.execute(ps, "tain.kr.com.proj.synker.v05.main.test.v06.CLITR");
					thr = ThreadInvoke.execute(ps, GlobalVars.getInstance().getCliTrClass());
				}
				
				if (flag) {
					/*
					 * read req
					 */
					
					req = ps.reqRead();
				}
				
				if (flag) {
					/*
					 * write req to socket
					 */
					
					ss.setHeader("REQ", "TR0000");

					ss.write(req);
				}

				if (flag) {
					/*
					 * read res from socket
					 */
					
					res = ss.read();
				}
				
				if (flag) {
					/*
					 * write res
					 */
					
					ps.resWrite(res);
				}
				
			} catch (Exception e) {
				// e.printStackTrace();
				throw e;
			} finally {
				ss.close();
			}
			
			thr.join();
			
			ps.close();
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

		if (!flag) clientModule();
		
		if (flag) {
			for (int i=0; i < 1000000; i++) {
				
				if (!flag && i % 10 == 9) {
					/*
					 * garbage collection
					 */
					System.gc();
					
					if (flag) log.debug("#################################  garbage collection  ###################################\n");
				}
				
				clientModule();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (args.length < 2) {
			args = new String[] { "TEST-2", "client" };
		}

		if (flag) test01(args);
	}
}
