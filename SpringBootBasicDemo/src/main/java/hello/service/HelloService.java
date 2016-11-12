package hello.service;

import hello.config.Loggable;
import hello.exception.CustomException;
import hello.exception.MaxAgeException;
import hello.exception.MinAgeException;
import hello.modal.Person;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	@Loggable
	org.slf4j.Logger LOGGER;

	public Person getPerson(String ages) {
		Person person = null;
		try {
			int age = Integer.parseInt(ages);
			if (age > 100) {
				throw new MaxAgeException("Age should not greater that 100");
			}
			if (age < 0) {
				throw new MinAgeException("Age should not LESS that that 0");
			}
			person = new Person();
			person.setName("person");
			person.setAge(age);
		}

		catch (MaxAgeException e) {
			LOGGER.warn("you enter the maximum age wihich can not process"+e.getMessage());

			throw new MaxAgeException("Age should not greater that 100");
		} catch (MinAgeException e) {
			LOGGER.warn("you enter the min age wihich can not process"+e.getMessage());

			throw new MinAgeException("Age should not LESS that that 0");
		} catch (Exception e) {
			LOGGER.warn("some thing went wrong in the application");
			throw new CustomException(
					"SOme thing went wron internally try after some time...."+e.getMessage());

		}
		return person;
	}

}
