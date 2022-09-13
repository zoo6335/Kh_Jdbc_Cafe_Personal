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
public class SalesMonthDAO {

        public List<SalesVO> monthSalesList() {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            Scanner sc = new Scanner(System.in);
            List<SalesVO> list = new ArrayList<>();
            try{
                conn = Common.getConnection();
                stmt = conn.createStatement();
                String sql = "SELECT TO_CHAR(ORD.ORDER_DATE, 'MM') 주문일, COUNT(*) 판매량, SUM(MENU.MPRICE + OPT.OPRICE) 총매출액 " +
                            "FROM OPTION_INFO OPT, ORDER_INFO ORD, MENU_INFO MENU " +
                            "WHERE OPT.ONAME = ORD.ONAME AND MENU.MNAME = ORD.MNAME " +
                            "GROUP BY TO_CHAR(ORD.ORDER_DATE, 'MM') " +
                            "ORDER BY 주문일 ";
                rs = stmt.executeQuery(sql); // 한개의 명령어로 여러개의 결과값을 가져오는 것

                while(rs.next()) {
                    Date orddate = rs.getDate("주문일");
                    int salesRate = rs.getInt("판매량");
                    int salesTotal = rs.getInt("총매출액");

                    SalesVO dvo = new SalesVO();
                    dvo.setOrddate(orddate);
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

        public void printMonthSalesSelect(List<SalesVO> list) {
            System.out.println("  [주문일] [판매량][매출액]");
            System.out.println("-------------------------");
            for(SalesVO e : list) {
                System.out.print(e.getOrddate() + " | ");
                System.out.print(e.getSalesRate() + " | ");
                System.out.print(e.getSalesTotal());
                System.out.println();
            }
        }
}