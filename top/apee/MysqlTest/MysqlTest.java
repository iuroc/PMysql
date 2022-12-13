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
        // 创建表
        pmysql.executeUpdate("CREATE TABLE IF NOT EXISTS `apee_test` (`id` INT PRIMARY KEY)");
        // 插入数据
        int num = pmysql.executeUpdate("INSERT INTO `apee_test` VALUES (1)");
        if (num > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }
}
