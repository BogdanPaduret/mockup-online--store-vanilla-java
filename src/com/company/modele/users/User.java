package com.company.modele.users;

import java.util.Objects;

public abstract class User {

    //constants
    public static final String SAVE_SEPARATOR = "/";

    //instance variables
    private String type;
    private int id;
    private String fullName;
    private String email;
    private String password;

    /*
     * inputString and inputStringCount are used by the constructors from child-classes.
     * They are static variables for less memory needs.
     * Used only for class instantiation.
     */
    protected static String inputString;
    protected static int inputStringCount;

    //constructor

    /**
     *
     * @param type Type of user
     * @param id User ID
     * @param fullName Full Name of user
     * @param email Email of user
     * @param password Login password
     */
    public User(String type,
                int id,
                String fullName,
                String email,
                String password) {
        setType(type);
        setId(id);
        setFullName(fullName);
        setEmail(email);
        setPassword(password);
    }

    /**
     *
     * @param string String according to following logic: 'Type/User ID/Full Name/Email/Password'
     */
    public User(String string) {
        inputString = string;

        String[] input = inputString.split(SAVE_SEPARATOR);
        inputStringCount = 0;

        setType(input[0]);
        inputStringCount += input[0].length();
        setId(Integer.parseInt(input[1]));
        inputStringCount += input[1].length() + 1;
        setFullName(input[2]);
        inputStringCount += input[2].length() + 1;
        setEmail(input[3]);
        inputStringCount += input[3].length() + 1;
        setPassword(input[4]);
        inputStringCount += input[4].length() + 1;

    }

    //get+set
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    protected static String getStringResidue(String string, int count) {
        if (count < string.length()) {
            return string.substring(count + 1);
        } else {
            return "";
        }
    }
    protected static String getStringResidue(String string) {
        return getStringResidue(string, inputStringCount);
    }
    protected static String getStringResidue(int count) {
        return getStringResidue(inputString, count);
    }
    protected static String getStringResidue() {
        return getStringResidue(inputString, inputStringCount);
    }

    //metode
    @Override
    public String toString() {
        String string = "";

        string += "Type: " + getType() + "\n";
        string += "ID: " + getId() + "\n";
        string += "Name: " + getFullName() + "\n";
        string += "Email: " + getEmail() + "\n";
        string += "Password: " + getPassword() + "\n";

        return string;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        User user = (User) o;
//        return id == user.id && Objects.equals(type, user.type) && Objects.equals(fullName, user.fullName) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        User user = (User) o;
        return Objects.equals(type, user.type) && Objects.equals(fullName, user.fullName) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    public String saveInfo() {
        String string = "";

        string += getType() + SAVE_SEPARATOR;
        string += getId() + SAVE_SEPARATOR;
        string += getFullName() + SAVE_SEPARATOR;
        string += getEmail() + SAVE_SEPARATOR;
        string += getPassword();

        return string;
    }

}
