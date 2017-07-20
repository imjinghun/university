package oracle.demo.oow.bd.dao.hbase;

import java.util.List;

import org.junit.Test;

import oracle.demo.oow.bd.to.GenreTO;
//import oracle.demo.oow.bd.dao.GenreDAO;
import oracle.demo.oow.bd.dao.ActivityDAO;
//import oracle.demo.oow.bd.dao.CustomerDAO;;
public class junittest {

	@Test
	public void test(){
		GenreDAO dao=new GenreDAO();
		List<GenreTO> a=dao.getGenres();
		System.out.println(a);
	}
	@Test
	public void test1(){
		ActivityDAO dao=new ActivityDAO();
		System.out.println(dao.getCustomerCurrentWatchList(1255601));
	}
	@Test
	public void test2(){
		CustomerDAO dao=new CustomerDAO();
		//System.out.println(dao.getMovieRating(1255601, movieId));
	}
	@Test
	public void test3(){
		MovieDAO dao=new MovieDAO();
		System.out.println(dao.getGenreBymovieId(10644));
	}
	@Test
	public void test4(){
		CustomerRatingDAO dao=new CustomerRatingDAO();
		//dao.insertCustomerRating(1255601,10644,2);
	}
}
