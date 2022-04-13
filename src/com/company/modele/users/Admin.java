package com.company.modele.users;

import java.util.Objects;

public final class Admin extends Employee {

    //instance variables
    private String roleGroup;

    //constructor

    /**
     *
     * @param id User ID
     * @param fullName User full name
     * @param email User Email
     * @param password User Password
     * @param income User income (How much the user gets paid)
     * @param managerId User ID of direct manager
     * @param roleGroup Rolegroup the user is part of
     */
    public Admin(int id,
                 String fullName,
                 String email,
                 String password,
                 double income,
                 int managerId,
                 String roleGroup) {
        super("admin", id, fullName, email, password, income, managerId);
        setRoleGroup(roleGroup);
    }

    /**
     *
     * @param string String according to following logic: 'User ID / User Full Name / User Email / Login Password / User income / Direct manager user ID / Role group'
     */
    public Admin(String string) {
        super("admin/" + string);

        String stringResidue = getStringResidue();

        if (stringResidue.length() > 0) {
            String[] input = stringResidue.split(SAVE_SEPARATOR);
            setRoleGroup(input[0]);
            inputStringCount += input[0].length() + 1;
        } else {
            setRoleGroup("NO ROLE GROUP");
        }
    }

    //get+set
    public String getRoleGroup() {
        return roleGroup;
    }
    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    //metode

    @Override
    public String toString() {
        String string = super.toString();

        string += "Administrator role group: " + getRoleGroup() + "\n";

        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(roleGroup, admin.roleGroup);
    }

    @Override
    public String saveInfo() {
        String string = super.saveInfo() + SAVE_SEPARATOR;

        string += getRoleGroup();

        return string;
    }
}
