package cc.catface.mds.dao;

import cc.catface.mds.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Repository
public interface IPersonDao {

    void addPerson(Person person);

    void deletePerson(String username);

    void updatePerson(Person person);

    List<Person> getAllPerson();

}
