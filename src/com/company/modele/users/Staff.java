package com.company.modele.users;

import java.util.Objects;

public final class Staff extends Employee {

    //instance variables
    private String role;

    //constructor

    /**
     *
     * @param id User ID
     * @param fullName Full Name of user
     * @param email Email of user
     * @param password Login password
     * @param income Income (How much the user is paid)
     * @param managerId User ID of the first-in-line manager.
     * @param role The role this user fulfills (conflict with type?)
     */
    public Staff(int id, String fullName, String email, String password, double income, int managerId, String role) {
        super("staff", id, fullName, email, password, income, managerId);
        setRole(role);
    }

    /**
     *
     * @param string String according to following principle: 'User ID/Full Name/Email/Password/Income/Manager ID/Role'
     */
    public Staff(String string) {
        super("staff/" + string);

        String stringResidue = getStringResidue();

        if (stringResidue.length() > 0) {
            String[] input = stringResidue.split(SAVE_SEPARATOR);

            setRole(input[0]);
            inputStringCount += input[0].length() + 1;
        } else {
            setRole("NO ROLE");
        }
    }

    //get+set
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    //metode

    @Override
    public String toString() {
        String string = super.toString();

        string += "Role: " + getRole() + "\n";

        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return Objects.equals(role, staff.role);
    }

    @Override
    public String saveInfo() {
        String string = super.saveInfo() + SAVE_SEPARATOR;

        string += getRole();

        return string;
    }
}
