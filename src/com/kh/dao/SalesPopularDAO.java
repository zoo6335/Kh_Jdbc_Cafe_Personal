package com.kh.dao;
import com.kh.util.Common;
import com.kh.vo.SalesVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesPopularDAO {
    public List<SalesVO> popularSalesList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        List<SalesVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT ORD.MNAME 메뉴명, COUNT(*) 판매량, SUM(MENU.MPRICE + OPT.OPRICE) 매출액 " +
                    "FROM OPTION_INFO OPT, ORDER_INFO ORD, MENU_INFO MENU " +
                    "WHERE OPT.ONAME = ORD.ONAME AND MENU.MNAME = ORD.MNAME " +
                    "AND ORD.ORDER_DATE BETWEEN SYSDATE-30 AND SYSDATE " +
                    "GROUP BY ORD.MNAME " +
                    "ORDER BY 판매량 DESC ";
            rs = stmt.executeQuery(sql); // 한개의 명령어로 여러개의 결과값을 가져오는 것

            while (rs.next()) {
                String mname = rs.getString("메뉴명");
                int salesRate = rs.getInt("판매량");
                int salesTotal = rs.getInt("매출액");

                SalesVO dvo = new SalesVO();
                dvo.setOrdDateM(mname);
                dvo.setSalesRate(salesRate);
                dvo.setSalesTotal(salesTotal);
                list.add(dvo); // 생성된 객체를 리스트에 저장
            }
            Common.close(rs);  // 마지막에 생성된 것 부터 닫아줌
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void printPopularSalesSelect(List<SalesVO> list) {
        System.out.println("------------최근 한달간 인기 메뉴 순위-------------");
        System.out.println(" [메뉴]  [판매량]  [매출액]");

        for(SalesVO e : list) {
            System.out.print(e.getOrdDateM() + " | ");
            System.out.print(e.getSalesRate() + " | ");
            System.out.print(e.getSalesTotal());
            System.out.println();
        }
    }
}

