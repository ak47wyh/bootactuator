package com.example.demo;

import com.example.demo.dao.PersonRepository;
import com.example.demo.vo.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
@Transactional
public class DemoApplicationTests {

	@Autowired
	PersonRepository personRepository;

	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	String expectedJson;

	public void setUp()throws JsonProcessingException{
		Person person = new Person("wang",1,"shanghai");
		Person person2 = new Person("wang1",2,"beijing");
		personRepository.save(person);
		personRepository.save(person2);

		expectedJson = Obj2Json(personRepository.findAll());

		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	protected String Obj2Json(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

	@Test
	public void contextLoads() throws Exception {
		String uri = "/person";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();

		Assert.assertEquals("错误，正确的返回值为：200",200,status);

		Assert.assertEquals("错误，返回值和预期不一致！",expectedJson,content);

	}

}
