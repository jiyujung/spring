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
		System.out.println("init �޼��� ȣ��");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration enu = request.getParameterNames(); // Enumeration : ���� ���� ���� �ѹ��� ������ �� �ִ� ������ ����(�迭���� ȿ�������� ������ �� �ִ� �ڷᱸ��)
		while(enu.hasMoreElements()) {  //enu�� �ִ� ����ŭ �ݺ��ϰڴ�
			String name = (String)enu.nextElement();
			String[] values = request.getParameterValues(name);
			for(String str : values) {   //values�� �ִ� ������ �ϳ��� str�� ����
				System.out.println("name = " + name + ", value = " + str);
			}
		}
	}

}