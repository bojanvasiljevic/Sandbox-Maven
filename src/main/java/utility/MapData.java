package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class MapData {

	public static HashMap<String, String> dataMap;
	public static final String DATA_PATH = "G:\\Bojan Java\\maven-itbootcamp\\src\\main\\resources\\data.txt";

	/**
	 * Loads data from txt file and returns HashMap with key values.
	 * 
	 * @return HashMap<String, String>
	 * @throws IOException
	 */
	public static HashMap<String, String> setDataMap() throws IOException {

		File dataFile = new File(DATA_PATH);
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));
		dataMap = new HashMap<String, String>();

		String text;

		while ((text = reader.readLine()) != null) {
			String[] key = text.split("  ");
			dataMap.put(key[0], key[1]);
		}
		reader.close();
		return dataMap;

	}

	/**
	 * Returns String value form HashMap
	 * 
	 * @param keyValue
	 * @return String
	 * @throws IOException
	 */
	public static String getKeyValue(String keyValue) throws IOException {
		return dataMap.get(keyValue.toUpperCase());

	}

}
