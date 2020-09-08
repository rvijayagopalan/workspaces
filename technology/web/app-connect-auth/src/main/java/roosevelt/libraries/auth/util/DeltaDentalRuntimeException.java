/*-----------------------------------------------------------------------------
*
* Title:   DeltaDentalRuntimeException.java
* Version: 1.0 Dec 6, 2006
* Copyright:  (c) 2006 Delta Dental.  All rights reserved.
* Author:  jbonevich
* Company: Delta Dental Plan of Michigan
* Description:  Parent class for ApplicationException and SystemException
* 
* History:
* 
*-----------------------------------------------------------------------------*/
package roosevelt.libraries.auth.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.LogFactory;

public abstract class DeltaDentalRuntimeException extends RuntimeException
{
    private final String id;

    public DeltaDentalRuntimeException(String message)
    {
        this(message, null);
    }

    public DeltaDentalRuntimeException(Throwable cause)
    {
        this(cause.getMessage(), cause);
    }

    public DeltaDentalRuntimeException(String message, Throwable cause)
    {
        super(message, cause);
        
        StringBuffer idBuffer = new StringBuffer();
        try
        {
            idBuffer.append(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e)
        {
            idBuffer.append("UnknownHost");
        }
        idBuffer.append("-").append(new SimpleDateFormat("HHmmss.SSS").format(new Date()));
        this.id = idBuffer.toString();
        LogFactory.getLog(this.getClass()).error("[" + id + "] " + message, cause);
    }

    public String getId()
    {
        return id;
    }
}
