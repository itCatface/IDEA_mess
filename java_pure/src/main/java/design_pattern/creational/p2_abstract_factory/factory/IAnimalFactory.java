package design_pattern.creational.p2_abstract_factory.factory;

import design_pattern.creational.p2_abstract_factory.product.ICat;
import design_pattern.creational.p2_abstract_factory.product.IDog;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public interface IAnimalFactory {

    ICat createCat();

    IDog createDog();

}
