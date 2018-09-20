package design_pattern.creational.p5_prototype;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class PrototypeTest {

    public static void main(String[] args) {
        Prototype prototype1 = new ConcretePrototype("pro1");
        Prototype prototype2 = (Prototype) prototype1.clone();

        System.out.println(prototype1.getName() + " || " + prototype2.getName());
    }

}
