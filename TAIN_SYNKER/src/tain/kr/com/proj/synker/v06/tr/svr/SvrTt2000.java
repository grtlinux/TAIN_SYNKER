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

import java.util.Date;

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
public class SvrTt2000 extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SvrTt2000.class);

	private PipedStream ps = null;
	
	public SvrTt2000(PipedStream ps) {
		
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
					
					res = String.format("%s|%d|%s|%s", req, lVal, strVal, GlobalVars.getInstance().getTrCode());
					
					if (flag) log.debug("@@@@@ REQ [" + req + "] >>>>> RES [" + res + "]");
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
