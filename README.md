# PMysql

> Java MySQL 操作工具类

## 开发信息

- 作者：欧阳鹏
- 开发日期：2022年12月14日
- 官网：https://apee.top

## 使用方式

1. 导入 [`PMysql.jar`](https://github.com/oyps/PMysql/releases/download/1.12.14/PMysql.jar)（VSCode 直接将 `.jar` 文件放到 `lib` 文件夹中即可）
2. 使用 `import` 引入

    ```java
    import top.apee.PMysql.PMysql;
    ```

## API 实例

- 连接到数据库

    ```java
    // 创建数据库操作对象
    PMysql pmysql = new PMysql();
    // 设置数据库密码
    pmysql.password = "12345678";
    // 设置数据库名称
    pmysql.database = "ponconsoft";
    // 连接到数据库
    pmysql.connect();
    ```

- 创建表

    ```java
    pmysql.executeUpdate("CREATE TABLE IF NOT EXISTS `my_table` (`id` INT PRIMARY KEY)");
    ```

- 插入数据

    ```java
    int num = pmysql.executeUpdate("INSERT INTO `apee_test` VALUES (1)");
    if (num > 0) {
        System.out.println("插入成功");
    } else {
        System.out.println("插入失败");
    }
    ```

- 执行 SELECT 查询

    ```java
    ResultSet resultSet = pmysql.executeQuery("SELECT * FROM `my_table`");
    ```

- 游标移动

    ```java
    pmysql.result.next(resultSet);
    ```

- 获取查询结果的内容
  - 获取一条

    ```java
    // 移动游标到下一条记录
    pmysql.result.next(resultSet);
    // 字符串
    String string = (String) mysql.getValue(resultSet, "title");
    // 数字
    int age = (int) pmysql.getValue(resultSet, "id");
    ```

  - 获取所有

    ```java
    ResultSet resultSet = pmysql.executeQuery("SELECT * FROM `apee_test`");
    while (pmysql.result.next(resultSet)) {
        String string = (String) pmysql.getValue(resultSet, "title");
        System.out.println(string);
    }
    ```

    ```java
    ResultSet resultSet = pmysql.executeQuery("SELECT * FROM `apee_test`");
    while (pmysql.result.next(resultSet)) {
        int id = (int) pmysql.getValue(resultSet, "id");
        System.out.println(id);
    }
    ```

## Jar 包制作流程

```bash
# 编译代码
javac -d . "top/apee/PMysql/PMysql.java"
# 生成 jar 文件
jar -cvf PMysql.jar "top/apee/PMysql"
```