package betaben.tests;

public class Main {

	public static void main(String[] args) {
		
		f(4,2);

	}

	public static void f(int a, int b){
		if (a/b != 0){
			f(a/b,b);
		}
		System.out.println(a % b);
	}
	
}
