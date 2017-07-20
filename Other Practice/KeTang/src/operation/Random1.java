package operation;

import java.util.Random;

class Random1 {
	int setRandom(int min,int max){
		Random ran=new Random();
		int r=ran.nextInt(max-min+1)+min;
		return r;
	}
	int setRandom0(int num){
		Random ran=new Random();
		int r=ran.nextInt(num);
		return r;
	}
}