package com.simetrik.qa.utils;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.JSONObject;
import org.testng.Assert;

public class RegionDataObject {

	/**
	 * This method converts JSON file to String
	 * 
	 * @param fileName
	 * @return
	 */
	public static String jsonToStrConvertion(String fileName) {
		String str = null;

		try {
			byte[] encoded = Files.readAllBytes(Paths.get("src/test/resources/config/" + fileName + ".json"));
			str = new String(encoded, Charset.defaultCharset());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}

	/**
	 * This method retrieves all mapped region configuration data in JSON file and
	 * filters by retrieving only specified region data
	 * 
	 * @param testRegion
	 * @param fileName
	 */

	public static void filterRegion(String testRegion, String fileName) {

		// Path the file name to convert json to string and assign to str obj
		String jsonToString = jsonToStrConvertion(fileName);

		try {
			// Convert to JSON object
			JSONObject obj = new JSONObject(jsonToString);
			// check if jsonobject is not null and contains the specified region

			if (obj != null && obj.has(testRegion)) {
				// get the specified region associated key value
				JSONObject region = obj.getJSONObject(testRegion);

				Iterator<String> keys = region.keys();

				// loop through json object and store in regionDataMap
				while (keys.hasNext()) {
					String key = keys.next();

					// if key is null or empty then dont add value to map
					if (region.optString(key) != null && !region.optString(key).equals("")) {
						Constants.regionDataMap.put(key, region.optString(key));
					}
				}

			} else {
				// Raise an error if the specified test region was not mapped in json file
				Assert.fail("Unable to Locate Region: " + testRegion + " in " + fileName + ".json file");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
