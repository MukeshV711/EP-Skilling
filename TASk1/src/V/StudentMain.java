package V;

import java.sql.SQLException;
import java.util.Scanner;

import StudentBean.StudentBean;
import Muk.StudentInsertion;

public class StudentMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		StudentBean sb=new StudentBean();
		StudentInsertion si=new StudentInsertion();
		int ch;
		while(true)
		{
			System.out.println("Please Select the Operation You Want to do on the DATABASE\n1.Insert into DATABASE\n2.Delete from DATABASE\n3.Update Database\n4.Retrive the Database\n5.Exit\nEnter Your Option here :");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the Register Number of the Student:");
				sb.setRegno(sc.nextLong());
				System.out.println("Enter the Name of the Student:");
				sb.setName(sc.next());
				System.out.println("Enter the Email Address of the Student:");
				sb.setEmail(sc.next());
				int i=si.StudentInsert(sb);
				if(i>0)
				{
					System.out.println("Insertion Successfull");
				}
				else
				{
					System.out.println("Insertion Failure");
				}
				break;
			case 2:
				System.out.println("Enter the Student Id You want to delete");
				String id=sc.next();
				i=si.StudentDelete(sb,id);
				if(i>0)
				{
					System.out.println("Deletion Successfull");
				}
				else
				{
					System.out.println("Deletion Failure");
				}
				break;
			case 3:
				System.out.println("Enter the Student ID to update the Student Details:");
				long id1=sc.nextLong();
				System.out.println("Enter the field you want to update:\n1.Name\n2.ID Number\n3.Email\nEnter your Choice:");
				int cho=sc.nextInt();
				switch(cho)
				{
				case 1:
					System.out.println("Enter the New Name you want to update : ");
					i=si.StudentUpdate(1, sc.next(), id1);
					if(i>0)
					{
						System.out.println("Updation Successfull");
					}
					else
					{
						System.out.println("Updation Failure");
					}
					break;
				case 2:
					System.out.println("Enter the New ID NUMBER you want to update : ");
					i=si.StudentUpdate(2, sc.next(), id1);
					if(i>0)
					{
						System.out.println("Updation Successfull");
					}
					else
					{
						System.out.println("Updation Failure");
					}
					break;
				case 3:
					System.out.println("Enter the New Email you want to update : ");
					i=si.StudentUpdate(3, sc.next(), id1);
					if(i>0)
					{
						System.out.println("Updation Successfull");
					}
					else
					{
						System.out.println("Updation Failure");
					}
					break;
				}
				break;
			case 4:
				si.Retrive();
				break;
			case 5:
				System.exit(0);
			}

		}
	}
		
		
}