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
package tain.kr.com.proj.synker.v03.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v03.util.SynkerProperties;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SynkerClient.java
 *   -. Package    : tain.kr.com.proj.synker.v02.client
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SynkerClient {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SynkerClient.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String KEY_CONNECT_HOST = "tain.kr.synker.client.connect.host";
	private static final String KEY_CONNECT_PORT = "tain.kr.synker.client.connect.port";
	
	private String strHost = null;
	private String strPort = null;

	private Socket socket = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;

	private SynkerClient() throws Exception {
		
		if (flag) {
			this.strHost = SynkerProperties.getInstance().get(KEY_CONNECT_HOST);
			this.strPort = SynkerProperties.getInstance().get(KEY_CONNECT_PORT);
		}
		
		if (flag) {
			log.debug("CONNECT INFO = [" + this.strHost + ", " + this.strPort + "]");
		}
	}
	
	public void execute01() throws Exception {
		
		if (flag) {
			/*
			 * hired parameter
			 */
			this.socket = new Socket(this.strHost, Integer.parseInt(this.strPort));
			this.dis = new DataInputStream(this.socket.getInputStream());
			this.dos = new DataOutputStream(this.socket.getOutputStream());
		}

		if (flag) {
			try {
				/*
				 * 
				 */
				
				
				
				
				
				
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (this.dis != null) try { this.dis.close(); } catch (Exception e) {}
				if (this.dos != null) try { this.dos.close(); } catch (Exception e) {}
				if (this.socket != null) try { this.socket.close(); } catch (Exception e) {}
			}
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

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static SynkerClient instance = null;
	
	public static synchronized SynkerClient getInstance() throws Exception {
		
		if (instance == null) {
			instance = new SynkerClient();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}
