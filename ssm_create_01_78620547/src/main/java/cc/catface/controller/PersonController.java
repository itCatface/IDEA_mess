package cc.catface.controller;

import cc.catface.mds.model.Person;
import cc.catface.mds.service.IPersonService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
@RequestMapping(produces = "application/json; charset=utf-8")
public class PersonController {

    @Resource
    private IPersonService personService;

    // @Validated注解-->自动匹配入参创建User对象
    @RequestMapping("/addPerson")
    @ResponseBody
    public String addPerson(@Validated Person person) {
        personService.addPerson(person);
        return getAllPerson();
    }

    @RequestMapping("/deletePerson")
    @ResponseBody
    public String deletePerson(@RequestParam("username") String username) {
        personService.deletePerson(username);
        return getAllPerson();
    }

    @RequestMapping("/updatePerson")
    @ResponseBody
    public String updatePerson(@Validated Person person) {
        personService.updatePerson(person);
        return getAllPerson();
    }

    @RequestMapping("/getAllPerson")
    @ResponseBody
    public String getAllPerson() {
        List<Person> userList = personService.getAllPerson();
        return JSON.toJSONString(userList);
    }
}
