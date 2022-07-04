package study;

import java.util.Scanner;

//����ö�� ������
public class b_1393 {

	static int bx, by;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//������ ��ġ
		bx = sc.nextInt();
		by = sc.nextInt();
		
		//���� ���� ��ġ
		int curX = sc.nextInt();
		int curY = sc.nextInt();
		int dx = sc.nextInt();
		int dy = sc.nextInt();
		
		int curDist = distance(curX, curY);

		int gcd = gcd(dx, dy);
		dx /= gcd;
		dy /= gcd;
		System.out.println("�ִ�����: " + gcd);
		
		while(true) {
			curX += dx;
			curY += dy;
			
			System.out.println("���� �̵��� ��ǥ:" + curX + "," + curY);
			int temp = distance(curX, curY);
			if(temp > curDist){
				curX -= dx;
				curY -= dy;
				break;
			}
			else
				curDist = temp;
		}
		
		System.out.println(curX + " " + curY);
		sc.close();
	}
	
	public static int distance(int ax, int ay) {
		int t1 = Math.abs(ax - bx);
		int t2 = Math.abs(ay - by);
		
		return (t1*t1) + (t2*t2);
	}
	
	public static int gcd(int n1, int n2) {
		if(n2 == 0)
			return n1;
		
		return gcd(n2, n1 % n2);
	}

}
