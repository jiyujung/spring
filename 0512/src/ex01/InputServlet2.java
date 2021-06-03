package ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet2
 */
@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration enu = request.getParameterNames(); // Enumeration : 여러 개의 값을 한번에 저장할 수 있는 일종의 변수(배열보다 효율적으로 저장할 수 있는 자료구조)
		while(enu.hasMoreElements()) {  //enu에 있는 값만큼 반복하겠다
			String name = (String)enu.nextElement();
			String[] values = request.getParameterValues(name);
			for(String str : values) {   //values에 있는 값들을 하나씩 str에 대입
				System.out.println("name = " + name + ", value = " + str);
			}
		}
	}

}
