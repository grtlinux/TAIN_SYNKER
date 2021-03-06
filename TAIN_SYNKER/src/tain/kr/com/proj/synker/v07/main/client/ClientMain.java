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
package tain.kr.com.proj.synker.v07.main.client;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v07.base.common.GlobalParam;
import tain.kr.com.proj.synker.v07.base.common.GlobalVars;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ClientMain.java
 *   -. Package    : tain.kr.com.proj.synker.v06.main.test.v02
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
			/*
			 * test for loop
			 */
			String[] trList = GlobalParam.getInstance().getTrList();
			
			if (trList != null) {
				for (String trCode : trList) {
					log.debug(">>>>> TRCODE = " + trCode);
				}
			}
		}
		
//		if (flag) {
//			
//			Socket socket = null;
//			SocketStream ss = null;
//			PipedStream ps = null;
//			
//			Thread thr = null;
//			
//			String req = null;
//			String res = null;
//			
//			try {
//				
//				socket = new Socket("127.0.0.1", 12345);
//				if (flag) log.info(String.format(" CLIENT : connection by port '12345' [%s]", socket.toString()));
//				
//				ss = new SocketStream(socket);
//				ps = new PipedStream();
//				
//				if (flag) {
//					/*
//					 * TrMap to set global vars
//					 */
//					TrBean bean = TrMap.getInstance().getBean(args[2]);   // TODO 2016.08.12
//					
//					GlobalVars.getInstance().setTrCode(bean.getTrName());
//					GlobalVars.getInstance().setCliTrClass(bean.getTrCliClass());
//					GlobalVars.getInstance().setSvrTrClass(bean.getTrSvrClass());
//				}
//				
//				if (flag) {
//					/*
//					 * use class
//					 * elements class, constructor, run method
//					 */
//					// thr = ThreadInvoke.execute(ps, "tain.kr.com.proj.synker.v06.main.test.v06.CLITR");
//					thr = ThreadInvoke.execute(ps, GlobalVars.getInstance().getCliTrClass());
//				}
//				
//				if (flag) {
//					/*
//					 * read req
//					 */
//					
//					req = ps.reqRead();
//				}
//				
//				if (flag) {
//					/*
//					 * write req to socket
//					 */
//					
//					ss.setHeader("REQ", GlobalVars.getInstance().getTrCode());
//
//					ss.write(req);
//				}
//
//				if (flag) {
//					/*
//					 * read res from socket
//					 */
//					
//					res = ss.read();
//				}
//				
//				if (flag) {
//					/*
//					 * write res
//					 */
//					
//					ps.resWrite(res);
//				}
//				
//			} catch (Exception e) {
//				// e.printStackTrace();
//				throw e;
//			} finally {
//				ss.close();
//			}
//			
//			thr.join();
//			
//			ps.close();
//		}
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
			 * set the GlobalVars from VersionMain.properties
			 */
			GlobalVars.getInstance().setProperties(GlobalParam.getInstance().getMainService());
			GlobalVars.getInstance().print(); 
		}

		if (flag) clientModule();
	}

	private static void test02(String[] args) throws Exception {
		
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
			 * set the GlobalVars from VersionMain.properties
			 */
			GlobalVars.getInstance().setProperties(GlobalParam.getInstance().getMainService());
			GlobalVars.getInstance().print(); 
		}

		if (flag) {
			for (int i=0; i < 10000; i++) {
				
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
		
		if (args.length == 0) {
			args = new String[] { "TEST-2" };

			//GlobalParam.getInstance(1);  // version
			//GlobalParam.getInstance(2);  // server
			GlobalParam.getInstance(3);  // client
			//GlobalParam.getInstance(4);  // trlist
			//GlobalParam.getInstance(5);  // svclist
			//GlobalParam.getInstance(6);  // syslist
			GlobalParam.getInstance();
		}

		if (flag) test01(args);
		if (!flag) test02(args);
	}
}
