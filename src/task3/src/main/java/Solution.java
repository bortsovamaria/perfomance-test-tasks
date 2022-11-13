import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {

        Map<Integer, String> map = new HashMap<>();

        JSONParser tests = new JSONParser();
        JSONObject values = (JSONObject) tests.parse(new FileReader(args[0]));

        JSONArray valuesJson = (JSONArray) values.get("values");

        for (Object o : valuesJson) {
            JSONObject next = (JSONObject) o;
            map.put(Integer.parseInt(String.valueOf(next.get("id"))), String.valueOf(next.get("value")));
        }

        System.out.println();

        JSONObject testsJson = (JSONObject) tests.parse(new FileReader(args[1]));
        JSONArray testsArray = (JSONArray) testsJson.get("tests");

        JSONObject resultJson = new JSONObject();


        for (Object o : testsArray) {
            JSONObject next = (JSONObject) o;
            int id = Integer.parseInt(String.valueOf(next.get("id")));
            next.put("value", map.get(id));

            try (FileWriter file = new FileWriter("/home/marialutteur/code/perfomance_test/report.json")) {
                file.write(next.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
