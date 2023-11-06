
package com.ihg.grs.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Utility class of PaginationUtil.
 */
public final class PaginationUtil
{

	public static final String END_INDEX = "end";
	public static final String START_INDEX = "start";
	public static final String CURR_PAGE = "pageno";
	public static final String TOTAL_PAGE = "totalPage";

	private static final Log LOGGER = LogFactoryUtil.getLog(PaginationUtil.class);

	/**
	 * Define a private constructor.
	 */
	private PaginationUtil()
	{
	}

	/**
	 * @param request
	 *            of HttpServletRequest
	 * @param total
	 *            number of pages
	 * @param perPageCount
	 *            number of page per count
	 */
	public static void paginate(HttpServletRequest request, int total, int perPageCount)
	{
		int currentPage = ParamUtil.get(request, CURR_PAGE, 1);
		int start = 0;
		int end = 0;
		int totalPage = 0;

		start = currentPage * perPageCount - perPageCount;
		end = start + perPageCount;

		if (perPageCount > 0)
		{
			totalPage = (total / perPageCount);
			if (total % perPageCount != 0)
			{
				totalPage++;
			}
		}

		request.setAttribute(START_INDEX, start);
		request.setAttribute(END_INDEX, end);
		request.setAttribute(CURR_PAGE, currentPage);
		request.setAttribute(TOTAL_PAGE, totalPage);

		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug(String.format("Start=%d, End=%d, Per-page count=%d, Total Page=%d, Current Page=%d", start, end, perPageCount, totalPage, currentPage));
		}

	}

	/**
	 * @param request
	 *            of HttpServletRequest
	 * @param perPageCount
	 *            number of page per count
	 */
	public static void paginate(HttpServletRequest request,  int perPageCount)
	{
		int currentPage = ParamUtil.get(request, CURR_PAGE, 1);
		int start = 0;
		int end = 0;

		start = currentPage * perPageCount - perPageCount;
		end = start + perPageCount;

		
		request.setAttribute(START_INDEX, start);
		request.setAttribute(END_INDEX, end);

		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug(String.format("Start=%d, End=%d, Per-page count=%d,  Current Page=%d", start, end, perPageCount,  currentPage));
		}

	}
	
	/**
	 * @param request
	 *            portletRequest
	 * @param total
	 *            number of page
	 * @param perPageCount
	 *            perPageCount
	 */
	public static void paginate(PortletRequest request, int total, int perPageCount)
	{
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		paginate(httpRequest, total, perPageCount);

	}

	/**
	 * @param url
	 *            page url
	 * @param value
	 *            object valu
	 * @return currPage
	 */
	public static String addCurrentPageParam(String url, Object value)
	{
		String isURL = HttpUtil.removeParameter(url, CURR_PAGE);
		return HttpUtil.addParameter(isURL, CURR_PAGE, String.valueOf(value));
	}

}
