package com.kh;
import com.kh.dao.MenuDeleteDAO;
import com.kh.dao.MenuInsertDAO;
import com.kh.dao.MenuSelectDao;
import com.kh.dao.MenuUpdateDAO;
import com.kh.util.Common;
import com.kh.vo.MenuVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {
        menuManage();       // 1. 메뉴 관리 메소드
        salesManage();      // 2. 매출 관리 메소드
    }
    public static void menuManage() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("==================== ※ 관리자모드 ※ ====================");
            System.out.println("                   ▼ 메뉴 관리 모드 ▼ ");
            System.out.print("①메뉴 조회 ②메뉴 추가 ③메뉴 수정 ④메뉴 삭제 ⑤EXIT : ");
            int sel = sc.nextInt();
            switch(sel) {
                case 1:
                    MenuSelectDao select = new MenuSelectDao();
                    List<MenuVO> list = select.listMenu();
                    select.printManuSelect(list);
                    break;
                case 2 :
                    MenuInsertDAO insert = new MenuInsertDAO();
                    insert.menuInsert();
                    break;
                case 3 :
                    MenuUpdateDAO update = new MenuUpdateDAO();
                    update.menuUpdate();
                    break;
                case 4 :
                    MenuDeleteDAO delete = new MenuDeleteDAO();
                    delete.menuDelete();
                    break;
                case 5 :
                    System.out.println("메뉴를 종료 합니다 (✿◡‿◡)");
                    return;
            }
        }
    }

    public static void salesManage() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("==================== ※ 관리자모드 ※ ====================");
            System.out.println("                   ▼ 매출 조회 모드 ▼ ");
            System.out.print("①매출전표 조회 ②일별 매출 조회 ③월별 매출 조회 ④인기 메뉴 조회 ⑤EXIT : ");
            int sel = sc.nextInt();
            switch(sel) {
                case 1:

                    break;
                case 2 :

                    break;
                case 3 :

                    break;
                case 4 :

                    break;
                case 5 :

                    return;
            }
        }
    }
}
