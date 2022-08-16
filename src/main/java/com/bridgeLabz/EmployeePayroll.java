package com.bridgeLabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayroll {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll";
        String url = "root";
        String password = "Lapog@87575";
        Connection con;

        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded !...");
        } catch(Exception e){
            e.printStackTrace();
        }
        try {
            System.out.println("JDBC URl: "+jdbcURL);
            con = DriverManager.getConnection(jdbcURL, url, password);
            System.out.println("Connected Successfully.. "+con);

            int id;
            String name;
            double salary;
            //Date start_date;
            Statement stmt;
            ResultSet rs;

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery("select * from employee_payroll");

            while(rs.next()){
                id = rs.getInt(1);
                name = rs.getString(2);
                salary = rs.getDouble(3);
                //start_date = rs.getDate(4);
                employeePayrollList.add(new EmployeePayrollData(id, name, salary));

            }
            System.out.println(employeePayrollList);

           // stmt.executeUpdate("update employee_payroll set name = 'Rohanwa' where name = 'Rohan'");

            rs.close();
            stmt.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
