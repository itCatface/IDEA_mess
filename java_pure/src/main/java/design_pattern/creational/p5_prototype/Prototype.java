package design_pattern.creational.p5_prototype;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Prototype implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
