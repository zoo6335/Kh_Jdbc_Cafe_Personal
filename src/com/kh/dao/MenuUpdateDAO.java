package com.kh.dao;
import com.kh.util.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MenuUpdateDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public void menuUpdate() {


        System.out.println("=====변경할 메뉴 정보 입력=====");
        System.out.print("메뉴명 : ");
        String mname = sc.next();
        System.out.print("가격 : ");
        int mprice = sc.nextInt();
        System.out.print("카테고리 : ");
        String category = sc.next();

        String sql = "UPDATE MENU_INFO SET MPRICE = ? , CATEGORY = ? WHERE MNAME = ?";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mprice);
            pstmt.setString(2, category);
            pstmt.setString(3, mname);

            int ret = pstmt.executeUpdate();
            System.out.println("Return : " + ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Common.commit(conn);
        Common.close(pstmt);
        Common.close(conn);
    }
}
