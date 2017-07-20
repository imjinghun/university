package bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Servlet implementation class PwdMD5
 */
@WebServlet("/PwdMD5")
public class PwdMD5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PwdMD5() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		MD5JM md5=new MD5JM();
		
		String pwd=request.getParameter("pwd");
		String pwdmd5=md5.transMD5(pwd);
	//	System.out.println(pwdmd5);
		PrintWriter out=response.getWriter();
		out.print(pwdmd5);
	}

}
