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
package tain.kr.runjar.v03;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : RsrcURLConnection.java
 *   -. Package    : tain.kr.com.test.runJar.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 4. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class RsrcURLConnection extends URLConnection {

	private static boolean flag = true;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private ClassLoader classLoader = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public RsrcURLConnection(URL url, ClassLoader classLoader) {
		super(url);
		this.classLoader = classLoader;
	}
	
	public void connect() throws IOException {
		
	}
	
	public InputStream getInputStream() throws IOException {
		String file = URLDecoder.decode(url.getFile(), JIJConstants.UTF8_ENCODING);
		if (!flag) System.out.println("URL : " + file);
		
		InputStream is = classLoader.getResourceAsStream(file);
		if (is == null) {
			throw new MalformedURLException("Could not open InputStreasm for URL '" + url + "'");
		}
		
		return is;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////

}
