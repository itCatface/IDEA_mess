package cc.catface.sb_create_01.mds.pojo;

import javax.persistence.*;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Entity
@Table(name = "category_")  // 该类对应表名
public class Category {

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长
    @Column(name = "id")    // 对应数据库中字段名
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
