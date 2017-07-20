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
 * Servlet implementation class HyMenlei
 */
@WebServlet("/HyDalei")
public class HyDalei extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HyDalei() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获得门类代码
		String strMenlei=request.getParameter("menlei");
		strMenlei=strMenlei.substring(0, 1);
		
		DBBean db=new DBBean();
		
		String sql="select * from gmjjhy$ where code like'"+strMenlei+"%00' and code!='"+strMenlei+"0000'";
		
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
