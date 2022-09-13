package com.kh.dao;
import com.kh.util.Common;
import com.kh.vo.SalesVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 매출 조회 Data Access Object

public class SalesDAO {
    public List<SalesVO> salesList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        List<SalesVO> list = new ArrayList<>();
        try{
            conn = Common.getConnection(); // 연결호출
            stmt = conn.createStatement(); //statement(DB에 SQL 문을 전달하여 실행시키고 결과값을 반환)
            String sql = "SELECT ORD.ORDER_NO 주문번호, ORD.ORDER_DATE 주문일, MENU.MNAME 메뉴명, MENU.MPRICE 가격, OPT.ONAME 추가옵션, OPT.OPRICE 추가금액, (MENU.MPRICE + OPT.OPRICE) 총주문금액 " +
                        "FROM OPTION_INFO OPT, ORDER_INFO ORD, MENU_INFO MENU " +
                        "WHERE OPT.ONAME = ORD.ONAME AND MENU.MNAME = ORD.MNAME " +
                        "ORDER BY ORD.ORDER_NO ";
            rs = stmt.executeQuery(sql); // 한개의 명령어로 여러개의 결과값을 가져오는 것

            while(rs.next()) {
                int ordnum = rs.getInt("주문번호");      // 주문번호
                Date orddate = rs.getDate("주문일"); // 주문일
                String mname = rs.getString("메뉴명");   // 메뉴명
                int mprice = rs.getInt("가격");       // 가격
                String oname = rs.getString("추가옵션");    // 추가옵션
                int oprice = rs.getInt("추가금액");       //추가금액
                int salesTotal = rs.getInt("총주문금액"); // 총 주문금액

                SalesVO svo = new SalesVO();
                svo.setOrdnum(ordnum);
                svo.setOrddate(orddate);
                svo.setMname(mname);
                svo.setMprice(mprice);
                svo.setOname(oname);
                svo.setOprice(oprice);
                svo.setSalesTotal(salesTotal);
                list.add(svo); // 생성된 객체를 리스트에 저장
            }
            Common.close(rs);  // 마지막에 생성된 것 부터 닫아줌
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void printSalesSelect(List<SalesVO> list) {
        for(SalesVO e : list) {
            System.out.print(e.getOrdnum() + " | ");
            System.out.print(e.getOrddate() + " | ");
            System.out.print(e.getMname() + " | ");
            System.out.print(e.getMprice() + " | ");
            System.out.print(e.getOname() + " | ");
            System.out.print(e.getOprice() + " | ");
            System.out.print(e.getSalesTotal());
            System.out.println();
        }
    }
}
