package oracle.demo.oow.bd.dao.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;

import oracle.demo.oow.bd.to.CastCrewTO;
import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.CrewTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.hbase.ConstantsHBase;
import oracle.demo.oow.bd.util.hbase.HbaseDB;

public class MovieDAO {

	//在 movie表movie列族、genre列族，genre表导入数据
	public void insertMovie(MovieTO movieTO) {
        HbaseDB db=HbaseDB.getInstance();
        //movie表  genre表
        Table table_movie=db.getTable(ConstantsHBase.TABLE_MOVIE);
        Table table_genre=db.getTable(ConstantsHBase.TABLE_GENRE);
        
        //movie表  movie列族  行键movieid
        Put put_movie=new Put(Bytes.toBytes(movieTO.getId()));
        put_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_ORIGINAL_TITLE), Bytes.toBytes(movieTO.getTitle()));
        put_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_OVERVIEW), Bytes.toBytes(movieTO.getOverview()));
        put_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_POSTER_PATH), Bytes.toBytes(movieTO.getPosterPath()));
        put_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_POPULARITY), Bytes.toBytes(movieTO.getPopularity()));
        put_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_RUNTIME), Bytes.toBytes(movieTO.getRunTime()));
        put_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_VOTE_COUNT), Bytes.toBytes(movieTO.getVoteCount()));
        put_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_RELEASE_DATE), Bytes.toBytes(movieTO.getDate()));
        
        ArrayList<GenreTO> genreTOList=movieTO.getGenres();
        List<Put> putgenre = new ArrayList<>();
        List<Put> putmoviegenre=new ArrayList<>();
        List<Put> putgenremovie=new ArrayList<>();
        for (GenreTO genreTO : genreTOList) {
        	//movie表 genre列族  行键 movieid_genreid
        	Put put_movie_genre=new Put(Bytes.toBytes(movieTO.getId()+"_"+genreTO.getId()));
        	put_movie_genre.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_GENRE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_GENRE_ID), Bytes.toBytes(genreTO.getId()));
        	put_movie_genre.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_GENRE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_GENRE_NAME), Bytes.toBytes(genreTO.getName()));
        
        	putmoviegenre.add(put_movie_genre);
        	
        	//genre表  genre列族 行键genreid
        	Put put_genre=new Put(Bytes.toBytes(genreTO.getId()));
        	put_genre.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_GENRE_GENRE),Bytes.toBytes(ConstantsHBase.QUALIFIER_GENRE_NAME), Bytes.toBytes(genreTO.getName()));
        	putgenre.add(put_genre);
        	
        	//genre表  movie列族 行键 genreid_movieid
        	Put put_genre_movie=new Put(Bytes.toBytes(genreTO.getId()+"_"+movieTO.getId()));
        	put_genre_movie.addColumn(Bytes.toBytes(ConstantsHBase.FAMILY_GENRE_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_GENRE_MOVIE_ID), Bytes.toBytes(movieTO.getId()));
        	putgenremovie.add(put_genre_movie);
        }
        try {
        	table_movie.put(put_movie);
        	table_movie.put(putmoviegenre);
        	table_genre.put(putgenre);
        	table_genre.put(putgenremovie);
        	
        	table_movie.close();
        	table_genre.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	//通过movieId获取movie信息
	public MovieTO getMovieById(int movieId) {

		HbaseDB db=HbaseDB.getInstance();
		Table table = db.getTable(ConstantsHBase.TABLE_MOVIE);
		//根据movieId获取movie信息
		Get get=new Get(Bytes.toBytes(movieId));
		Result result2=null;
		MovieTO movieTO=new MovieTO();
		try {
			result2 = table.get(get);
			movieTO.setId(movieId);
			movieTO.setTitle(Bytes.toString(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_ORIGINAL_TITLE))));
			movieTO.setPosterPath(Bytes.toString(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_POSTER_PATH))));
			movieTO.setOverview(Bytes.toString(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_OVERVIEW))));
			movieTO.setRunTime(Bytes.toInt(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE),Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_RUNTIME))));
			movieTO.setDate(Bytes.toString(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_RELEASE_DATE))));
			movieTO.setVoteCount(Bytes.toInt(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_VOTE_COUNT))));
			movieTO.setPopularity(Bytes.toDouble(result2.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_MOVIE), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_POPULARITY))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return movieTO;
	}

	//通过movieId获取 genreTO 集合
	public List<GenreTO> getGenreBymovieId(int movieId) {
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_MOVIE);
		
		 // 根据前缀过滤器获取 movie_ 
		Filter filter = new PrefixFilter(Bytes.toBytes(movieId+"_"));
		Scan scan=new Scan();
		scan.setFilter(filter);
		//设置genre列族
		scan.addFamily(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_GENRE));
		
		ResultScanner resultScanner=null;
		try {
			resultScanner=table.getScanner(scan);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GenreTO genreTO=new GenreTO();
		List<GenreTO> genreTOlist=new ArrayList<>();
		if(resultScanner!=null){
			for (Result result : resultScanner) {
				genreTO.setId(Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_GENRE), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_GENRE_ID))));
				genreTO.setName(Bytes.toString(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_GENRE), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_GENRE_NAME))));
				genreTOlist.add(genreTO);
			}
		}
		return genreTOlist;
	} 
	
	//通过movieId获取 castTO 集合
	private List<CastTO> getCastsByMovieId(int movieId) {
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_MOVIE);
		
		//根据前缀过滤器获取 movie_ 
		Filter filter = new PrefixFilter(Bytes.toBytes(movieId+"_"));
		Scan scan=new Scan();
		scan.setFilter(filter);
		//设置cast列族
		scan.addFamily(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_CAST));
		
		ResultScanner resultScanner=null;
		try {
			resultScanner=table.getScanner(scan);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CastTO castTO=new CastTO();
		List<CastTO> castTOlist=new ArrayList<>();
		if(resultScanner!=null){
			int castId;
			CastDAO castDAO=new CastDAO();
			for (Result result : resultScanner) {
				castId=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_CAST), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_CAST_ID)));
				//通过castId 获取cast信息
				castTO=castDAO.getCastById(castId);
				
				castTOlist.add(castTO);
			}
		}
		return castTOlist;	
	}
	
	//通过movieId获取 crewTO 集合
	private List<CrewTO> getCrewsByMovieId(int movieId) {
		HbaseDB db=HbaseDB.getInstance();
		Table table=db.getTable(ConstantsHBase.TABLE_MOVIE);
		
		//根据前缀过滤器获取 movie_ 
		Filter filter = new PrefixFilter(Bytes.toBytes(movieId+"_"));
		Scan scan=new Scan();
		scan.setFilter(filter);
		//设置crew列族
		scan.addFamily(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_CREW));
		
		ResultScanner resultScanner=null;
		try {
			resultScanner=table.getScanner(scan);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CrewTO crewTO=new CrewTO();
		List<CrewTO> crewTOlist=new ArrayList<>();
		if(resultScanner!=null){
			int crewId;
			CrewDAO crewDAO=new CrewDAO();
			for (Result result : resultScanner) {
				crewId=Bytes.toInt(result.getValue(Bytes.toBytes(ConstantsHBase.FAMILY_MOVIE_CREW), Bytes.toBytes(ConstantsHBase.QUALIFIER_MOVIE_CREW_ID)));
				//通过crewId获取CrewTO
				crewTO=crewDAO.getCrewById(crewId);
				crewTOlist.add(crewTO);
			}
		}
		return crewTOlist;	
	}
	
	//通过movieId 获取movieTO
	public MovieTO getMovieDetailById(int movieId) {

		MovieTO movieTO=getMovieById(movieId);
		ArrayList<GenreTO> genres=(ArrayList<GenreTO>) getGenreBymovieId(movieId);
		//设置genre
		movieTO.setGenres(genres);
		CastCrewTO castCrewTO=new CastCrewTO();
		//设置cast
		List<CastTO> castList=getCastsByMovieId(movieId);
		castCrewTO.setCastList(castList);
		//设置crew
		List<CrewTO> crewList=getCrewsByMovieId(movieId);
		castCrewTO.setCrewList(crewList);
		
		movieTO.setCastCrewTO(castCrewTO);
		return movieTO;
	}
	
}
