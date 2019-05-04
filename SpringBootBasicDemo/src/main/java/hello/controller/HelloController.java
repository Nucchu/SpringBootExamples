package hello.controller;

import hello.config.PosValChk;
import hello.exception.CustomException;
import hello.modal.Person;
import hello.service.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	HelloService hserivce;
	@PosValChk
	private int posCheckValue=123;

	@RequestMapping("/")
	public String index() {
		Person person=new Person("nameeee", 111);
		System.out.println("Person Object created");
		return "Greetings from Spring Boot!"+person.toString();
	}

	@RequestMapping("/getPerson")
	@ResponseBody
	public Person getPerson(@RequestParam("age") String age) throws Exception {
		Person p = null;
		 System.out.println(posCheckValue);
			p = hserivce.getPerson(age);
		 
		return p;
	}
}
