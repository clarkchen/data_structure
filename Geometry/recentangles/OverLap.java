package recentangles;

public class OverLap {
	
	
	 private int min(int a,int b)
	 {
		 return a>b?b:a;
	 }
	 private int max(int a,int b)
	 {
		 return a>b?a:b;
	 }
	 
	 public int getOverLap(int K, int L, int M, int N, int P, int Q, int R, int S)
	 {
		 int w = this.min(M, R) - this.max(K,  P);
		 
		 int h  = this.min(N,S) - this.max(L, Q);
		 
		 return w*h;
	 }
	 private int getArea(int K, int L, int M, int N)
	 {
		 int h = N-L;
		 int w = M-K;
		 if(w<0 || h<0) return -1;
		 if(Integer.MAX_VALUE/w <h) return -1;
		 return w*h;
		 
	 }
	 
	 public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
		 int a1 = this.getArea(K, L, M, N);
		 int a2 = this.getArea(P, Q, R, S);
		 if(a1==-1 || a2==-1) return -1;
		 
		 if (Integer.MAX_VALUE - a1 < a2) return -1;
		 int sum =  a1+a2;
		 int I = this.getOverLap(K, L, M, N, P, Q, R, S);
		 return sum - I;
	 }
	 public static void main(String [] args)
	 {
		 OverLap s = new OverLap();
		 int K, L, M, N, P, Q, R, S;
		 K =L= 0;  M = N =10;
		 P = -5;Q=2;R =3;S=6;
		 int r = s.solution(K, L, M, N, P, Q, R, S);
		 System.out.println(r);
	 }
	
}
