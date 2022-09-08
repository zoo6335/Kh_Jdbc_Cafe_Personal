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
        menuSelect();
    }
    public static void menuSelect() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("==================== [사장님 MENU 조회] ====================");
            System.out.println("▼ 메뉴를 선택 하세요 ▼ ");
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
                    insert.empInsert();
                    break;
                case 3 :
                    MenuUpdateDAO update = new MenuUpdateDAO();
                    update.empUpdate();
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
}
