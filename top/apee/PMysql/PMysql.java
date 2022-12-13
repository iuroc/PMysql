package top.apee.PMysql;

import java.sql.*;

/**
 * 数据库操作类
 * 
 * @author 欧阳鹏
 */
public class PMysql {
    /**
     * 数据库服务器地址
     */
    public String host = "localhost";
    /**
     * 数据库服务器端口
     */
    public String port = "3306";
    /**
     * 数据库用户名
     */
    public String username = "root";
    /**
     * 数据库用户密码
     */
    public String password = "";
    /**
     * 需要访问的数据库名
     */
    public String database = "";

    /**
     * 数据库连接对象
     */
    public Connection connection = null;

    /**
     * 连接到数据库，需要先设置 {@code password} {@code database}，可设置的还有
     * {@code host} {@code port} {@code username}
     * 
     * @return 数据库连接对象
     */
    public Connection connect() {
        String uri = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database;
        try {
            this.connection = DriverManager.getConnection(uri, this.username, this.password);
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            System.exit(0);
        }
        return connection;
    }

    /**
     * 执行 SQL 查询，适用于 {@code SELECT}
     * 
     * @param sql SQL 语句
     */
    public ResultSet executeQuery(String sql) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 执行 SQL 查询，适用于 {@code INSERT} {@code UPDATE} {@code DELETE} {@code CREATE} 等
     * 
     * @param sql SQL 语句
     * @return 返回成功执行的条数
     */
    public int executeUpdate(String sql) {
        Statement statement = null;
        int num = 0;
        try {
            statement = this.connection.createStatement();
            num = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    /**
     * 获取 SQL 查询结果中的数据
     * 
     * @param resultSet
     * @param columnLabel
     * @return
     */
    public Object getValue(ResultSet resultSet, String columnLabel) {
        Object object = null;
        try {
            object = resultSet.getObject(columnLabel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * {@code SELECT} 查询结果
     */
    public Result result = new Result();

    public class Result {
        /**
         * 游标移动到下一条记录
         * 
         * @param resultSet SQL 查询结果
         */
        public boolean next(ResultSet resultSet) {
            try {
                return resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}