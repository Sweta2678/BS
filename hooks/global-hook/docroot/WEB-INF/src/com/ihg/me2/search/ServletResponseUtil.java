package com.ihg.me2.search;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ContentTypes;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


public class ServletResponseUtil
{
	public static void sendError(HttpServletResponse response, int httpStatusCode, String errorMessage) throws IOException
	{
		response.setStatus(httpStatusCode);
		
		JSONObject error = JSONFactoryUtil.createJSONObject();
		error.put("errorMessage", errorMessage);
		
		writeJSON(response, error);
	}
	
	public static void writeJSON(HttpServletResponse response, Object json)
		throws IOException
	{
		response.setContentType(ContentTypes.APPLICATION_JSON);
		response.getWriter().write(json.toString());
		response.flushBuffer();
	}

}
