package com.company.stocks;

/**
 * Created by manisharana on 5/5/15.
 */
public class Employee {

    private String name;
    private Company company;

    Employee(String name, Company company) {
        this.name = name;
        this.company = company;
        company.addEmployees(company.getName(), this);
    }

    public void notifyObserver() {
        System.out.println(this.name+"- Stock prices of " + company.getName() + " changed");
    }

    public String getName() {
        return name;
    }
}
