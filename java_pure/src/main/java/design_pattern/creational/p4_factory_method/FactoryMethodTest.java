package design_pattern.creational.p4_factory_method;

import design_pattern.creational.p4_factory_method.creator.IActionFactory;
import design_pattern.creational.p4_factory_method.creator.imp.CatFactory;
import design_pattern.creational.p4_factory_method.creator.imp.DogFactory;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        IActionFactory catFactory = new CatFactory();
        IActionFactory dogFactory = new DogFactory();

        catFactory.getAction().eat();
        dogFactory.getAction().eat();
    }

}
