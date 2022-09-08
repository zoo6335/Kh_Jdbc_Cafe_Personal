package com.kh.dao;
import com.kh.util.Common;
import com.kh.vo.MenuVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Data Access Object
// 쿼리문으로 DB의 정보를 가져옴
public class MenuDeleteDAO {

    public void menuDelete() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 이름을 입력하세요 : ");
        String mname = sc.next();
        String sql = "DELETE FROM MENU_INFO WHERE MNAME = ?";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mname);
            int ret = pstmt.executeUpdate();
            System.out.println("Return : " + ret);
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.commit(conn);
        Common.close(pstmt);
        Common.close(conn);
    }
}

