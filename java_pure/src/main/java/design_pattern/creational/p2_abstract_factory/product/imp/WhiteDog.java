package design_pattern.creational.p2_abstract_factory.product.imp;

import design_pattern.creational.p2_abstract_factory.product.IDog;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class WhiteDog implements IDog {
    @Override
    public void drink() {
        System.out.println("white dog is drinking...");
    }
}
