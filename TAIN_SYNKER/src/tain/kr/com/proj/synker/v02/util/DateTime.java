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
package tain.kr.com.proj.synker.v02.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

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
	
	/**
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : DateTime
	 *   -. MethodName : getLong
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 6. 23. {time}
	 * </PRE>
	 *
	 * @return
	 * @throws Exception
	 */
	public long getLong() throws Exception {
		return new Date().getTime();
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
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			log.debug(String.format("getLong = %d", DateTime.getInstance().getLong()));
		}
	}
	
	private static void test03(String[] args) throws Exception {
		
		if (flag) {
			// get the supported ids for GMT-08:00 (Pacific Standard Time)
			String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
			// if no ids were returned, something is wrong. get out.
			if (ids.length == 0)
				System.exit(0);

			// begin output
			System.out.println("Current Time");

			// create a Pacific Standard Time time zone
			SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);

			// set up rules for daylight savings time
			pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
			pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);

			// create a GregorianCalendar with the Pacific Daylight time zone
			// and the current date and time
			Calendar calendar = new GregorianCalendar(pdt);
			Date trialTime = new Date();
			calendar.setTime(trialTime);

			// print out a bunch of interesting things
			System.out.println("ERA                  : " + calendar.get(Calendar.ERA));
			System.out.println("YEAR                 : " + calendar.get(Calendar.YEAR));
			System.out.println("MONTH                : " + calendar.get(Calendar.MONTH));
			System.out.println("WEEK_OF_YEAR         : " + calendar.get(Calendar.WEEK_OF_YEAR));
			System.out.println("WEEK_OF_MONTH        : " + calendar.get(Calendar.WEEK_OF_MONTH));
			System.out.println("DATE                 : " + calendar.get(Calendar.DATE));
			System.out.println("DAY_OF_MONTH         : " + calendar.get(Calendar.DAY_OF_MONTH));
			System.out.println("DAY_OF_YEAR          : " + calendar.get(Calendar.DAY_OF_YEAR));
			System.out.println("DAY_OF_WEEK          : " + calendar.get(Calendar.DAY_OF_WEEK));
			System.out.println("DAY_OF_WEEK_IN_MONTH : " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
			System.out.println("AM_PM                : " + calendar.get(Calendar.AM_PM));
			System.out.println("HOUR                 : " + calendar.get(Calendar.HOUR));
			System.out.println("HOUR_OF_DAY          : " + calendar.get(Calendar.HOUR_OF_DAY));
			System.out.println("MINUTE               : " + calendar.get(Calendar.MINUTE));
			System.out.println("SECOND               : " + calendar.get(Calendar.SECOND));
			System.out.println("MILLISECOND          : " + calendar.get(Calendar.MILLISECOND));
			System.out.println("ZONE_OFFSET          : " + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
			System.out.println("DST_OFFSET           : " + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000)));

			System.out.println("Current Time, with hour reset to 3");
			calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
			calendar.set(Calendar.HOUR, 3);

			System.out.println("ERA                  : " + calendar.get(Calendar.ERA));
			System.out.println("YEAR                 : " + calendar.get(Calendar.YEAR));
			System.out.println("MONTH                : " + calendar.get(Calendar.MONTH));
			System.out.println("WEEK_OF_YEAR         : " + calendar.get(Calendar.WEEK_OF_YEAR));
			System.out.println("WEEK_OF_MONTH        : " + calendar.get(Calendar.WEEK_OF_MONTH));
			System.out.println("DATE                 : " + calendar.get(Calendar.DATE));
			System.out.println("DAY_OF_MONTH         : " + calendar.get(Calendar.DAY_OF_MONTH));
			System.out.println("DAY_OF_YEAR          : " + calendar.get(Calendar.DAY_OF_YEAR));
			System.out.println("DAY_OF_WEEK          : " + calendar.get(Calendar.DAY_OF_WEEK));
			System.out.println("DAY_OF_WEEK_IN_MONTH : " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
			System.out.println("AM_PM                : " + calendar.get(Calendar.AM_PM));
			System.out.println("HOUR                 : " + calendar.get(Calendar.HOUR));
			System.out.println("HOUR_OF_DAY          : " + calendar.get(Calendar.HOUR_OF_DAY));
			System.out.println("MINUTE               : " + calendar.get(Calendar.MINUTE));
			System.out.println("SECOND               : " + calendar.get(Calendar.SECOND));
			System.out.println("MILLISECOND          : " + calendar.get(Calendar.MILLISECOND));
			System.out.println("ZONE_OFFSET          : " + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000))); // in hours
			System.out.println("DST_OFFSET           : " + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000))); // in hours
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (!flag) test01(args);
		if (flag) test02(args);
		if (flag) test03(args);
	}
}
