package com.example.demo.web;

import com.example.demo.dao.PersonRepository;
import com.example.demo.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
@RestController
@RequestMapping("/person")
public class PersonControl {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Person> findAll(){
        return personRepository.findAll();
    }
}
