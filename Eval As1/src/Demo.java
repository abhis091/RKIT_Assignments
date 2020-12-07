import java.util.Scanner;

public class Demo {

	public static int fact(int x) {
		if(x>1) {
			return x*fact(x-1);
		}else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==1) {
			System.out.println("11");
			return;
		}
		String s ="";
		for(int i=0;i<n;i++) {
			for(int j=0;j<fact(n);j++) {
				if(i==0) {
					s+=(j+1);
				}else if(i==n-1){
					s+="*";
				}
				
			}
				System.out.println("\n");
		}
		
		System.out.println(s+s);
	}

}
