package design_pattern.creational.p2_abstract_factory.factory.imp;

import design_pattern.creational.p2_abstract_factory.factory.IAnimalFactory;
import design_pattern.creational.p2_abstract_factory.product.ICat;
import design_pattern.creational.p2_abstract_factory.product.IDog;
import design_pattern.creational.p2_abstract_factory.product.imp.BlackCat;
import design_pattern.creational.p2_abstract_factory.product.imp.BlackDog;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class BlackAnimalFactory implements IAnimalFactory {
    @Override
    public ICat createCat() {
        return new BlackCat();
    }

    @Override
    public IDog createDog() {
        return new BlackDog();
    }
}
