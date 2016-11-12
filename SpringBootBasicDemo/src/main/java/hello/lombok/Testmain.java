package hello.lombok;

public class Testmain {

	public static void main(String[] args) {
		LombokPerson lombokPerson = new LombokPerson("NME", 33);
//		System.out.println(lombokPerson.toString());
		System.out.println(lombokPerson.getAge());

	}

}
