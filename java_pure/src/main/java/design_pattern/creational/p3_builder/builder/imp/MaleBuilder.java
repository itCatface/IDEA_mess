package design_pattern.creational.p3_builder.builder.imp;

import design_pattern.creational.p3_builder.bean.Person;
import design_pattern.creational.p3_builder.builder.PersonBuilder;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class MaleBuilder implements PersonBuilder {

    private Person person;

    public MaleBuilder() {
        person = new Person();
    }


    @Override
    public void buildHead() {
        person.setHead("male head building...");
    }

    @Override
    public void buildBody() {
        person.setBody("male body building...");
    }

    @Override
    public void buildFoot() {
        person.setFoot("male foot building...");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
