package design_pattern.strategy;

import design_pattern.strategy.instance.Cat;
import design_pattern.strategy.instance.Dog;
import design_pattern.strategy.instance.Tiger;
import design_pattern.strategy.model_context.AnimalAgency;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class TestStrategy {

    public static void main(String[] args) {
        AnimalAgency dog = new AnimalAgency(new Dog());
        AnimalAgency cat = new AnimalAgency(new Cat());
        AnimalAgency tiger = new AnimalAgency(new Tiger());

        dog.call();
        cat.call();
        tiger.call();
    }
}
