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
package tain.kr.com.proj.synker.v07.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DateTime.java
 *   -. Package    : tain.kr.com.proj.pos51.v02.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 3. 22. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class DateTime {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(DateTime.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * Code Templates > Comments > Constructors
	 *
	 * <PRE>
	 *   -. ClassName  : DateTime
	 *   -. MethodName : DateTime
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 6. 2. {time}
	 * </PRE>
	 *
	 * @throws Exception
	 */
	private DateTime() throws Exception {
		if (flag) {}
	}
	
	/**
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : DateTime
	 *   -. MethodName : get
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 6. 2. {time}
	 * </PRE>
	 *
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public String get(String format) throws Exception {
		String ret = null;
		
		if (flag) {
			ret = new SimpleDateFormat(format, Locale.KOREA).format(new Date());
		}
		
		return ret;
	}

	public String getYYYYMMDD() throws Exception {
		return get("yyyyMMdd");
	}
	
	public String getYYYYMMDDHHMMSS() throws Exception {
		return get("yyyyMMddHHmmss");
	}
	
	/**
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : DateTime
	 *   -. MethodName : get
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 6. 2. {time}
	 * </PRE>
	 *
	 * @param format
	 * @param ldate
	 * @return
	 * @throws Exception
	 */
	public String get(String format, long ldate) throws Exception {
		String ret = null;
		
		if (flag) {
			ret = new SimpleDateFormat(format, Locale.KOREA).format(new Date(ldate));
		}
		
		return ret;
	}
	
	public String getYYYYMMDD(long ldate) throws Exception {
		return get("yyyyMMdd", ldate);
	}
	
	public String getYYYYMMDDHHMMSS(long ldate) throws Exception {
		return get("yyyyMMddHHmmss", ldate);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static DateTime instance = null;
	
	public static synchronized DateTime getInstance() throws Exception {
		
		if (instance == null) {
			instance = new DateTime();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			long ldate = 1462785187521L;  // <- 2016/05/09 18:13:07
			
			log.debug("[" + new Date().getTime() + "] <- today");
			
			log.debug("[" + DateTime.getInstance().getYYYYMMDD() + "]");
			log.debug("[" + DateTime.getInstance().getYYYYMMDDHHMMSS() + "]");
			log.debug("[" + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss") + "]");
			
			log.debug("[" + DateTime.getInstance().getYYYYMMDD(ldate) + "]");
			log.debug("[" + DateTime.getInstance().getYYYYMMDDHHMMSS(ldate) + "]");
			log.debug("[" + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", ldate) + "]");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
