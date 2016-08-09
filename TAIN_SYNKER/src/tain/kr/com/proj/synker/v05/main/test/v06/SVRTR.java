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

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SVRTR.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SVRTR extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SVRTR.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private PipedStream ps = null;
	
	public SVRTR(PipedStream ps) {
		
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
			 * use class
			 * elements class, constructor, run method
			 */
			ThreadInvoke.execute(ps, "tain.kr.com.proj.synker.v05.main.test.v06.SVRTR");
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
