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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SocketStream.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SocketStream {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SocketStream.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unused")
	private static final int BUF_SIZ = 1024;
	
	private Socket socket = null;
	
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	private String strHeader = null;
	private byte[] bytHeader = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public SocketStream(Socket socket) throws Exception {
		
		if (flag) {
			this.socket = socket;
			
			if (this.socket == null) {
				throw new Exception("ERROR : socket value is null...");
			}
			
			this.dis = new DataInputStream(this.socket.getInputStream());
			this.dos = new DataOutputStream(this.socket.getOutputStream());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public int setHeader(String header) throws Exception {
		
		int ret = -1;
		
		if (flag) {
			this.strHeader = header;
			this.bytHeader = this.strHeader.getBytes();
			
			ret = this.bytHeader.length;
		}
		
		return ret ;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public int write(byte[] buffer) throws Exception {
		
		int ret = -1;
		
		if (flag) {
			/*
			 * write header
			 */
			if (this.strHeader == null) {
				throw new Exception("ERROR : there is no value of header...");
			}
			
			ret = this.bytHeader.length;

			this.dos.write(this.bytHeader, 0, ret);

			
			if (flag) log.debug("WRITE HEADER (" + ret + ") [" + this.strHeader + "]");
		}
		
		if (flag) {
			/*
			 * write data
			 */
			this.dos.write(buffer, 0, buffer.length);
			
			ret = buffer.length;
			
			if (flag) log.debug("WRITE (" + ret + ") [" + new String(buffer) + "]");
		}
		
		return ret;
	}
	
	public int read(byte[] buffer) throws Exception {
		
		int ret = -1;
		
		if (flag) {
			/*
			 * read header
			 */
			byte[] header = new byte[20];
			
			ret = this.dis.read(header);

			if (flag) log.debug("READ HEADER  (" + ret + ") [" + new String(header) + "]");
		}
		
		if (flag) {
			/*
			 * read data
			 */
			ret = this.dis.read(buffer);

			if (flag) log.debug("READ  (" + ret + ") [" + new String(buffer, 0, ret) + "]");
		}

		return ret;
	}
	
	public void close() throws Exception {
		
		if (flag) {
			if (dis != null) try { dis.close(); } catch (Exception e) {}
			if (dos != null) try { dos.close(); } catch (Exception e) {}
			if (socket != null) try { socket.close(); } catch (Exception e) {}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
