package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



/**
 * This class consist of generic methods to related to property file
 * @author bandu
 *
 */

public class PropertyFileUtility
{

	/**
	 * This method will read the data from property file and return value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */

public String readDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream(IConstantUtility.propertyFilePath);
	Properties pObj=new Properties();
	pObj.load(fis);
	String value=pObj.getProperty(key);
	return value;
}
}

