package com.kh;

import com.kh.util.Common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMain {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM EMP";
            rs = stmt.executeQuery(sql);
            System.out.println(rs);
            while(rs.next()) {
                System.out.print(rs.getInt("EMPNO") + " ");
                System.out.print(rs.getString("ENAME") + " ");
                System.out.print(rs.getString("JOB") + " ");
                System.out.print(rs.getInt("MGR") + " ");
                System.out.print(rs.getDate("HIREDATE") + " ");
                System.out.print(rs.getDouble("SAL") + " ");
                System.out.print(rs.getInt("COMM") + " ");
                System.out.print(rs.getInt("DEPTNO") + " ");
                System.out.println();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
