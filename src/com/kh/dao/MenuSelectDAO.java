package com.kh.dao;
import com.kh.util.Common;
import com.kh.vo.MenuVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSelectDAO {
    public List<MenuVO> listMenu() { // select 해서 객체를 리스트에 넣겠다
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        List<MenuVO> list = new ArrayList<>(); // 삽입삭제보다는 조회가 많은 경우 어레이리스트 사용
        try{
            conn = Common.getConnection(); // 연결호출
            stmt = conn.createStatement(); //statement : DB에 SQL 문을 전달하여 실행시키고 결과값을 반환하기 위해 사용
            String sql = "SELECT * FROM MENU_INFO";
            rs = stmt.executeQuery(sql); // 한개의 명령어로 여러개의 결과값을 가져오는 것

            while(rs.next()) {
                String mname = rs.getString("MNAME");
                int mprice = rs.getInt("MPRICE");
                String category = rs.getString("CATEGORY");

                MenuVO vo = new MenuVO();
                vo.setMname(mname);
                vo.setMprice(mprice);
                vo.setCategory(category);
                list.add(vo); // 생성된 객체를 리스트에 저장
            }
            Common.close(rs);  // 마지막에 생성된 것 부터 닫아줌
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void printManuSelect(List<MenuVO> list) {
        for(MenuVO e : list) {
            System.out.print(e.getMname() + " - ");
            System.out.print(e.getMprice() + " - ");
            System.out.print(e.getCategory());
            System.out.println();
        }
    }
}
