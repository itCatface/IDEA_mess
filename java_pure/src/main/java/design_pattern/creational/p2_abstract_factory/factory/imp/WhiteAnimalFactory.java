package design_pattern.creational.p2_abstract_factory.factory.imp;

import design_pattern.creational.p2_abstract_factory.factory.IAnimalFactory;
import design_pattern.creational.p2_abstract_factory.product.ICat;
import design_pattern.creational.p2_abstract_factory.product.IDog;
import design_pattern.creational.p2_abstract_factory.product.imp.WhiteCat;
import design_pattern.creational.p2_abstract_factory.product.imp.WhiteDog;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class WhiteAnimalFactory implements IAnimalFactory {
    @Override
    public ICat createCat() {
        return new WhiteCat();
    }

    @Override
    public IDog createDog() {
        return new WhiteDog();
    }
}
