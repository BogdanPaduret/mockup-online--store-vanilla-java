package com.company.modele.users;

public abstract class Employee extends User {

    //instance variables
    private double income;
    private int managerId;

    //constructor

    /**
     *
     * @param type Employee type. User for children instantiation.
     * @param id User ID
     * @param fullName User full name
     * @param email User email
     * @param password Login password
     * @param income User income
     * @param managerId User ID of direct manager
     */
    public Employee(String type,
                    int id,
                    String fullName,
                    String email,
                    String password,
                    double income,
                    int managerId) {
        super(type , id, fullName, email, password);
        setIncome(income);
        setManagerId(managerId);
    }

    /**
     *
     * @param string String according to following logic: 'Employee type / User ID / User full name / User email / User password / User income / User ID of direct manager'
     */
    public Employee(String string) {
        super(string);

        String stringResidue = getStringResidue();

        if (stringResidue.length() > 0) {
            String[] input = stringResidue.split(SAVE_SEPARATOR);
            setIncome(Double.parseDouble(input[0]));
            inputStringCount += input[0].length() + 1;
            setManagerId(Integer.parseInt(input[1]));
            inputStringCount += input[1].length() + 1;

        } else {
            setIncome(-1);
            setManagerId(-1);
        }



    }

    //get+set
    public double getIncome() {
        return income;
    }
    public void setIncome(double income) {
        this.income = income;
    }

    public int getManagerId() {
        return managerId;
    }
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    //metode

    @Override
    public String toString() {
        String string = super.toString();

        string += "Income: " + getIncome() + "\n";
        string += "Manager ID: " + getManagerId() + "\n";

        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.income, income) == 0 && managerId == employee.managerId;
    }

    @Override
    public String saveInfo() {
        String string = super.saveInfo() + SAVE_SEPARATOR;

        string += getIncome() + SAVE_SEPARATOR;
        string += getManagerId();

        return string;
    }
}
