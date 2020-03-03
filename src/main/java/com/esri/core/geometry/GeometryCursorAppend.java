/*
 Copyright 1995-2015 Esri

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 For additional information, contact:
 Environmental Systems Research Institute, Inc.
 Attn: Contracts Dept
 380 New York Street
 Redlands, California, USA 92373

 email: contracts@esri.com
 */
package com.esri.core.geometry;

public class GeometryCursorAppend extends GeometryCursor {
	private GeometryCursor m_next;

	public GeometryCursorAppend(GeometryCursor cur1, GeometryCursor cur2) {
		m_inputGeoms = cur1;
		m_next = cur2;
	}

	@Override
	public boolean hasNext() {
		return m_inputGeoms.hasNext() || m_next.hasNext();
	}

	@Override
	public Geometry next() {
		if (!m_inputGeoms.hasNext() && m_next.hasNext()) {
			m_inputGeoms = m_next;
		}
		return m_inputGeoms.next();
	}
}
