package servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.menu")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("hello world").append(request.getContextPath());
		
		//브라우저에서 서버에게 요청한 URI
		String uri = request.getRequestURI();
		System.out.println("getRequestURI : "+ uri);
		//브라우저에서 서버에게 요청한 URL
		//URL은 반환값이 StringBuffer 되어 있어서 같은 타입으로 맞춰줌
		StringBuffer url = request.getRequestURL();
		System.out.println("getRequestURL : "+url.toString()); //StringBuffer 출력할때 toString
		String [] uriArr = uri.split("\\.");   // 문자열 자르기
		System.out.println(Arrays.toString(uriArr));
		// 문자열을 자르면 배열에 각 저장되는데 0번째가 첫번째 문자열
		//만약에 uri 요청이 insert면  insert페이지로 이동
		String site = ""; //페이지 이동할 주소(*.jsp)
		
		if(uriArr[0].equals("/insert")) {  //uri.equals("/insert.menu") uriArr[0].equals("/insert")
			System.out.println("insert.jsp 로 이동");
			site = "/insert.jsp";
		}else if(uriArr[0].equals("/insert_proc")) {  //uri.equals("/insert.menu") uriArr[0].equals("/insert")
			System.out.println("insert_proc.jsp 로 이동");
			site = "/InsertServlet";
		}else if(uriArr[0].equals("/see")) {  //uri.equals("/insert.menu") uriArr[0].equals("/insert")
			System.out.println("see.jsp 로 이동");
			site = "/SeeServlet";
		}else if(uriArr[0].equals("/best")) {  //uri.equals("/insert.menu") uriArr[0].equals("/insert")
			System.out.println("best.jsp 로 이동");
			site = "/best.jsp";
		}else if(uriArr[0].equals("/login")) {  //uri.equals("/insert.menu") uriArr[0].equals("/insert")
			System.out.println("login.jsp 로 이동");
			site = "/LoginServlet";
		}else if(uriArr[0].equals("/logout")) {  //uri.equals("/insert.menu") uriArr[0].equals("/insert")
			System.out.println("logout.jsp 로 이동");
			site = "/logout.jsp";
		}else if(uriArr[0].equals("/join")) {  //uri.equals("/insert.menu") uriArr[0].equals("/insert")
			System.out.println("join.jsp 로 이동");
			site = "/join.jsp";
		}else if(uriArr[0].equals("/joinresult")) {  //uri.equals("/insert.menu") uriArr[0].equals("/insert")
			System.out.println("joinresult.jsp 로 이동");
			site = "/JoinServlet";
		}else {
			System.out.println("404.jsp 로 이동");
			site = "/404.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(site);
			dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
