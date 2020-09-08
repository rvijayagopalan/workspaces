package roosevelt.libraries.auth.util; 

import java.util.*;

public final class StringUtils 
{ 
    // Utility classes should not be instantiated.
    private StringUtils(){}

    /**
     * @param string - the date that is in question
     * @param startString - the date that the date in question needs to be greater than (or equal to)
     * @param endString - the date that the date in question needs to be less than (or equal to)
     * @param inclusive - indicates that the (or equal to) should be used
     * 
     * A null string will always return false.  That is because something needs to be compared.
     * A null startString is interpreted as 'the beginning of time'.
     * A null endString is interpreted as 'the end of time'.
     * Both a null startString and null endString will alwyas return true, so long as string is something.
     */    
    public static boolean stringIsInRange( 
        String string, String startString, String endString, boolean inclusive )
    {
        if ( string == null )
            return false;

        if( startString != null )
        {            
            int startStringCompare = string.compareToIgnoreCase( startString );
    
            if ( endString != null )
            {
                int endStringCompare = string.compareToIgnoreCase( endString );
    
                if ( inclusive )            
                    return     
                        ( startStringCompare > 0 || startStringCompare == 0 ) && 
                        ( endStringCompare < 0 || endStringCompare == 0 );
                else
                    return ( startStringCompare > 0 ) && ( endStringCompare < 0 );
            }
            else
            {
                if ( inclusive )
                    return ( startStringCompare > 0 || startStringCompare == 0 );
                else
                    return ( startStringCompare > 0 );
            }
        }
        else
        {
            if ( endString != null )
            {
                int endStringCompare = string.compareToIgnoreCase( endString );
    
                if ( inclusive )            
                    return     
                        ( endStringCompare < 0 || endStringCompare == 0 );
                else
                    return ( endStringCompare < 0 );
                
            }            
            else
            {
                return true;
            }
        }
    }    
    
    public static String arrayToString(Long[] array)
    {
        if (array == null)
        {
            return "null";   
        }
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++)
        {
           sb.append(array[i]);
           sb.append(',');
        }
        if (sb.length() > 0)
        {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();        
    }   
} 
