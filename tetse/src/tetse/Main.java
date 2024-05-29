package tetse;

public class Main {

	public static void main(String[] args) {
		
		System.out.print(calcular(5));
	};
	public static int calcular(int x) {
		while(x>0) {
			return calcular(x -1);
		}
		return x;
	}

}
