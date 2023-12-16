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

        if (isUsernameOrEmailExists(jsonArray, user.getEmail())) {
            return false;
        }

        JSONObject userJson = new JSONObject();
        userJson.put("id", getPreviousId(jsonArray) + 1);
        userJson.put("email", user.getEmail());
        userJson.put("password", user.getPassword());
        userJson.put("fullname", user.getFullname());
        userJson.put("scores", user.getScores());
        userJson.put("role", user.getRole());
        jsonArray.put(userJson);

        writeJsonFile(jsonArray);
        return true;
    }

    private boolean isUsernameOrEmailExists(JSONArray jsonArray, String email) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject userJson = jsonArray.getJSONObject(i);
            String existingEmail = userJson.getString("email");
            if (existingEmail.equals(email))
                return true;
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

    public User getUserByEmail(String username) {
        JSONArray jsonArray = readJsonFile();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject userJson = jsonArray.getJSONObject(i);

            if (username.equals(userJson.getString("email"))) {
                return jsonToUser(userJson);
            }
        }

        return null;
    }

    private User jsonToUser(JSONObject userJson) {
        return new User(
                userJson.getInt("id"),
                userJson.getString("email"),
                userJson.getString("password"),
                userJson.getString("fullname"),
                userJson.getLong("scores"),
                converRole(userJson.getString("role"))
        );
    }

    private int converRole(String role) {
        if  (role.equalsIgnoreCase("user")) return 1;
        else if  (role.equalsIgnoreCase("admin")) return 2;
        else if  (role.equalsIgnoreCase("superadmin")) return 3;
        else return 0;
    }

    private String converRole(int role) {
        String s = "";

        switch (role) {
            case 0 -> s = "";
            case 1 -> s = "User";
            case 2 -> s = "Admin";
            case 3 -> s = "SuperAdmin";
        }

        return s;
    }

    public void updateUser(User updatedUser) {
        JSONArray jsonArray = readJsonFile();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject userJson = jsonArray.getJSONObject(i);
            int userId = userJson.getInt("id");

            if (userId == updatedUser.getId()) {
                userJson.put("email", updatedUser.getEmail());
                userJson.put("password", updatedUser.getPassword());
                userJson.put("fullname", updatedUser.getFullname());
                userJson.put("scores", updatedUser.getScores());
                userJson.put("role", updatedUser.getRole());

                writeJsonFile(jsonArray);
                return;
            }
        }
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
