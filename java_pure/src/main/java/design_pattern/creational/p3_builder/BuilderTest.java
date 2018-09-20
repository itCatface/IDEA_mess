package design_pattern.creational.p3_builder;

import design_pattern.creational.p3_builder.bean.Person;
import design_pattern.creational.p3_builder.builder.imp.MaleBuilder;
import design_pattern.creational.p3_builder.director.PersonDirector;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925

 @desc 将复杂对象的构建与其表示分离 */

public class BuilderTest {

    public static void main(String[] args) {
        PersonDirector director = new PersonDirector();
        Person person = director.constructPerson(new MaleBuilder());
        System.out.println(person.toString());
    }

}
