import java.util.*;  
class Fibonacci
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:");
		int number = sc.nextInt();
		int i = 0;
		int j = 1;
		System.out.print("First " +number+ " numbers of fibonacci series is: ");
		System.out.print(i+" "+j);
		for(int k = 2; k < number; k++)
		{
			int result = i + j;
			System.out.print(" " +result);
			i = j;
			j = result;
		}
		
	}
}