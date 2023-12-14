package project.main.user;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final String JSON_FILE_PATH;

    public UserRepository() {
        JSON_FILE_PATH = "D:\\DSAK67A4\\src\\project\\data\\user.json";
    }


    public boolean addUser(User user) {
        JSONArray jsonArray = readJsonFile();

        if (isUsernameOrEmailExists(jsonArray, user.username, user.email))
            return false;
        
        JSONObject userJson = new JSONObject();
        userJson.put("id", getPreviousId(jsonArray) + 1);
        userJson.put("fullname", user.fullname);
        userJson.put("username", user.username);
        userJson.put("email", user.email);
        userJson.put("password", user.password);
        userJson.put("isempty", user.isEmpty);
        jsonArray.put(userJson);

        writeJsonFile(jsonArray);
        return true;
    }

    private boolean isUsernameOrEmailExists(JSONArray jsonArray, String username, String email) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject userJson = jsonArray.getJSONObject(i);
            String existingUsername = userJson.getString("username");
            String existingEmail = userJson.getString("email");

            if (existingUsername.equals(username) || existingEmail.equals(email)) {
                return true;
            }
        }

        return false;
    }

    private int getPreviousId(JSONArray jsonArray) {
        if (!jsonArray.isEmpty()) {
            JSONObject previousUser = jsonArray.getJSONObject(jsonArray.length() - 1);
            return previousUser.getInt("id");
        } else {
            return 0;
        }
    }

    private JSONArray readJsonFile() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));

            if (content.isEmpty())
                content = "[]";

            return new JSONArray(content);
        } catch (IOException e) {
            return new JSONArray();
        }
    }

    private void writeJsonFile(JSONArray jsonArray) {
        try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
            fileWriter.write(jsonArray.toString(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int userId) {
        JSONArray jsonArray = readJsonFile();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject userJson = jsonArray.getJSONObject(i);
            int id = userJson.getInt("id");

            if (id == userId) {
                return jsonToUser(userJson);
            }
        }

        return null;
    }

    public User getUserByUsernameOrEmail(String username) {
        JSONArray jsonArray = readJsonFile();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject userJson = jsonArray.getJSONObject(i);
            String us = userJson.getString("username");
            String email = userJson.getString("email");

            if (username.equals(us) || username.equals(email)) {
                return jsonToUser(userJson);
            }
        }

        return null;
    }

    private User jsonToUser(JSONObject userJson) {
        return new User(
                userJson.getInt("id"),
                userJson.getString("fullname"),
                userJson.getString("username"),
                userJson.getString("password"),
                userJson.getString("email"),
                userJson.getBoolean("isempty")
        );
    }

    public void updateUser(User updatedUser) {

    }

    public List<User> getAllUsers() {
        JSONArray jsonArray = readJsonFile();

        List<User> userList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject userJson = jsonArray.getJSONObject(i);
            User user = jsonToUser(userJson);
            userList.add(user);
        }

        return userList;
    }
}
