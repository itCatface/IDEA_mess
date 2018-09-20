package design_pattern.creational.p4_factory_method.ability.imp;

import design_pattern.creational.p4_factory_method.ability.IAction;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class Cat implements IAction {
    @Override
    public void eat() {
        System.out.println(getClass().getSimpleName() + " -->eating...");
    }
}
