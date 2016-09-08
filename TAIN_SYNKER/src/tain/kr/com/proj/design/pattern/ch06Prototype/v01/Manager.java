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
package tain.kr.com.proj.design.pattern.ch06Prototype.v01;

import java.util.Hashtable;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Manager.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch06Prototype.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 8. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Manager {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Hashtable<String, Product> showCase;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Manager() {
		this.showCase = new Hashtable<String, Product>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void register(String name, Product product) {
		this.showCase.put(name, product);
	}
	
	public Product create(String productName) {
		Product product = (Product) this.showCase.get(productName);
		return product.createClone();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
