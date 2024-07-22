package moviecontroller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import moviedao.MovieDao;
import moviedto.Movie;

public class MovieController {

	public static void main(String[] args) throws IOException {
		
		MovieDao movieDao=new MovieDao();
		Scanner sc=new Scanner(System.in);
		
		boolean flag=true;
		while(flag)
		{
			System.out.println("1.Fetch The Details");
			System.out.println("2.Add The Details");
			System.out.println("3.Remove The Movie Details");
			System.out.println("4.Fetch All The Details");
			System.out.println("5.Update Movie Details");
			System.out.println("6.Exit");
			System.out.println("Select Valid Option");
			
			switch(sc.nextInt())
			{
			case 1:
			{
				System.out.println("Enter Movie Id");
				movieDao.fetchDetails(sc.nextInt());
			}break;
			
			case 2:
			{
				Movie m= new Movie();
				
				System.out.println("Enter Movie Name");
				m.setMovieName(sc.next());
				Scanner scanner1=new Scanner(System.in);
				
				System.out.println("Enter Hero Name");
				m.setHeroName(sc.next());
				Scanner scanner2=new Scanner(System.in);
				
				System.out.println("Enter Heroine Name");
				m.setHeroineName(sc.next());
				Scanner scanner3=new Scanner(System.in);
				
				System.out.println("Enter Movie Budget");
				m.setMovieBudget(sc.nextDouble());
				Scanner scanner5=new Scanner(System.in);
				
				System.out.println("Enter Director Name");
				m.setDirectorName(sc.next());
				Scanner scanner6=new Scanner(System.in);
				
				System.out.println("Enter Movie Release Date");
				Date date=new Date(sc.next());
				m.setDate(date);
				
				System.out.println("Enter Image Path");
				Scanner scanner=new Scanner(System.in);
				FileInputStream inputStream=new FileInputStream(scanner.nextLine());
				byte[] array=new byte[inputStream.available()];
				inputStream.read(array);
				m.setHeroPhoto(array);
				
				movieDao.addDetails(m);
				
				System.out.println("All Details Entered Successfully");
				
			}break;
			
			case 3:
			{
				System.out.println("Enter Id");
				movieDao.removeDetails(sc.nextInt());
				
			}break;
			
			case 4:
			{
				movieDao.fetchAll();
				System.out.println("Data Displayed Successfully");
				
			}break;
			
			case 5:
			{
				System.out.println("Enter id");
				int id=sc.nextInt();
				System.out.println("Enter Movie Name");
				String newName=sc.next();
				System.out.println("Enter Hero Name");
				String newName1=sc.next();
				System.out.println("Enter Heroine Name");
				String newName2=sc.next();
				System.out.println("Enter Director Name");
				String newName3=sc.next();
				System.out.println("Enter Movie Budget");
				double movieBudget=sc.nextDouble();
				
				movieDao.updateMovieName(id, newName);
				movieDao.updateHeroName(id, newName1);
				movieDao.updateHeroineName(id, newName2);
				movieDao.updateDirectorName(id, newName3);
				movieDao.updateMovieBudget(id, movieBudget);
				
				
				
			}break;
			
			case 6:
			{
				flag=false;
				System.out.println("Thank You");
			}break;
			
			default:
			{
				System.out.println("Please Provide Correct Information");
			}
			
		}
		
		
	}
	}
}
