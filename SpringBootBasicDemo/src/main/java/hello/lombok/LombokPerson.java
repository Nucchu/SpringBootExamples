package hello.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Builder
public class LombokPerson {
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private int age;
	public LombokPerson(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
