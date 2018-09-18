package cc.catface.mds.service.imp;

import cc.catface.mds.dao.IPersonDao;
import cc.catface.mds.model.Person;
import cc.catface.mds.service.IPersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Service("personService")
@Transactional(rollbackFor = Exception.class)
public class PersonServiceImp implements IPersonService {


    @Resource
    private IPersonDao personDao;


    @Override
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    public void deletePerson(String username) {
        personDao.deletePerson(username);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return personDao.getAllPerson();
    }
}
