package roosevelt.libraries.auth.util;

/**
 * Title:   ErrorDTO.java
 * Copyright:  (c) 2006 Delta Dental.  All rights reserved.
 * Company: Delta Dental Plan of Michigan
 * 
 * Description:  This class describes the type of error or exception
 * with a brief message and a stack trace.
 * 
 * @author:  Viraj Patil, Pankaj Vij
 * @version: 1.0 Jan 24, 2006 
 */

public class ErrorDTO extends AbstractDTO
{ 
	private String type;
	private String message;
	private String stackTrace;
    private String key;
    
    /**
     * Message Variables is a string array of variables that were used to populate the message.
     * Users of webservices can review the system documentation to determine what messages have
     * variables, and what each variable means.
     * 
     * Internally, messagesVariables are used to populate message keys for each error.  See Processor code for 
     * the specific service to find out how this is implemented.
     */
    private String[] messageVariables;
    
    public ErrorDTO() {}
    
    public ErrorDTO(String key, String msg){
    	this.key = key;
    	message = msg;
    }
    
    public ErrorDTO(String msg){
    	message = msg;
    }
    
    public String getKey()
    {
        return key;
    }
    public void setKey(String key)
    {
        this.key = key;
    }
    public String[] getMessageVariables()
    {
        return messageVariables;
    }
    public void setMessageVariables(String[] messageVariables)
    {
        this.messageVariables = messageVariables;
    }
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public String getStackTrace()
    {
        return stackTrace;
    }
    public void setStackTrace(String stackTrace)
    {
        this.stackTrace = stackTrace;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String toString()
    {
    	return "type: "+type+" key: "+key+" message: "+message;
    }
} 
