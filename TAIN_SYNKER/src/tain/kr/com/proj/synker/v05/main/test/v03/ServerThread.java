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
package tain.kr.com.proj.synker.v05.main.test.v03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v05.common.PacketHeader;

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
	
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public ServerThread(int idxThr, Socket socket) throws Exception {
		
		super(String.format("SERVER_THREAD_%010d", idxThr));
		
		if (flag) {
			this.idxThr = idxThr;
			this.socket = socket;
			this.dis = new DataInputStream(this.socket.getInputStream());
			this.dos = new DataOutputStream(this.socket.getOutputStream());
			
			if (flag) log.debug(String.format("########## START <%s> ########## socket=%s ", this.getName(), this.socket.toString()));
		}
	}
	
	public void run() {
		
		if (flag) {
			/*
			 * 2nd transaction logic
			 */
			try {
				
				byte[] header = null;

				if (flag) {
					/*
					 * 1. recv header
					 */
					
					header = recv(PacketHeader.getLength());
					if (flag) log.debug(String.format("<- 1. REQ RECV HEADER [%s]", new String(header)));
				}
				
				if (flag) {
					/*
					 * process for the request and then make a result for response
					 */
					String trCode = PacketHeader.TR_CODE.getString(header);
					if (flag) log.debug("> TR_CODE = " + trCode);

				}
				
				if (flag) {
					/*
					 * finish
					 */
					long msec = 1000;
					if (flag) log.debug("sleeping msec = " + msec);
					try { Thread.sleep(msec); } catch (InterruptedException e) {}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (this.dis != null) try { this.dis.close(); } catch (Exception e) {}
				if (this.dos != null) try { this.dos.close(); } catch (Exception e) {}
				if (this.socket != null) try { this.socket.close(); } catch (Exception e) {}
			}
		}
		
		if (flag) {
			if (flag) log.debug(String.format("########## FINISH <%s> ##########\n\n", this.getName()));
		}
	}

	private byte[] recv(final int size) throws Exception {
		
		int ret = 0;
		int readed = 0;
		byte[] buf = new byte[size];
		
		this.socket.setSoTimeout(0);
		while (readed < size) {
			ret = this.dis.read(buf, readed, size - readed);
			if (!flag) log.debug("    size:" + size + "    readed:" + readed + "     ret:" + ret);
			
			if (ret <= 0) {
				try { Thread.sleep(1000); } catch (Exception e) {}
				continue;
			} else {
				if (flag) this.socket.setSoTimeout(1000);
			}
			
			readed += ret;
		}
		
		return buf;
	}
}
