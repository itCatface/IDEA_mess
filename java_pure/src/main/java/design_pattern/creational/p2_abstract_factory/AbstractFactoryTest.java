package design_pattern.creational.p2_abstract_factory;

import design_pattern.creational.p2_abstract_factory.factory.imp.BlackAnimalFactory;
import design_pattern.creational.p2_abstract_factory.factory.imp.WhiteAnimalFactory;
import design_pattern.creational.p2_abstract_factory.product.ICat;
import design_pattern.creational.p2_abstract_factory.product.IDog;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925

 @desc 不太好用 */

public class AbstractFactoryTest {

    public static void main(String[] args) {
        WhiteAnimalFactory whiteAnimalFactory = new WhiteAnimalFactory();
        ICat whiteCat = whiteAnimalFactory.createCat();
        IDog whiteDog = whiteAnimalFactory.createDog();

        BlackAnimalFactory blackAnimalFactory = new BlackAnimalFactory();
        ICat blackCat = blackAnimalFactory.createCat();
        IDog blackDog = blackAnimalFactory.createDog();

        whiteCat.eat();
        whiteDog.drink();
        blackCat.eat();
        blackDog.drink();
    }

}
