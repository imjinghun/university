package oracle.demo.oow.bd.dao.hbase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.hbase.DBUtil;


import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import com.alibaba.fastjson.JSONObject;

import oracle.demo.oow.bd.constant.Constant;
import oracle.demo.oow.bd.pojo.ActivityType;
import oracle.demo.oow.bd.pojo.BooleanType;
import oracle.demo.oow.bd.pojo.RatingType;
import oracle.demo.oow.bd.to.ActivityTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.util.hbase.ConstantsHBase;
import oracle.demo.oow.bd.util.hbase.HbaseDB;

public class CustomerRatingDAO {
	
	//插入用户对电影的评级 存入 activity表 rating列
	public void insertCustomerRating(int userId, int movieId, int rating) {
		
		ActivityTO activityTO = new ActivityTO();
        
        List<GenreTO> genreTOlist=new ArrayList<>();
		MovieDAO movieDAO=new MovieDAO();
		genreTOlist=movieDAO.getGenreBymovieId(movieId);
		ActivityDAO activityDAO=new ActivityDAO();
        for (GenreTO genreTO : genreTOlist) {
        	activityTO.setActivity(ActivityType.RATE_MOVIE);
            activityTO.setRating(RatingType.getType(rating));
            activityTO.setRecommended(BooleanType.YES);

            activityTO.setCustId(userId);
            activityTO.setMovieId(movieId);
            activityTO.setGenreId(genreTO.getId());
            activityTO.setPrice(0);
            
            String jsonTxt = activityTO.getJsonTxt();
            activityTO = new ActivityTO(jsonTxt);
            
			activityDAO.insertCustomerActivity(activityTO);
			//存入mysql 
			//insertCustomerRating1(userId, movieId, rating);
		}
	}
	
	/*
	DBUtil db=new DBUtil();
	private static Connection conn = null;

    public CustomerRatingDAO() {
        super();
        if (conn == null)
            conn =db.getConn();
    } //CustomerRatingDAO
    
	public void insertCustomerRating1(int userId, int movieId, int rating) {
        String insert = null;
        PreparedStatement stmt = null;

        insert =
                "INSERT INTO CUST_RATING (USERID, MOVIEID, RATING)  VALUES (?, ?, ?)";
        try {
            if (conn != null) {
                stmt = conn.prepareStatement(insert);
                stmt.setInt(1, userId);
                stmt.setInt(2, movieId);
                stmt.setInt(3, rating);
                stmt.execute();
                stmt.close();
                System.out.println("INFO: Customer: " + userId + " Movie: " +
                                   movieId + " rating: " + rating);
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + ":" + e.getMessage());
        }
    }
	public void deleteCustomerRating(int userId) {
        String delete = null;
        PreparedStatement stmt = null;

        delete = "DELETE FROM CUST_RATING WHERE USERID = ?";
        try {
            if (conn != null) {
                stmt = conn.prepareStatement(delete);
                stmt.setInt(1, userId);
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + ":" + e.getMessage());
        }
    }*/
	
	public List<MovieTO> getMoviesByMood(int userId) {
        List<MovieTO> movieList = null;
        /*String search = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MovieTO movieTO = null;
        MovieDAO movieDAO = new MovieDAO();
        String title = null;
        Hashtable<String, String> movieHash = new Hashtable<String, String>();

        search =
                "SELECT * FROM " + "(SELECT s.MID2 RESMOVIE,  (c.RATING * s.COR) SCORE " +
                "FROM CUST_RATING c, MOVIE_SIMILARITY s " +
                "WHERE c.MOVIEID = s.MID1 and s.MID2 != c.MOVIEID and c.USERID = ? " +
                "GROUP BY s.MID2, c.RATING * s.COR " +
                "ORDER by SCORE DESC) " + "WHERE ROWNUM <= 20";
        try {
            if (conn != null) {
                //initialize movieList only when connection is successful
                movieList = new ArrayList<MovieTO>();
                stmt = conn.prepareStatement(search);
                stmt.setInt(1, userId);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("RESMOVIE");

                    //create new object
                    movieTO = movieDAO.getMovieById(id);
                    if (movieTO != null) {
                        title = movieTO.getTitle();
                        //Make sure movie title doesn't exist before in the movieHash
                        if (!movieHash.containsKey(title)) {
                            movieHash.put(title, title);
                            movieList.add(movieTO);
                        }
                    } //if (movieTO != null)
                } //EOF while
                stmt.close();
            } //EOF if (conn!=null)
        } catch (Exception e) {
            //No Database is running, so can not recommend item-item similarity             
        }*/
        return movieList;
    }
}
