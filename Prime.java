import java.util.*;  
class Prime
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:");
		int number = sc.nextInt();
		int i;
		int result = 0;
		if(number == 0 || number == 1)
		{
			System.out.println(number+ " is not a prime number");
		}
		else
		{
			for(i = 2; i < number; i++)
			{
				if(number % i == 0)
				{
					result++;
				}
			}
			
			if(result == 0)
			{
				System.out.println(number+ " is a prime number");
			}
			else
			{
				System.out.println(number+ " is not a prime number");
			}
		}
	}
}