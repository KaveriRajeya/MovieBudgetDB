package moviedao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import moviedto.Movie;

public class MovieDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("MovieBudget");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();

	
	public void fetchDetails(int id) throws IOException
	{
		Movie mo = entityManager.find(Movie.class , id);
		if(mo!=null)
		{
			System.out.println(mo.getMovieName());
			System.out.println(mo.getMovieBudget());
			System.out.println(mo.getHeroName());
			System.out.println(mo.getHeroineName());
			System.out.println(mo.getDirectorName());
			System.out.println(mo.getDate());
			System.out.println("Enter image Path");
			FileOutputStream stream=new FileOutputStream("C:\\Users\\HP-840 G4\\Desktop\\PictureHero"+ mo.getHeroPhoto()+".jpg");
			stream.write(mo.getHeroPhoto());
			System.out.println("File Uploded To Desktop Please Check It");
//			C:\Users\HP-840 G4\Desktop\PictureHero\Raj.jfif
			
		}
		else {
			System.out.println("Its Not Available");
		}
	}
	
	public void addDetails(Movie mo)
	{
		entityTransaction.begin();
		entityManager.persist(mo);
		entityTransaction.commit();
		System.out.println("Data Added Successfully");
	}
	
	public void removeDetails(int id)
	{
		Movie movie=entityManager.find(Movie.class, id);
		if(movie!=null)
		{
			entityTransaction.begin();
			entityManager.remove(movie);
			entityTransaction.commit();
			System.out.println("Data Deleted Successfully");
		}
		else {
			System.out.println("Id Not Available");
		}
		
	}
	
	public void fetchAll() throws IOException
	{
		Query query=entityManager.createQuery("select a from Movie a");
		List<Movie> mo = query.getResultList();
		for(Movie e : mo)
		{
			if(mo.isEmpty())
			{
			System.out.println("Sorry Data Not Available");
			}
			else {
				System.out.println(e.getId());
				System.out.println(e.getHeroName());
				System.out.println(e.getHeroineName());
				System.out.println(e.getMovieName());
				System.out.println(e.getMovieBudget());
				System.out.println(e.getDirectorName());
				System.out.println(e.getDate());
				FileOutputStream outputStream=new FileOutputStream("C:\\Users\\HP-840 G4\\Desktop\\PictureHero\\"+e.getHeroPhoto()+ ".jpeg");
				outputStream.write(e.getHeroPhoto());
				System.out.println("File Uploded To Desktop Please Check It");
			}
		}	
	}
	
	
	public void updateMovieName(int id,String newName)
	{
		Movie mo=entityManager.find(Movie.class, id);
		if(mo!=null)
		{
			mo.setMovieName(newName);
			entityTransaction.begin();
			entityManager.merge(mo);
			entityTransaction.commit();
			System.out.println("Movie Name Updated Successfully");
		}
	}
	
	public void updateHeroName(int id, String newName1) {
		Movie mo=entityManager.find(Movie.class, id);
		if(mo!=null)
		{
			mo.setHeroName(newName1);
			entityTransaction.begin();
			entityManager.merge(mo);
			entityTransaction.commit();
			System.out.println("Hero Name Updated Successfully");
		}
	}
	
	public void updateHeroineName(int id, String newName2) {
		Movie mo=entityManager.find(Movie.class, id);
		if(mo!=null)
		{
			mo.setHeroineName(newName2);
			entityTransaction.begin();
			entityManager.merge(mo);
			entityTransaction.commit();
			System.out.println("Hero Name Updated Successfully");
		}
	}
	
	public void updateDirectorName(int id, String newName3) {
		Movie mo=entityManager.find(Movie.class, id);
		if(mo!=null)
		{
			mo.setDirectorName(newName3);
			entityTransaction.begin();
			entityManager.merge(mo);
			entityTransaction.commit();
			System.out.println("Hero Name Updated Successfully");
		}
	}
	
	public void updateMovieBudget(int id, double movieBudget) {
		Movie mo=entityManager.find(Movie.class, id);
		if(mo!=null)
		{
			mo.setMovieBudget(movieBudget);
			entityTransaction.begin();
			entityManager.merge(mo);
			entityTransaction.commit();
			System.out.println("Hero Name Updated Successfully");
		}
	}
}
