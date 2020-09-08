package roosevelt.libraries.auth.util;

/**
 * Title:   AbstractDTO.java
 * Copyright:  (c) 2006 Delta Dental.  All rights reserved.
 * Company: Delta Dental Plan of Michigan
 * 
 * Description:  This is a base class for all data transfer objects (DTOs) across
 * all applications.
 *
 * @author:  Viraj Patil, Pankaj Vij
 * @version: 1.0 Jan 24, 2006 
 */

public abstract class AbstractDTO implements java.io.Serializable
{ 
    private Long oid;
    private Long version;
    private String userId;
    private String applicationName;


    public AbstractDTO()
    {
    }
    
    public AbstractDTO(AbstractDTO that)
    {
        this.oid = that.oid;
        this.version = that.version;
        this.userId = that.userId;
        this.applicationName = that.applicationName;
    }
    
    public final Long getOid()
    { 
        return oid; 
    }
    
    public final void setOid( Long value )
    { 
        oid = value; 
    }

    public final Long getVersion()
    { 
        return version; 
    }
    
    public final void setVersion( Long value )
    { 
        version = value; 
    }
    
    public final String getUserId()
    {
        return userId;
    }

    public final void setUserId(String value)
    {
        userId = value;
    }

    public final String getApplicationName()
    {
        return applicationName;
    }

    public final void setApplicationName(String value)
    {
        applicationName = value;
    }
    
    public boolean equals(Object o)
    {
        if ( o == null )
            return false;

        if ( !(o instanceof AbstractDTO ) )
            return false;

        AbstractDTO obj = (AbstractDTO) o;
        
        if( obj.getOid() == null || getOid() == null )
            return obj == this;

        else if ( obj.getOid().equals( getOid() ) )
            return true;

        return false;
    }

    public int hashCode()
    {
        if ( getOid() != null )
            return getOid().hashCode();
        else
            return super.hashCode();
    }
} 
