package api.com.util;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;

public class ReadTestData {
	
	public static JSONObject getJsonData() throws IOException, JSONException, ParseException {
		
		//pass the path of the testdata.json file
		
		File filename = new File("Resources/TestData/testdata.json");
		
		//convert json file into the String
		String json = FileUtils.readFileToString(filename,"UTF-8");
		//Parse the String into the Object
		Object obj = new JSONParser().parse(json);
		
		//give json object that i can return it to the function everytime it get called
		JSONObject jsonObject =(JSONObject)obj;
		return jsonObject;
	}

	public static String getTestData(String keyname) throws IOException,  org.json.simple.parser.ParseException {
	    String testdata;
	    Object data = getJsonData().get(keyname);
	    if (data != null) {
	        testdata = data.toString();
	        return testdata;
	    } else {
	        // Handle the case where the key is not found
	        return null; // Or throw an exception, log a message, etc.
	    }
	}
	
	
	

}
