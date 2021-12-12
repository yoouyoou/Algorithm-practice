package b_combination;

import java.math.BigInteger;
import java.util.Scanner;

//조합 (실버3)
public class b_2407 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int t;

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;
        BigInteger answer;
        
        if(n == m)
            answer = BigInteger.ONE;
        else if(m == 1)
            answer = new BigInteger(String.valueOf(n));
        else{
            if(m > (n/2))
                m = n-m;
            t = m;
            for (int i = 0; i < t; i++) {
                n1 = n1.multiply(new BigInteger(String.valueOf(n--)));
                n2 = n2.multiply(new BigInteger(String.valueOf(m--)));
            }
            answer = n1.divide(n2);
        }
        
        System.out.println(answer);
	}

}
