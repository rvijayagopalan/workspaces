package roosevelt.libraries.auth.util; 

/**
 * ApplicationException is intended to help us distinguish a system type exception vs.
 * application specific exception.
 * 
 * This is created because we want the clients of web services to be able to show error
 * messages if the error is business/application related (i.e. Required field not set in the 
 * web service request)
 */
public class ApplicationException extends DeltaDentalRuntimeException
{ 
    private static final long serialVersionUID = -2311554922307064137L;
    private ErrorDTO[] errorDTOs;

    public ApplicationException(String message)
    {
        super(message);
    }

    public ApplicationException(Exception e)
    {
        super(e);
    }
    
    public ApplicationException(String message, Exception e)
    {
        super(message, e);
    }
    
    public ApplicationException(String message, ErrorDTO[] errorDTOs)
    {
        super(message);
        this.errorDTOs = errorDTOs;
    }

    public ErrorDTO[] getErrorDTOs()
    {
        return errorDTOs;
    }
}
