package com.company.stocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by manisharana on 5/5/15.
 */
public class Company {
    
    private String name;
    private float stockPrice;
    public ArrayList<Employee> employeeList;

    HashMap<Company,ArrayList> stockRecord = new HashMap<Company, ArrayList>();
    public Company(String name, float stockPrice) {
        this.name = name;
        employeeList= new ArrayList<Employee>();
        this.stockPrice = stockPrice;
    }

    public void addEmployees(String stockName, Employee newEmployee){
        ArrayList<Employee> employees = getEmployeeList(stockName);
        System.out.println(newEmployee.getName()+" is added");
        employees.add(newEmployee);
    }

    public void removeEmployees(Employee employee){
        ArrayList<Employee> employees = getEmployeeList(this.getName());
        if(employees.contains(employee)) {
            System.out.println(employee.getName() + " is removed");
            employees.remove(employee);
        }
        else
            System.out.println(employee.getName() + " is not registered with "+this.getName());

    }

    private ArrayList<Employee> getEmployeeList(String name) {
        Set stockNames =stockRecord.keySet();
        Iterator iterator=stockNames.iterator();

        while (iterator.hasNext())
        {
            String key=(String)iterator.next();
            employeeList=stockRecord.get(key);
        }
        return employeeList;
    }
    
    public void changePrice(float newPrice){
        if(this.stockPrice != newPrice) {
            setStockPrice(newPrice);
            notifyEmployees(this.getName());
        }
    }

    private void notifyEmployees(String stockName) {
        employeeList=getEmployeeList(stockName);
        for( Employee employee : employeeList)
            employee.notifyObserver();

    }

    private void setStockPrice(float stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getName() {
        return name;
    }
}
