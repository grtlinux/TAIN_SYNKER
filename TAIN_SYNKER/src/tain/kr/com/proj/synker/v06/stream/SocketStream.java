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
package tain.kr.com.proj.synker.v06.stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v06.header.SocketHeader;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SocketStream.java
 *   -. Package    : tain.kr.com.proj.synker.v06.main.test.v03
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
	
	//private static final int BUF_SIZ = 1024;
	
	private Socket socket = null;
	
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	private byte[] bytHeader = null;
	
	private byte[] bytBody = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public SocketStream(Socket socket) throws Exception {
		
		if (flag) {
			/*
			 * set the objects of stream
			 */
			this.socket = socket;
			
			if (this.socket == null) {
				throw new Exception("ERROR : socket value is null...");
			}
			
			this.dis = new DataInputStream(this.socket.getInputStream());
			this.dos = new DataOutputStream(this.socket.getOutputStream());
		}
		
		if (flag) {
			/*
			 * remove TIME_WAIT
			 */
			// SO_LINGER true 0
			//this.socket.setSoLinger(true, 0);   // remove TIME_WAIT but occur a event of Connection reset
			this.socket.setSoLinger(false, 0);   // because of java.net.SocketException: Connection reset
			
			// SO_REUSEADDR true
			this.socket.setReuseAddress(true);
		}

		if (flag) {
			/*
			 * make a socket header
			 */
			this.bytHeader = SocketHeader.makeBytes();
		}
	}
	
	public void close() throws Exception {
		
		if (flag) {
			/*
			 * close the io objects
			 */
			if (dis != null) try { dis.close(); dis = null; } catch (Exception e) {}
			if (dos != null) try { dos.close(); dos = null; } catch (Exception e) {}
			if (socket != null) try { socket.close(); socket = null; } catch (Exception e) {}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public int setHeader(String trType, String trCode) throws Exception {
		
		int ret = -1;
		
		if (flag) {
			/*
			 * make a socket header
			 */
			this.bytHeader = SocketHeader.makeBytes();
		}

		if (flag) {
			SocketHeader.TR_TYPE .setVal(this.bytHeader, trType);
			SocketHeader.TR_CODE .setVal(this.bytHeader, trCode);
			
			ret = this.bytHeader.length;
		}
		
		return ret ;
	}
	
	public int setHeader(String trType, String trCode, String retCode, String retMsg) throws Exception {
		
		int ret = -1;
		
		if (flag) {
			/*
			 * make a socket header
			 */
			this.bytHeader = SocketHeader.makeBytes();
		}

		if (flag) {
			SocketHeader.TR_TYPE .setVal(this.bytHeader, trType);
			SocketHeader.TR_CODE .setVal(this.bytHeader, trCode);
			
			SocketHeader.RET_CODE.setVal(this.bytHeader, retCode);
			SocketHeader.RET_MSG .setVal(this.bytHeader, retMsg );
			
			ret = this.bytHeader.length;
		}
		
		return ret ;
	}
	
	public byte[] getHeader() throws Exception {
		
		return this.bytHeader;
	}
	
	public String getTrCode() throws Exception  {
		
		return SocketHeader.TR_CODE.getString(this.bytHeader);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * write
	 */
	
	private int write() throws Exception {
		
		int ret = -1;
		
		if (flag) {
			/*
			 * write header to socket
			 */
			ret = this.bytHeader.length;
			
			this.dos.write(this.bytHeader, 0, ret);
			
			if (flag) log.debug("SOCKET WRITE HEADER (" + ret + ") [" + new String(this.bytHeader) + "]");
		}
		
		if (flag) {
			/*
			 * write data to socket
			 */
			ret = this.bytBody.length;
			
			this.dos.write(this.bytBody, 0, ret);
			
			if (flag) log.debug("SOCKET WRITE DATA   (" + ret + ") [" + new String(this.bytBody) + "]");
		}

		if (flag) {
			/*
			 * flush
			 */
			this.dos.flush();
		}
		
		return ret;
	}
	
	public void write(String str) throws Exception {
		
		if (flag) {
			/*
			 * set the length of data
			 */
			this.bytBody = str.getBytes();

			SocketHeader.BODY_LEN.setVal(this.bytHeader, String.format("%04d", this.bytBody.length));
		}
		
		if (flag) {
			/*
			 * write to ss
			 */
			write();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * read
	 */
	
	private byte[] recv(final int size) throws Exception {
		
		int ret = 0;
		int readed = 0;
		byte[] buf = new byte[size];
		
		this.socket.setSoTimeout(0);
		while (readed < size) {
			ret = this.dis.read(buf, readed, size - readed);
			if (!flag) log.debug(String.format("\t[SIZ:%d][R:%d][RET:%d]", size, readed, ret));
			
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

	private int readHeader() throws Exception {
		
		int ret = -1;
		
		if (flag) {
			/*
			 * set the length of header
			 */
			
			ret = this.bytHeader.length;
		}
		
		if (flag) {
			/*
			 * read header from socket
			 */
			this.bytHeader = recv(ret);
			
			if (flag) log.debug("SOCKET READ HEADER  (" + ret + ") [" + new String(this.bytHeader) + "]");
		}

		return ret;
	}
	
	private int readBody() throws Exception {
		
		int ret = -1;
		
		if (flag) {
			/*
			 * to get the length of data
			 */
			
			String strBodyLength = SocketHeader.BODY_LEN.getString(this.bytHeader);
			
			ret = Integer.parseInt(strBodyLength);
		}
		
		if (flag) {
			/*
			 * read body from socket
			 */
			this.bytBody = recv(ret);

			if (flag) log.debug("SOCKET READ DATA    (" + ret + ") [" + new String(this.bytBody) + "]");
		}
		
		return ret;
	}
	
	public String read() throws Exception {
		
		String str = null;
		
		if (flag) {
			/*
			 * read header
			 */
			readHeader();
		}
		
		if (flag) {
			/*
			 * read body
			 */
			readBody();
		}
		
		if (flag) {
			/*
			 * get data
			 */
			str = new String(this.bytBody);
		}
		
		return str;
	}
}
