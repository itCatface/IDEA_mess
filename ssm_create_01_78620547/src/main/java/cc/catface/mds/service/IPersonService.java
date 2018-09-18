package cc.catface.mds.service;

import cc.catface.mds.model.Person;

import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public interface IPersonService {

    void addPerson(Person person);

    void deletePerson(String username);

    void updatePerson(Person person);

    List<Person> getAllPerson();
}
