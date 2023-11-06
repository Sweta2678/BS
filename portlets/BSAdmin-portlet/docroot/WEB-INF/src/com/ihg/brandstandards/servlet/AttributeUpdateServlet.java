package com.ihg.brandstandards.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihg.brandstandards.scheduler.AttributeUpdateSchedular;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author AkhaniC
 *
 */
public class AttributeUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LOG.info("Attribute update process start time :"+new Date(System.currentTimeMillis()));
		AttributeUpdateSchedular.receive();
		LOG.info("Attribute update process end time :"+new Date(System.currentTimeMillis()));
	}
	
	private static final Log LOG = LogFactoryUtil.getLog(AttributeUpdateServlet.class);

}
