/*-----------------------------------------------------------------------------
 *
 * Title:   SmsAplicationException.java
 * Version: 1.0 May 1, 2006
 * Copyright:  (c) 2006 Delta Dental.  All rights reserved.
 * Author:  ltripp
 * Company: Delta Dental Plan of Michigan
 * 
 * History:
 * 
 *-----------------------------------------------------------------------------*/
package roosevelt.libraries.auth.util;

public class SmsApplicationException extends ApplicationException
{

    public SmsApplicationException(String message)
    {
        super(message);
        //LogFactory.getLog(SmsApplicationException.class).error(message, this);

    }

    public SmsApplicationException(Exception e)
    {
        super(e);
        //LogFactory.getLog(SmsApplicationException.class).error(getMessage(), this);
    }

    public SmsApplicationException(String message, Exception e)
    {
        super(message, e);
        //LogFactory.getLog(SmsApplicationException.class).error(message, this);
    }

}
