//Assignment 8

//This exception will be thrown if age is below 18.

import java.util.Scanner;

// UnderAgeException will be thrown if age < 18
class UnderAgeException extends ExceptionTest
{
	
}

// This exception will be thrown if name contains digits.
class InvalidNameException extends ExceptionTest
{
	
}

//User id should only contain digits.
//If user id contain alphabet this exception will be thrown.
class InvalidUserIdException extends ExceptionTest
{
	
}

class ExceptionTest extends Exception
{
	
}
class CheckForException
{
	void checkForException(int age, String name, String id) throws ExceptionTest
	{
		char ch;
		if(name.equals("null"))
			id = null;
		if(age < 18)
			throw new UnderAgeException();
	
		for(int i = 0; i < name.length(); i++)
		{
			ch = name.charAt(i);
			if(Character.isDigit(ch))
				throw new InvalidNameException();
		}
	
		for(int i = 0; i < id.length(); i++)
		{
			ch = id.charAt(i);
			if(Character.isLetter(ch))
				throw new InvalidUserIdException();
		}
	}
	
} 

public class ExceptionMain
{
	public static void main(String[] a) throws Exception
	{
		String name;
		int age;
		String id;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name");
		name = sc.nextLine();
		
		System.out.println("Enter age");
		age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter user id");
		id = sc.nextLine();
		
		CheckForException excp = new CheckForException();
		
		/* When null entered as a name
		I am deliberately passing it to checkName()
		to show finally block will always be executed */
		try
		{
			excp.checkForException(age,name,id);
		}
		catch(ExceptionTest e)
		{
			if(e instanceof InvalidNameException)
			{
				System.out.println("InvalidNameException : Name is invalid");
			}
			else if(e instanceof InvalidUserIdException)
			{
				System.out.println("InvalidUserIdException: User id is invalid");
			}
			else
			{
				System.out.println("UnderAgeException : You are still a minor");
			}
		}
		finally
		{
			sc.close();
			System.out.println("Finnally block is always executed");
		}
	}
}