package design_pattern.creational.p3_builder.director;

import design_pattern.creational.p3_builder.bean.Person;
import design_pattern.creational.p3_builder.builder.PersonBuilder;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class PersonDirector {

    public Person constructPerson(PersonBuilder builder) {
        builder.buildHead();
        builder.buildBody();
        builder.buildFoot();
        return builder.buildPerson();
    }

}
