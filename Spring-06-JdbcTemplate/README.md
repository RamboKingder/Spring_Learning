### 学习Spring JdbcTemplate的使用
对应黑马SSM视频教程的P80-P89
使用前需要在自己的数据库中建立好JdbcTemplateTest数据库和account表：
```sql
CREATE DATABASE JdbcTemplateTest;
USE JdbcTemplateTest;
CREATE TABLE `account`(
	`name` VARCHAR(10),
	money DOUBLE
);
```

