package com.kh.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

    public class Common {
        // 변하지 않는 주소, 아이디 등을 정의해놓고 대체하여 사용하기 위한 선언임
        final static String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 최종 상수 선언
        final static String ORACLE_ID = "SCOTT";
        final static String ORACLE_PW = "TIGER";
        final static String ORACLE_DRV = "oracle.jdbc.OracleDriver";

        public static Connection getConnection() {
            Connection conn = null;
            try {
                Class.forName(ORACLE_DRV);  // 드라이버 로딩
                // 연결 얻기
                conn = DriverManager.getConnection(ORACLE_URL, ORACLE_ID, ORACLE_PW);
                conn.setAutoCommit(false);  // 기본값이 true 여서 이문장이 없어도 기본적으로 오토커밋이 됨
                System.out.println("오라클 DB 연결 성공");
            } catch(Exception e){
                e.printStackTrace(); // 에러 리스트(호출관계)를 보여줘라!
            }
            return conn;
        }
        // 해제 close 오버로딩
        public static void close(Connection conn) {
            try{
                if(conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("연결 해제 성공");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        public static void close(Statement stmt) {
            try{
                if(stmt != null && !stmt.isClosed()) {
                    stmt.close();
                    System.out.println("연결 해제 성공");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        public static void close(ResultSet rset) {
            try{
                if(rset != null && !rset.isClosed()) {
                    rset.close();
                    System.out.println("연결 해제 성공");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        public static void commit(Connection conn){
            try{
                conn.commit();
                System.out.println("커밋 완료");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public static void rollback(Connection conn){
            try{
                if(conn != null && !conn.isClosed()){
                    conn.rollback();
                    System.out.println("롤백 완료");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
    }
}

