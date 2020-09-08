package roosevelt.libraries.auth.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * FileUtils for IO operations
 * 
 * @author Rohan Surve
 * @version 1.0
 * @since 2019-03-19
 */
public class FileUtils {

	private FileUtils() {
	}

	private static class FileUtilsHolder {
		static final FileUtils INSTANCE = new FileUtils();
	}

	public static FileUtils getInstance() {
		return FileUtilsHolder.INSTANCE;
	}


	public Properties readPropsFromPath(String path) {
		//log.debug("Reading Property File from resource path....... {}", path);
		return getPropertiesFromStream(path, getClass().getClassLoader().getResourceAsStream(path));
	}

	public Properties readPropsFromFilePath(String path) {
		//log.debug("Reading Property File from file path....... {}", path);
		Properties properties = new Properties();
		try {
			properties = getPropertiesFromStream(path, new FileInputStream(path));
		} catch (FileNotFoundException e) {
			//throw BootstrapException.exceptionBuilder()
					//.message("Reading Property File : " + path + " errored with cause : ").exception(e).build();
		}		
		return properties;
	}

	private Properties getPropertiesFromStream(String path, InputStream inputStream1) {
		Properties properties = new Properties();
		try (InputStream inputStream = inputStream1) {
			properties.load(inputStream);
		} catch (IOException e) {
			//throw BootstrapException.exceptionBuilder()
			//		.message("Reading Property File : " + path + " errored with cause : ").exception(e).build();
		}
		return properties;
	}
}
