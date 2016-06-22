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
package tain.kr.com.proj.synker.v03.main;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import tain.kr.com.proj.synker.v03.bean.InfoBean;
import tain.kr.com.proj.synker.v03.common.Version;
import tain.kr.com.proj.synker.v03.util.SynkerProperties;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ClientMain.java
 *   -. Package    : tain.kr.com.proj.synker.v01.main
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 6. 22. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ClientMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ClientMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final String KEY_DESC = "tain.kr.main.desc";
	
	private String desc = null;
	
	public ClientMain() throws Exception {
		
		if (flag) {
			String clsName = this.getClass().getName();
			
			ResourceBundle rb = ResourceBundle.getBundle(clsName.replace('.', '/'));
			
			this.desc = rb.getString(KEY_DESC);
		}
	}
	
	public String getDesc() throws Exception {
		return this.desc;
	}
	
	public void print() throws Exception {
		if (flag) {
			log.info("desc    > " + this.desc);
		}
	}
	
	public int execute(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * print version
			 */
			Version.getInstance().print();
		}

		if (flag) {
			/*
			 * print arguments
			 */
			for (String arg : args) {
				log.debug("ARGS [" + arg + "]");
			}
		}
		
		if (flag) {
			/*
			 * print Synker.properties
			 */
			List<InfoBean> lstInfoBean = SynkerProperties.getInstance().getListInfoBean();
			
			if (flag) {
				/*
				 * print list of InfoBean
				 */
				
				for (InfoBean bean : lstInfoBean) {
					bean.print();
				}
			}
		}

		return 0;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (!flag) {
			/*
			 * old version before 2016.06.22
			 */
			new ClientMain().print();
			Version.getInstance().print();
		}

		if (flag) {
			new ClientMain().execute(new String[] { "FileSynker" });
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
