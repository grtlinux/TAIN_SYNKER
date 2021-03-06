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
package tain.kr.com.proj.design.pattern.ch07Builder.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Director.java
 *   -. Package    : tain.kr.com.proj.design.pattern.ch07Builder.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 11. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Director {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Builder builder;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Object construct() {
		
		this.builder.makeTitle("Greeting");
		
		this.builder.makeString("��ħ�� ����");
		
		this.builder.makeItems(new String[] {
				"���� ��ħ�Դϴ�.",
				"�ȳ��ϼ���.",
		});
		
		this.builder.makeString("�㿡");
		
		this.builder.makeItems(new String[] {
				"�ȳ��ϼ���.",
				"�ȳ��� �ֹ�����.",
				"�ȳ��� �輼��.",
		});
		
		return this.builder.getResult();
	}
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
