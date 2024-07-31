/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import javax.swing.JOptionPane;
/**
 *
 * @author nikit
 */
public class Tables {
    public static void main (String[] args){
        try{
          String userTables = "create table user (id int AUTO_INCREMENT primary key, name varchar(200),email varchar(200) unique,mobile varchar(10),address varchar(200),password varchar(200),securityquestion varchar(300),answer varchar(200),status varchar(20))";
          String adminDetails = "insert into user(name,email,mobile,address,password,securityquestion,answer,status)values('Admin','admin@gmail.com','1234567890','India','admin','What primary school did you attend?','ABC','true')";
          String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
          String ProductTable = "create table Product(id int AUTO_INCREMENT primary key,name varchar(200), category varchar(200),price varchar(200))";
           String BillTable = "create table Bill(id int  primary key,name varchar(200), mobile varchar(200),email varchar(200), date varchar(50),total varchar(200), createdBy varchar(200))";
        // DbOpertions.setDataOrDelete(BillTable, "Bill Table created sucessfully");
           // DbOpertions.setDataOrDelete(ProductTable, "Product Table created sucessfully");
          //  DbOpertions.setDataOrDelete(userTables,"User Table created sucessfully");
          //  DbOpertions.setDataOrDelete(adminDetails, "Admin details added sucessfully");
            DbOpertions.setDataOrDelete(categoryTable, "Category Table created sycessfully sucessfully");
    }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
}}
