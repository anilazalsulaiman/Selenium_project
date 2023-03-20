package revising_java;

public class SecondInterfaceClass implements Firstinterface{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Firstinterface obj2=new SecondInterfaceClass();
		obj2.firstMethod();
		obj2.secondMethod();
		

	}

	public void firstMethod() {
		// TODO Auto-generated method stub
		System.out.println("Frst method");
	}

	public void secondMethod() {
		// TODO Auto-generated method stub
		System.out.println("Second method");
		
	}
}
