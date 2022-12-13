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
        // 执行 SQL 查询
        ResultSet resultSet = pmysql.executeQuery("SELECT * FROM `xiang_jiao_adult_video`");
        // 打印查询结果
        while (pmysql.result.next(resultSet)) {
            String string = (String) pmysql.getValue(resultSet, "title");
            System.out.println(string);
        }
    }
}
