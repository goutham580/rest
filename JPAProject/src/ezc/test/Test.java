package ezc.test;

public class Test {

	public static void main(String[] args) {
		int [] a = {1235,4567,3213};
		int [] m = {2345,3231,2345};

		for(int i=0;i<a.length;i++)
		{
			int moves = 0;
			System.out.println(a[i]);
			System.out.println(m[i]);
			while(a[i]>0)
			{
				int tempA = a[i]/10;
				int curA = a[i]-tempA*10;
				a[i]=tempA;	
				int tempM = m[i]/10;
				int curM = m[i]-tempM*10;
				m[i]=tempM;
				while(curA != curM)
				{
					moves++;
					if(curA > curM)
						curA--;
					else if(curA < curM)
						curA++;
				}
				
				//System.out.println(curA);
			}
			System.out.println(moves);
		}

	}

}
