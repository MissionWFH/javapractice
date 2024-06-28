package com.java.practice.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleDBCon {

    public static void main(String args[]) {

        String query = "select * from login_master";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/BankDB", "root", "");

            System.out.println("connected");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                //con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


