package design_pattern.creational.p4_factory_method.creator.imp;

import design_pattern.creational.p4_factory_method.ability.IAction;
import design_pattern.creational.p4_factory_method.ability.imp.Cat;
import design_pattern.creational.p4_factory_method.creator.IActionFactory;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class CatFactory implements IActionFactory {
    @Override
    public IAction getAction() {
        return new Cat();
    }
}
