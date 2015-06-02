package com.company.stocks;

/**
 * Created by manisharana on 6/2/15.
 */
public class Stock {

    public static void main(String args[]){

        Company applPrice = new Company("ApplPrice", 70);
        Company googPrice = new Company("GoogPrice", 50);
        Employee employee1 = new Employee("employee1", applPrice);
        Employee employee2 = new Employee("employee2", googPrice);

        applPrice.changePrice(50);
        googPrice.changePrice(100);

        googPrice.removeEmployees(employee2);
        googPrice.removeEmployees(employee1);

    }

}
