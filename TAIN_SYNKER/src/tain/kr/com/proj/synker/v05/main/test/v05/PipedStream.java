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
package tain.kr.com.proj.synker.v05.main.test.v05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : PipedStream.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v05
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class PipedStream {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(PipedStream.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final int PIPE_SIZ = 4096;
	private static final int BUF_SIZ = 1024;
	
	/*
	 * REQ data input
	 */
	private PipedInputStream inPis = null;
	private PipedOutputStream inPos = null;
	
	private DataInputStream inDis = null;
	private DataOutputStream inDos = null;

	/*
	 * RES data output
	 */
	private PipedInputStream outPis = null;
	private PipedOutputStream outPos = null;

	private DataInputStream outDis = null;
	private DataOutputStream outDos = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * Pipe flow logic
	 * 
	 *     1. (P) inPos:inDos:reqWrite
	 *                                     2. (C) inPis:inDis:reqRead
	 *                                                                   3. Job Process:GetDateTime
	 *                                     4. (C) outPos:outDos:resWrite
	 *     5. (P) outPis:outDis:resRead
	 * 
	 */
	public PipedStream() throws Exception {
		
		if (flag) {
			/*
			 * piped stream PIPE_SIZ = default
			 */
			
			try {
				// IN : (P)inPos:dos -> (C) inPis:dis
				this.inPis = new PipedInputStream();
				this.inPos = new PipedOutputStream(this.inPis);
				
				// OUT : (C)outPos:dos -> (P)outPis:dis
				this.outPis = new PipedInputStream();
				this.outPos = new PipedOutputStream(this.outPis);
			} catch (Exception e) {
				throw e;
			}
		}
		
		if (!flag) {
			/*
			 * piped stream PIPE_SIZ = 4096
			 */
			
			try {
				// IN : (P)inPos:dos -> (C) inPis:dis
				this.inPis = new PipedInputStream(PIPE_SIZ);
				this.inPos = new PipedOutputStream(this.inPis);
				
				// OUT : (C)outPos:dos -> (P)outPis:dis
				this.outPis = new PipedInputStream(PIPE_SIZ);
				this.outPos = new PipedOutputStream(this.outPis);
			} catch (Exception e) {
				throw e;
			}
		}
		
		if (flag) {
			/*
			 * data stream
			 */

			try {
				// IN : (P)inPos:dos -> (C) inPis:dis
				this.inDis = new DataInputStream(this.inPis);
				this.inDos = new DataOutputStream(this.inPos);
				
				// OUT : (C)outPos:dos -> (P)outPis:dis
				this.outDis = new DataInputStream(this.outPis);
				this.outDos = new DataOutputStream(this.outPos);
			} catch (Exception e) {
				throw e;
			}
		}
	}

	public void close() throws Exception {
		
		if (flag) {
			if (this.inDis != null) try { this.inDis.close(); } catch (Exception e) {}
			if (this.inDos != null) try { this.inDos.close(); } catch (Exception e) {}

			if (this.outDis != null) try { this.outDis.close(); } catch (Exception e) {}
			if (this.outDos != null) try { this.outDos.close(); } catch (Exception e) {}
		}
		
		if (flag) {
			if (this.inPis != null) try { this.inPis.close(); } catch (Exception e) {}
			if (this.inPos != null) try { this.inPos.close(); } catch (Exception e) {}

			if (this.outPis != null) try { this.outPis.close(); } catch (Exception e) {}
			if (this.outPos != null) try { this.outPos.close(); } catch (Exception e) {}
		}
	}
	
	public int reqWrite(String str) throws Exception {
	
		int wcnt = -1;
		
		if (flag) {
			
			if (!flag) log.debug("(1) Before Req Write : data = [" + str + "]");
			
			byte[] buf = str.getBytes();
			wcnt = buf.length;
			
			this.inDos.write(buf, 0, wcnt);

			if (flag) log.debug("(1) After  Req Write : wcnt = " + wcnt);
		}
		
		return wcnt;
	}
	
	public String reqRead() throws Exception {
		
		String str = null;
		
		if (flag) {

			if (!flag) log.debug("(2) Before Req Read :");

			byte[] buf = new byte[BUF_SIZ];
			
			int rcnt = this.inDis.read(buf);
			if (rcnt < 0)
				return null;
			
			str = new String(buf, 0, rcnt);

			if (flag) log.debug("(2) After  Req Read : rcnt = " + rcnt + " data = [" + str + "]");
		}
		
		return str;
	}
	
	public int resWrite(String str) throws Exception {
		
		int wcnt = -1;
		
		if (flag) {

			if (!flag) log.debug("(3) Before Res Write : data = [" + str + "]");
			
			byte[] buf = str.getBytes();
			wcnt = buf.length;
			
			this.outDos.write(buf, 0, wcnt);

			if (flag) log.debug("(3) After  Res Write : wcnt = " + wcnt);
		}
		
		return wcnt;
	}
	
	public String resRead() throws Exception {
		
		String str = null;
		
		if (flag) {
			
			if (!flag) log.debug("(4) Before Res Read :");

			byte[] buf = new byte[BUF_SIZ];
			
			int rcnt = this.outDis.read(buf);
			if (rcnt < 0)
				return null;
			
			str = new String(buf, 0, rcnt);

			if (flag) log.debug("(4) After  Res Read : rcnt = " + rcnt + " data = [" + str + "]");
		}
		
		return str;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		PipedStream ps = null;
		Thread thr = null;
		
		if (flag) {
			/*
			 * create piped stream object
			 */
			ps = new PipedStream();
		}
		
		if (flag) {
			/*
			 * child thread, job thread
			 */
			thr = new JobThread(ps);
			
			thr.start();
		}

		if (flag) {
			/*
			 * parent thread, main thread
			 */
			
			String req = "GET_DATE_TIME";
			String res = null;
			
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
		}
		
		if (flag) {
			/*
			 * close piped stream object
			 */
			thr.join();
			ps.close();
		}
	}

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}

/**
 * 
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : PipedStream.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v05
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
class JobThread extends Thread {
	
	private static boolean flag = true;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private PipedStream ps = null;
	
	public JobThread(PipedStream ps) {
		
		if (flag) {
			this.ps = ps;
		}
	}
	
	public void run() {
		
		String req = null;
		String res = null;
		
		try {
			
			if (flag) {
				/*
				 * ReqRead
				 */
				
				req = ps.reqRead();
			}
			
			if (flag) {
				/*
				 * JobProcess
				 */
				Date date = new Date();
		
				long lVal = date.getTime();
				String strVal = date.toString();
				
				res = String.format("%s|%d|%s", req, lVal, strVal);
			}
			
			if (flag) {
				/*
				 * ResWrite
				 */
				ps.resWrite(res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

