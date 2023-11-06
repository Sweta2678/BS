package com.ihg.me2.framework.custom.security.actions;

import com.ihg.me2.framework.custom.security.cache.CacheManagerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Cache Manager
 * 
 * @author gaurang.sheladia
 */
@WebServlet("/CacheManager")
public class CacheManagerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//private static Logger LOG = Logger.getLogger(CacheManagerServlet.class);
	private static Log LOG = LogFactoryUtil.getLog(CacheManagerServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CacheManagerServlet() {
        super();
    }

	/**
	 * @throws ServletException, IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("This is the Cache Manager Servlet<br/> ");
		
		LOG.info("CacheInitServlet.init");
		Date startDate = new Date();
		
		LOG.info("Cache bean started ....");
		//CacheInitializerBean cacheBean = (CacheInitializerBean) BeanFactory.getBean("cacheInitializerBean");
		//cacheBean.initAndSave();
		CacheManagerUtil.initSecurityAttributes();
		LOG.info("Cache bean end ....");
		
		LOG.debug("CacheInitServlet.init time : " + (new Date().getTime() - startDate.getTime()));
		
	}

}
