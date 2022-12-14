package top.apee.MysqlTest;

import java.sql.*;
import top.apee.PMysql.PMysql;

public class MysqlTest {
    public static void main(String[] args) {
        // 创建数据库操作对象
        PMysql pmysql = new PMysql();
        // 设置数据库密码
        pmysql.password = "12345678";
        // 设置数据库名称
        pmysql.database = "ponconsoft";
        // 连接到数据库
        pmysql.connect();
        ResultSet resultSet = pmysql.executeQuery("SELECT * FROM `apee_test`");
        while (PMysql.Result.next(resultSet)) {
            int id = (int) pmysql.getValue(resultSet, "id");
            System.out.println(id);
        }
    }
}
