package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/XuekeYi")
public class XuekeYi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuekeYi() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		//response.getWriter().append("Served at:ASDSADF是梵蒂冈 ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		DBBean db=new DBBean();
		
		String sql="select * from xueke$ where code like'%0000'";
		
		String strValue="",strShow="";
		ResultSet rs=db.executeQuery(sql);
		
		try {
			while(rs.next())
			{
				strValue+=rs.getString(1)+" ";
				strShow+=rs.getString(2)+" ";
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String str="";
		str=strValue+"#"+strShow;
	//	System.out.println(str+" ");
		PrintWriter out=response.getWriter();
		out.print(str);
	}

}
