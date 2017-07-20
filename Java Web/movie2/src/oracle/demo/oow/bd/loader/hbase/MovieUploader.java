package oracle.demo.oow.bd.loader.hbase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;

import oracle.demo.oow.bd.constant.Constant;
import oracle.demo.oow.bd.constant.KeyConstant;
import oracle.demo.oow.bd.dao.hbase.CrewDAO;
import oracle.demo.oow.bd.dao.hbase.CastDAO;
import oracle.demo.oow.bd.dao.hbase.MovieDAO;
import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.CrewTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.hbase.HbaseDB;

public class MovieUploader {

	//上传movie表movie、genre列族 和 genre表数据
	public void uploadMovieInfo() throws IOException {
		FileReader fr = null;
		try {
			fr = new FileReader(Constant.MOVIE_INFO_FILE_NAME);
			BufferedReader br = new BufferedReader(fr);
			String jsonTxt = null;
			MovieTO movieTO = null;
			MovieDAO movieDAO = new MovieDAO();
			int count = 1;

			// Each line in the file is the JSON string

			// Construct MovieTO from JSON object
			while ((jsonTxt = br.readLine()) != null) {

				movieTO = new MovieTO(jsonTxt.trim());
				if (movieTO != null && !movieTO.isAdult()) {

					System.out.println(count++ + " " + movieTO.getMovieJsonTxt());

					ArrayList<GenreTO> genreList = movieTO.getGenres();
					ArrayList<GenreTO> genreList2 = new ArrayList<GenreTO>();
					Iterator<GenreTO> iter = genreList.iterator();
					while (iter.hasNext()) {
						GenreTO genreTO = iter.next();
						genreTO.setCid(KeyConstant.GENRE_TABLE);
						genreList2.add(genreTO);

					}
					movieTO.setGenres(genreList2);
					movieDAO.insertMovie(movieTO);

				}
				//System.out.println("ERROR: Not able to parse the json string: \t" + jsonTxt);
				// EOF if
			} // EOF while
			//关闭连接
			HbaseDB.closeConn();
			System.out.println("成功");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fr.close();
		}
	}

	//cast表以及movie表cast列族
	public void uploadMovieCast() throws IOException {
        FileReader fr = null;
        try {
            fr = new FileReader(Constant.MOVIE_CASTS_FILE_NAME);
            BufferedReader br = new BufferedReader(fr);
            String jsonTxt = null;
            CastTO castTO = null;
            int count = 1;

            //Each line in the file is the JSON string
            CastDAO castDAO = new CastDAO();
            //Construct MovieTO from JSON object
            while ((jsonTxt = br.readLine()) != null) {
                try {
                    castTO = new CastTO(jsonTxt.trim());
                } catch (Exception e) {
                    System.out.println("ERROR: Not able to parse the json string: \t" +
                                       jsonTxt);
                }

                if (castTO != null) {
                    System.out.println(count++ + " " + castTO.getJsonTxt());
                   // CastDAO castDAO = new CastDAO();
                    castDAO.insertCastInfo(castTO);

                } //EOF if
            } //EOF while
            //关闭连接
            HbaseDB.closeConn();
            System.out.println("成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fr.close();
        }
    }
    //crew表   movie表crew列族
	public void uploadMovieCrew() throws IOException {
        FileReader fr = null;
        try {
            fr = new FileReader(Constant.MOVIE_CREW_FILE_NAME);
            BufferedReader br = new BufferedReader(fr);
            String jsonTxt = null;
            CrewTO crewTO = null;
            int count = 1;

            CrewDAO crewDAO = new CrewDAO();
            //Construct MovieTO from JSON object
            while ((jsonTxt = br.readLine()) != null) {
                try {
                    crewTO = new CrewTO(jsonTxt.trim());
                } catch (Exception e) {
                    System.out.println("ERROR: Not able to parse the json string: \t" +
                                       jsonTxt);
                }

                if (crewTO != null) {
                    System.out.println(count++ + " " + crewTO.getJsonTxt());
                    crewDAO.insertCrewInfo(crewTO);
                } //EOF if

            } //EOF while
            //关闭连接
            HbaseDB.closeConn();
            System.out.println("成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fr.close();
        }
    }
	public static void main(String[] args) {
		MovieUploader mu = new MovieUploader();
		try {
			mu.uploadMovieInfo();
//			mu.uploadMovieCast();
//			mu.uploadMovieCrew();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main

}
