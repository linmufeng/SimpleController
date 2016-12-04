package kinlon.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String NAME = "admin";
        String PSW = "123456";
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html ; charset = utf-8");
        String name = request.getParameter("username");
        String psw = request.getParameter("password");
        
        if (!name.equals(NAME)){
            request.setAttribute("msg","your username is " + name + " could not login,please try again...");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else if (!psw.equals(PSW)){
            request.setAttribute("msg", "your password is error,please try again...");
            request.getRequestDispatcher("/login.jsp").forward(request, response);          
        }else if (name.equals(NAME) && psw.equals(PSW)){
            request.setAttribute("username", name);
            request.getRequestDispatcher("/index.jsp").forward(request, response); 
            return;
        }else{
            request.setAttribute("msg", "unknow question happen,sorry...");
            request.getRequestDispatcher("/login_fail.jsp").forward(request, response);  
        }
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ;
	}

	public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }
    
    
    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init(ServletConfig config) throws ServletException {
        // Put your code here
        super.init(config);
        
    }
    
}
