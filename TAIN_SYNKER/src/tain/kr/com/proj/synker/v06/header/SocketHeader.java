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
package tain.kr.com.proj.synker.v06.header;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SocketHeader.java
 *   -. Package    : tain.kr.com.proj.synker.v06.main.test.v06
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 10. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public enum SocketHeader {

	// type, lead, off, len, name, desc, defVal
	
	TR_LEN            ('N', '0',   0,   4, "TR_LEN"        , "TR 길이"         , "0100"           ),
	TR_TYPE           ('C', ' ',   4,   3, "TR_TYPE"       , "TR_타입"         , "REQ"            ),
	TR_CODE           ('C', ' ',   7,   6, "TR_CODE"       , "TR 코드"         , "TR0000"         ),
	TR_DATE           ('C', '0',  13,   8, "TR_DATE"       , "TR 발생일자"     , "YYYYMMDD"       ),
	TR_TIME           ('C', '0',  21,   6, "TR_TIME"       , "TR 발생시간"     , "HHMMSS"         ),
	TR_USER           ('C', ' ',  27,  10, "TR_USER"       , "TR 사용자"       , "USER"           ),
	TR_PASS           ('C', ' ',  37,  10, "TR_PASS"       , "TR 비밀번호"     , "PASS"           ),
	KEY_CODE          ('C', ' ',  47,  10, "KEY_CODE"      , "키코드"          , "0000000000"     ),
	BODY_LEN          ('N', '0',  57,   4, "BODY_LEN"      , "BODY 길이"       , "0000"           ),
	RET_CODE          ('C', ' ',  61,   5, "RET_CODE"      , "리턴코드"        , ""               ),
	RET_MSG           ('C', ' ',  66,  34, "RET_MSG"       , "리턴메시지"      , ""               ),
	;
	
	private final char type;
	private final char lead;
	private final int off;
	private final int len;
	private final String name;
	private final String desc;
	private final String defVal; 
	
	public char getType() {
		return this.type;
	}
	
	public char getLead() {
		return this.lead;
	}
	
	public int getOff() {
		return this.off;
	}
	
	public int getLen() {
		return this.len;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getDefVal() {
		return this.defVal;
	}

	/*
	 * 
	 */
	SocketHeader(char type, char lead, int off, int len, String name, String desc, String defVal) {
		this.type = type;
		this.lead = lead;
		this.off = off;
		this.len = len;
		this.name = name;
		this.desc = desc;
		this.defVal = defVal;
	}

	public void fill(byte[] bytes, byte by) {
		
		for (int i=0; i < this.len; i++) {
			bytes[this.off + i] = by;
		}
	}

	public void setVal(byte[] bytes) {
		if (flag) {
			for (int i=0; i < this.len; i++) {
				bytes[this.off + i] = (byte) ' ';
			}
		}
	}
	
	public void setVal(byte[] bytes, String stVal) {
		
		if (stVal == null) {
			setVal(bytes);
			return;
		}

		try {
			setVal(bytes, stVal.getBytes("EUC-KR"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setVal(byte[] bytes, byte[] byVal) {
		
		if (byVal == null) {
			setVal(bytes);
			return;
		}
		
		int byLen = byVal.length;
		
		if (this.type == 'C') {
			// left arrange
			
			for (int i=0, j=0; i < this.len; i++, j++) {
				if (j < byLen) {
					bytes[this.off + i] = byVal[j];
				} else {
					bytes[this.off + i] = (byte) this.lead;
				}
			}
			
		} else if (this.type == 'N') {
			// right arrange
			
			for (int i=0, j=0; i < this.len; i++, j++) {
				if (j < byLen) {
					bytes[this.off + this.len - 1 - i] = byVal[byLen - 1 - j];
				} else {
					bytes[this.off + this.len - 1 - i] = (byte) this.lead;
				}
			}
		}
	}

	public String getString(byte[] bytes) {
		return new String(bytes, this.off, this.len);
	}
	
	public byte[] getBytes(byte[] bytes) {
		byte[] ret = new byte[this.len];
		
		for (int i = 0; i < this.len; i++) {
			ret[i] = bytes[this.off + i];
		}
		
		return ret;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SocketHeader.class);

	private static int lenTotal = -1;

	private static int setLenTotal() throws Exception {
		
		if (lenTotal < 0) {

			int off = 0;

			for (SocketHeader fld : SocketHeader.values()) {
				off += fld.getLen();
			}
			
			lenTotal = off;
		}
		
		return lenTotal;
	}
	
	public static int getLength() throws Exception {
		
		return setLenTotal();
	}
	
	public static byte[] makeBytes() throws Exception {
		
		setLenTotal();
		
		byte[] bytes = new byte[lenTotal];
		
		if (!flag) {
			for (int i=0; i < lenTotal; i++) {
				bytes[i] = (byte) ' ';
			}
		}
		
		if (flag) {
			for (SocketHeader fld : SocketHeader.values()) {
				fld.setVal(bytes, fld.getDefVal());
			}
		}

		if (flag) {
			TR_LEN  .setVal(bytes, String.valueOf(lenTotal));
			TR_TYPE .setVal(bytes, "");
			TR_CODE .setVal(bytes, "");
			TR_DATE .setVal(bytes, new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(new Date()));
			TR_TIME .setVal(bytes, new SimpleDateFormat("HHmmss"  , Locale.KOREA).format(new Date()));
			TR_USER .setVal(bytes, "USERT12345");
			TR_PASS .setVal(bytes, "1Q2WER4RKD");
			KEY_CODE.setVal(bytes, "FK39SXKZZZ");
			BODY_LEN.setVal(bytes, String.valueOf(0));
			RET_CODE.setVal(bytes, "");
			RET_MSG .setVal(bytes, "");
		}

		return bytes;
	}
	
	public static byte[] setBytes(byte[] trLen, byte[] trData) throws Exception {
	
		setLenTotal();
		
		byte[] bytes = new byte[lenTotal];

		if (flag) {
			TR_LEN.setVal(bytes, trLen);
			
			for (int i=0, j=TR_LEN.getLen(); i < trData.length && j < lenTotal; i++, j++) {
				bytes[j] = trData[i];
			}
		}
		
		return bytes;
	}
	
	public static byte[] clearBytes(byte[] bytes) throws Exception {
		
		if (lenTotal < 0) setLenTotal();

		for (int i=0; i < lenTotal; i++) {
			bytes[i] = (byte) ' ';
		}
		
		return bytes;
	}
	
	public static void print() throws Exception {
		
		if (flag) {
			String name = new Object(){}.getClass().getEnclosingClass().getName();
			
			int len = 0;
			int off = 0;
			for (SocketHeader fld : SocketHeader.values()) {
				len = fld.getLen();
				
				if (flag) log.debug(String.format("[%s] [%s] [%3d:%3d] [%3d:%3d] [%-10s] [%s] [%s]"
						, name , fld.getType(), off, fld.getOff(), len, fld.getLen(), fld.getName(), fld.getDesc(), fld.getDefVal()));
				
				off += fld.getLen();
			}
			
			if (flag) log.debug("Total Length = " + off);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * USAGE 1
			 */
			
			SocketHeader.print();
		}
		
		if (flag) {
			/*
			 * USAGE 2
			 */
			
			byte[] header = SocketHeader.makeBytes();
			
			log.debug("TR_LEN   = [" + TR_LEN  .getString(header) + "]");
			log.debug("TR_TYPE  = [" + TR_TYPE .getString(header) + "]");
			log.debug("TR_CODE  = [" + TR_CODE .getString(header) + "]");
			log.debug("TR_DATE  = [" + TR_DATE .getString(header) + "]");
			log.debug("TR_TIME  = [" + TR_TIME .getString(header) + "]");
			log.debug("TR_USER  = [" + TR_USER .getString(header) + "]");
			log.debug("TR_PASS  = [" + TR_PASS .getString(header) + "]");
			log.debug("KEY_CODE = [" + KEY_CODE.getString(header) + "]");
			log.debug("BODY_LEN = [" + BODY_LEN.getString(header) + "]");
			log.debug("RET_CODE = [" + RET_CODE.getString(header) + "]");
			log.debug("RET_MSG  = [" + RET_MSG .getString(header) + "]");
			log.debug("[" + new String(header) + "]");

			/*
			 * setting value
			 */
			TR_TYPE .setVal(header, "REQ");
			TR_CODE .setVal(header, "TR0000");
			BODY_LEN.setVal(header, String.format("%04d", 1234));
			RET_CODE.setVal(header, "00000");
			RET_MSG .setVal(header, "SUCCESS");
			
			log.debug("TR_LEN   = [" + TR_LEN  .getString(header) + "]");
			log.debug("TR_TYPE  = [" + TR_TYPE .getString(header) + "]");
			log.debug("TR_CODE  = [" + TR_CODE .getString(header) + "]");
			log.debug("TR_DATE  = [" + TR_DATE .getString(header) + "]");
			log.debug("TR_TIME  = [" + TR_TIME .getString(header) + "]");
			log.debug("TR_USER  = [" + TR_USER .getString(header) + "]");
			log.debug("TR_PASS  = [" + TR_PASS .getString(header) + "]");
			log.debug("KEY_CODE = [" + KEY_CODE.getString(header) + "]");
			log.debug("BODY_LEN = [" + BODY_LEN.getString(header) + "]");
			log.debug("RET_CODE = [" + RET_CODE.getString(header) + "]");
			log.debug("RET_MSG  = [" + RET_MSG .getString(header) + "]");
			log.debug("[" + new String(header) + "]");
			
			log.debug("length of the header = " + SocketHeader.getLength());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">" + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
