package com.ihg.brandstandards.db.service.persistence;

import java.util.List;

import com.ihg.brandstandards.db.model.Image;
import com.ihg.brandstandards.db.model.impl.ImageImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Search Image Table.
 * 
 * @author SengarA
 * 
 */

public class ImageFinderImpl extends BasePersistenceImpl<Image> implements ImageFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(ImageFinderImpl.class);

    public List<Image> findByimageDescAndTitle(String imageDesc, String imageTitle) throws SystemException
    {
        List<Image> images = null;
        Session session = openSession();
        StringBuilder query = new StringBuilder();
        try
        {
            query.append("SELECT * ");
            query.append(" FROM Image img ");
            query.append(" WHERE  img.image_desc like ?  or img.image_title_txt like ? ");
            SQLQuery q = session.createSQLQuery(query.toString());
            q.addEntity("Image", ImageImpl.class);

            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(imageDesc);
            qPos.add(imageTitle);

            images = (List<Image>) q.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return images;
    }
}
