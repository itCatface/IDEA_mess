package design_pattern.strategy.instance;

import design_pattern.strategy.model_context.Animal;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Dog extends Animal {
    @Override
    public void doCall() {
        System.out.println(getClass().getSimpleName() + " has been called");
    }
}
