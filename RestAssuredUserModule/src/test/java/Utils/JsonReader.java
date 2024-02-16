package Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
    public static String readUserId() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("response.json")) {
            JSONObject jsonResponse = (JSONObject) parser.parse(reader);
            Long userId = (Long) jsonResponse.get("user_id");
            Object userIdObject = jsonResponse.get("userId");
            if (userIdObject != null) {
                return userIdObject.toString();
            } else {
                return null; // or throw an exception
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
