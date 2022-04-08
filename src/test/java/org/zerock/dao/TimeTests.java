package org.zerock.dao;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeTests {

    @Test
    public void testnow()throws Exception{

        Class.forName("org.mariadb.jdbc.Driver");

        @Cleanup Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser");

       @Cleanup PreparedStatement pstmt = con.prepareStatement("select now()");

       @Cleanup ResultSet resultSet = pstmt.executeQuery();

       resultSet.next();

        System.out.println(resultSet.getString(1));

    }
}
