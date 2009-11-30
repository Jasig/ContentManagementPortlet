/*
Licensed to Jasig under one or more contributor license
agreements. See the NOTICE file distributed with this work
for additional information regarding copyright ownership.
Jasig licenses this file to you under the Apache License,
Version 2.0 (the "License"); you may not use this file
except in compliance with the License. You may obtain a
copy of the License at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on
an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied. See the License for the
specific language governing permissions and limitations
under the License.
 **/

package org.jasig.portlet.cms.controller;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

public final class PortletPreferencesWrapper {
	private PortletPreferences prefences = null;
	private PortletRequest portletRequest = null;

	private static final String DEFAULTREPOSITORYROOTNAME = "root";

	public PortletPreferencesWrapper(final PortletRequest request) {
		portletRequest = request;
		prefences = portletRequest.getPreferences();
	}

	public String getPortletRepositoryRoot() {
		String result = prefences.getValue("repository.root",
		        PortletPreferencesWrapper.DEFAULTREPOSITORYROOTNAME);
		if (result == null || result.trim().length() <= 0)
			result = PortletPreferencesWrapper.DEFAULTREPOSITORYROOTNAME;
		return result;
	}

	public String getPortletUserName() {
		return portletRequest.getUserPrincipal().getName();
	}
}
