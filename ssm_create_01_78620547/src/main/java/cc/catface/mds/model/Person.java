package cc.catface.mds.model;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Person {
    private int id;
    private String username = "";
    private String user_phone = "";

    /* org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.executor.ExecutorException: No constructor found in cc.catface.mds.model.User matching [java.lang.Integer, java.lang.String, java.lang.String] */
    // 解决办法是添加一个默认的空构造函数
    public Person() {
    }

    public Person(String username, String user_phone) {
        this.username = username;
        this.user_phone = user_phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
