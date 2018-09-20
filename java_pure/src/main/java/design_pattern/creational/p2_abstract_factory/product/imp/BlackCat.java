package design_pattern.creational.p2_abstract_factory.product.imp;

import design_pattern.creational.p2_abstract_factory.product.ICat;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class BlackCat implements ICat {
    @Override
    public void eat() {
        System.out.println("black cat is eating...");
    }
}
