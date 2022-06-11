import java.util.*;  
class Factorial
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number whose factorial is to be calculated:");
		int number = sc.nextInt();
		int result = 1;
		if(number == 0)
		{
			result = 1;
		}
		else
		{
			for(int i=number; i>0; i--)
			{
				result = i*result;
			}
		}
		System.out.println("Factorial of " +number+ " is " +result);

	} 

}