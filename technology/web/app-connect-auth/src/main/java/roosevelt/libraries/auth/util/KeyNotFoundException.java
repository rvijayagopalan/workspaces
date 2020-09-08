package roosevelt.libraries.auth.util;

// ----------------------------------------------------------------------------
// Title:         KeyNotFoundException.java
// Version:       1.0   16 OCT 2001 05:06:56
// Copyright:     (c) 2001 Delta Dental. All rights reserved.
// Author:        Amit Singh
// Company:       Delta Dental
// Description:
// ----------------------------------------------------------------------------

// java packages

// local packages

/**
 * 	Signals an error in looking up a value for a given key
 * <p>
 *
 */

public class KeyNotFoundException extends Exception
{
    //-------------------------------------------------------------------
    // public interface
    //-------------------------------------------------------------------

    /**
     * Constructs a KeyNotFoundException with no detail message.
     * A detail message is a String that describes this particular exception.
     */
    public KeyNotFoundException()
    {
        super();
    }

    /**
     * Constructs a KeyNotFoundException with the specified detail message.
     * A detail message is a String that describes this particular exception.
     * @param s the detail message
     */
    public KeyNotFoundException(String s)
    {
        super(s);
    }
}

// EOF
