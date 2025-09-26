package com.oha_yo.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://vm105:5432/soodb"; // デフォルトDB名
        String user = "sooni";
        String password = "soopass";

        String query = "SELECT current_user, current_schema(), current_database()";

        System.out.println("PostgreSQL JDBC Test!");
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("User:     " + rs.getString(1));
                System.out.println("Schema:   " + rs.getString(2));
                System.out.println("Database: " + rs.getString(3));
            }

        } catch (Exception e) {
            System.err.println("接続またはクエリ実行に失敗しました:");
            e.printStackTrace();
        }
        System.out.println("PostgreSQL JDBC Test End");
    }
}

