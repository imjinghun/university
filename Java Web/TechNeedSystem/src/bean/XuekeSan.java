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
 * Servlet implementation class XuekeSan
 */
@WebServlet("/XuekeSan")
public class XuekeSan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public XuekeSan() {
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
		//获得二级学科代码
		String strErji=request.getParameter("erji");
		strErji=strErji.substring(0, 5);
		
		DBBean db=new DBBean();
		
		String sql="select * from xueke$ where code like'"+strErji+"%' and code!='"+strErji+"00'";
		
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
