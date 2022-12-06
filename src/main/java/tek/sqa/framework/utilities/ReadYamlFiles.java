package tek.sqa.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	
	//Singleton. 
	private static ReadYamlFiles readYamlFiles;
	
	//encapsulated property 
	private HashMap propertyMap;
	
	//private Constructor. required file Path. 
	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		//File Input stream of a yaml file. 
		FileInputStream fis = FileUtility.getFileInputStream(filePath);
		Yaml yaml = new Yaml();
		this.propertyMap = yaml.load(fis);
	}
	//method to return an instance of this class. 
	public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
		if (readYamlFiles == null) {
			return new ReadYamlFiles(filePath);
		}
		
		return readYamlFiles;
	}
	
	//getter for the encapsulated property. 
	public HashMap getProprty(String key) {
		return (HashMap) this.propertyMap.get(key);
	}
	
}
