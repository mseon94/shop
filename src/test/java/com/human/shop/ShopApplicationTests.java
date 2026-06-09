package com.human.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopApplicationTests {

    // 1. 일반 메인 메서드 추가
    public static void main(String[] args) {
        // 본인의 application.properties에 기재된 DB 접속 정보(URL, ID, PW)를 입력합니다.
        String url = "jdbc:mariadb://localhost:3306/shopdb"; 
        String user = "root"; 
        String password = "1111"; 

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("=== DB 연결 성공: " + conn + " ===");
        } catch (Exception e) {
            System.out.println("=== DB 연결 실패 ===");
            e.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        // 기존 테스트 코드는 비워두거나 유지합니다.
    }
}