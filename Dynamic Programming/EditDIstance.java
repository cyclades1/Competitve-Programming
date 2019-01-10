package Algo;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
 
class EditDIstance {
	public static void main(String[] args) throws java.lang.Exception{
		InputStream inputstream = System.in;
		OutputStream outputstream = System.out;
		InputReader in = new InputReader(inputstream);
		PrintWriter out = new PrintWriter(outputstream);
		Call one = new Call();
		one.solve(in,out);
		out.close();
	}
	static class Call {
		int dp[][];
		public void solve(InputReader in,PrintWriter out) {	
			int t = in.nextInt();
			while(t-->0) {
				String one = in.next();
				String two = in.next();
				out.println(res(one,two));
			}
		}
		public int res(String s1,String s2) {
			int n = s1.length();
			int m = s2.length();
			dp=new int [n+1][m+1];
			for(int i=0;i<=n;i++) {
				for(int j=0;j<=m;j++) {
					if(i==0)dp[i][j]=j;
					else if(j==0)dp[i][j]=i;
					else if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=dp[i-1][j-1];
					else dp[i][j]=1+(Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]));
				}
			}
			return dp[n][m];
		}
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader (stream),32768);
			tokenizer = null;
		}
		public String next() {
				while(tokenizer == null || !tokenizer.hasMoreElements()) {
					try {
						tokenizer = new StringTokenizer(reader.readLine());
					}
					catch(IOException e) {
						throw new RuntimeException(e);
					}
				}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
	
}
 
