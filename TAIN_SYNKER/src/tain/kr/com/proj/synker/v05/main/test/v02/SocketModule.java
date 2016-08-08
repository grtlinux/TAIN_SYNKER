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
package tain.kr.com.proj.synker.v05.main.test.v02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SocketModule.java
 *   -. Package    : tain.kr.com.proj.synker.v05.main.test.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SocketModule {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SocketModule.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unused")
	private static final int BUF_SIZ = 1024;
	
	private Socket socket = null;
	
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public SocketModule(Socket socket) throws Exception {
		
		if (flag) {
			this.socket = socket;
			
			if (this.socket == null) {
				throw new Exception("ERROR : socket value is null...");
			}
			
			this.dis = new DataInputStream(this.socket.getInputStream());
			this.dos = new DataOutputStream(this.socket.getOutputStream());
		}
	}
	
	public int write(byte[] buffer) throws Exception {
		
		int ret = -1;
		
		if (flag) {
			this.dos.write(buffer, 0, buffer.length);
			
			ret = buffer.length;
		}
		
		if (flag) log.debug("WRITE (" + ret + ") [" + new String(buffer) + "]");
		
		return ret;
	}
	
	public int read(byte[] buffer) throws Exception {
		
		int ret = -1;
		
		if (flag) {
			ret = this.dis.read(buffer);
		}
		
		if (flag) log.debug("READ  (" + ret + ") [" + new String(buffer) + "]");

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
