package design_pattern.creational.p3_builder.builder;

import design_pattern.creational.p3_builder.bean.Person;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public interface PersonBuilder {

    void buildHead();

    void buildBody();

    void buildFoot();

    Person buildPerson();

}
