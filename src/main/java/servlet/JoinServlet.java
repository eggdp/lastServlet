package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDaoImpl;
import dao.TbUserDaoImpl;
import dto.Menu;
import dto.TbUser;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글을 받기 위해 인코딩 설정
				request.setCharacterEncoding("utf-8");
				// insert.jsp 에서 전달된 데이터 받기
				String userid = request.getParameter("uerid");
				String userpw = request.getParameter("userpw");
				String name = request.getParameter("name");
				
				// 확인용 출력
				System.out.println(userid+"\n"+userpw+"\n"+name);
				
				// 디비에 데이터 넣기전 DTO에 데이터 셋팅
				TbUser dto = new TbUser();
				dto.setUserid(userid);
				dto.setUserpw(userpw);
				dto.setName(name);
				 
				// 디비에 데이터 넣기
				//MenuDaoImpl dao = new MenuDaoImpl();
				TbUserDaoImpl dao=new TbUserDaoImpl();
				dao.join(dto);
				System.out.println(dto);
				// 페이지 이동
				// response.sendRedirect("/insert.menu");
				// 자바스크립트를 이용해서 알림 띄우고 페이지 이동
				// 브라우저 보내기 전에 한글 설정
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('등록되었습니다.'); location.href='/insert.menu';</script>");
				// 또 jsp파일을 만들어서 페이지 이동 후 만든쪽에서 위 코드 작성 가능
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
