package roosevelt.libraries.auth.util; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtilities 
{
	private static Log log = LogFactory.getLog(FileUtilities.class);
	
    /**
     * Intended for opening files that may be in the process of being created, this 
     * method creates a file object for a given path.  The method does not return until
     * the size of the file stops changing for a given amount of time.
     * @param filePath  Full path of the file to create.
     * @param timeToWiat  Time to wait between checking the size of the file.
     * @return A File object for the given path.
     */
    public static File getFileBlockUntilWritten(String filePath, long timeToWait)
        throws FileNotFoundException
    {
        // Create the file and make sure it exists
        File file = new File(filePath);
        if (file.exists() == false)
        {
            throw new FileNotFoundException("File (" + filePath + ") does not exist");   
        }
        
        long lastLength = file.length();
        long currentLength = 0;
        
        // Loop until the size of the file does not change for a given amount of time
        while (lastLength != currentLength)
        {
            try
            {
                Thread.sleep(timeToWait);
            }
            catch (InterruptedException e)
            {
                // Can't do much here anyways
                e.printStackTrace();   
            }

            lastLength = currentLength;
            currentLength = file.length();                  
        }
        
        // The size of the file has not changed for a while, open it and return
        return file;
    }
    
    /**
     * This method checks to see if a file exists
     * @author Pankaj Vij 03/28/2007
     * @param fileDirectoryPath
     * @param fileName
     * @return boolean
     */
    public static boolean doesFileExist(String fileDirectoryPath, String fileName)
    {        
    	String fullyQualifiedFileName = getFullyQualifiedFileName(fileDirectoryPath, fileName);
    	
        File file = new File(fullyQualifiedFileName);
        
        if (file.exists() == true)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    /**
     * This method checks to see if a file exists
     * @author Pankaj Vij 03/28/2007
     * @param fullyQualifiedFileName
     * @return boolean
     */
    public static boolean doesFileExist(String fullyQualifiedFileName)
    {            	
        File file = new File(fullyQualifiedFileName);
        
        if (file.exists() == true)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
    
    
    /**
     * This method gets the fully qualified file name when passed with an directory
     * and a file name
     * @author Pankaj Vij 03/28/2007
     * @param fileDirectoryPath
     * @param fileName
     * @return String
     */
    public static String getFullyQualifiedFileName(String fileDirectoryPath, String fileName)
    {
    	String DIR_SEPARATOR = "/";

    	String fullyQualifiedFileName = null;
    	
        if (fileDirectoryPath.endsWith(DIR_SEPARATOR))
        {
        	fullyQualifiedFileName = fileDirectoryPath + fileName;
        }
        else
        {
        	fullyQualifiedFileName = fileDirectoryPath + DIR_SEPARATOR + fileName;
        }
        
        return fullyQualifiedFileName;
    }

    
	public static String findFileInDirectoryWithBeginString(String fileDirectoryPath, String fileName){
		log.debug("fileDirectoryPath="+fileDirectoryPath+";fileName="+fileName);
		File file = new File(fileDirectoryPath);
		File[] files = file.listFiles();
		log.debug("files="+files);
		if(files == null || files.length == 0){
			return null;
		}
		String myFile = null;
		for (int i = 0; i < files.length; i++) {
			log.debug("files[i].getName()="+files[i].getName());
			if(files[i].getName().startsWith(fileName)){
				myFile = files[i].getAbsolutePath();
			}
		}
		return myFile;
	}
    
    
    
    /**
     * This method attaches a date time stamp to a file name
     * @author Pankaj Vij 03/28/2007
     * @param fileDirectoryPath
     * @param fileName
     * @return String
     */
    public static String getDateTimeStampQualifiedFileName(String fileDirectoryPath, String fileName)
    {
    	String FILE_EXTENSION_SEPARATOR = ".";
    	
    	String fullyQualifiedFileName = getFullyQualifiedFileName(fileDirectoryPath, fileName);
    	
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String dateTimeStamp = simpleDateFormat.format(new Date());
        fullyQualifiedFileName = fullyQualifiedFileName + FILE_EXTENSION_SEPARATOR + dateTimeStamp;
    	
        return fullyQualifiedFileName;
    }
    
    public static void writeToFile(File file , String stringToWrite) throws Exception
    {
        if(file == null || StringUtils.isEmpty(stringToWrite)) return;
        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write(stringToWrite.getBytes());
            fileOutputStream.flush();
        }catch(Exception ex)
        {
            throw ex;
        }finally
        {
            if(fileOutputStream != null) fileOutputStream.close();
        }
    }    

    public static void writeToFile(File file , String[] stringToWrite) throws Exception
    {
        if(file == null || stringToWrite == null || stringToWrite.length <= 0) return;
        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(file,true);
            for(int i= 0; i < stringToWrite.length; i ++)
                fileOutputStream.write(stringToWrite[i].getBytes());
            fileOutputStream.flush();
        }catch(Exception ex)
        {
            throw ex;
        }finally
        {
            if(fileOutputStream != null) fileOutputStream.close();
        }
    }
    public static void copyFile(String fromFileName, String toFileName) throws IOException 
    {
        FileInputStream from = null;
        FileOutputStream to = null;

        try 
        {
            from = new FileInputStream(fromFileName);
            to = new FileOutputStream(toFileName);
            byte[] buffer = new byte[4096];
            int bytesRead;
    
            while ((bytesRead = from.read(buffer)) != -1)
            {
                to.write(buffer, 0, bytesRead); // write
            } 
        }
        
        finally 
        {
            if (from != null)
            {
                try
                {
                    from.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            if (to != null)
            {
                try 
                {
                    to.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }    
    
} 
