package com.company.controllere;

import com.company.modele.users.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlUser{

    //instance variables
    private ArrayList<User> users;
    private String path;

    //constructor
    private ControlUser(String path) {
        users = new ArrayList<>();
        this.path = path;
        load();
    }
    private ControlUser() {
        this("src/com/company/resources/users");
    }

    //create
    public boolean add (User user) {
        if (exists(user)) {
            return false;
        } else {
            this.users.add(user);
            return true;
        }
    }
    public int generateNewId() {
        if (users.size() == 0) {
            return 1;
        }
        return users.get(users.size() - 1).getId() + 1;
    }
    public void save() {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String toSave() {
        String string = "";
        for (User user : users) {
            string += user.saveInfo() + "\n";
        }
        return string;
    }

    //read
    public boolean load() {
        try {
            clearSession();
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line != "") {
                    String[] input = line.split(User.SAVE_SEPARATOR);
                    String type = input[0];
                    switch (type) {
                        default:
                            return users.add(new Employee(line));
                        case "admin":
                            return users.add(new Admin(line));
                        case "customer":
                            return users.add(new Customer(line));
                        case "staff":
                            return users.add(new Staff(line));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean exists(User user) {
        for (User u : users) {
            if (u.equals(user)) {
                return true;
            }
        }
        return false;
    }
    public boolean exists(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public String showUsers() {
        String string = "";
        int index = 0;
        for (User user : users) {
            index++;
            string += "User " + index + "\n";
            string += user.toString() + "\n\n";
        }
        return string;
    }
    public User get(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public int size() {
        int c = 0;
        for (User user : users) {
            c++;
        }
        return c;
    }

    //update
    public void updateId(int id, int newId) {
        get(id).setId(newId);
    }
    public void updateType(int id, String type) {
        get(id).setType(type);
    }
    public void updateName(int id, String fullName) {
        get(id).setFullName(fullName);
    }
    public void updateEmail(int id, String email) {
        get(id).setEmail(email);
    }
    public void updatePassword(int id, String password) {
        get(id).setPassword(password);
    }

    //delete
    public void clearSession() {
        users.clear();
    }
    public void deleteAll() {
        users.clear();
        save();
    }
    public boolean remove(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                users.remove(u);
                return true;
            }
        }
        return false;
    }
}
