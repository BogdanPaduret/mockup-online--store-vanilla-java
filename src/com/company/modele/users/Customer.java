package com.company.modele.users;

import com.company.modele.users.User;

public final class Customer extends User {

    //instance variables

    //constructori

    /**
     *
     * @param id User ID
     * @param fullName User full name
     * @param email User email
     * @param password Login password
     */
    public Customer(int id,
                    String fullName,
                    String email,
                    String password) {
        super("customer", id, fullName, email, password);
    }

    /**
     *
     * @param string String according to following logic: 'User ID / User full name / User email / Login password'
     */
    public Customer(String string) {
        super("customer/" + string);

        String stringResidue = getStringResidue();

        if (stringResidue.length() > 0) {
            String[] input = stringResidue.split(SAVE_SEPARATOR);
            //instance variables code here
        } else {
            //instance variables code here
        }

    }

    //get+set

    //metode
    @Override
    public String toString() {
        String text = super.toString();

        //instance variables code here

        return text;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String saveInfo() {
        String string = super.saveInfo();

        //instance variables code here

        return string;
    }
}
