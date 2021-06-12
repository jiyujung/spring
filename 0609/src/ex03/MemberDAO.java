package ex03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
//	private static final String driver = "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String user = "spring";
//	private static final String pwd = "spring";
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	//private Statement stmt;
	
	public MemberDAO() {
		try {
			//항상 사용하는 구문
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			//connDB();
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println("preparedStatement : " + query);
			pstmt = con.prepareStatement(query);  //prepareStataement(query)가 먼저 컴파일을 해줌
			ResultSet rs = pstmt.executeQuery();  // query문을 실행
			//ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			//stmt.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "insert into t_member";
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("preparedStatement : " + query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection 생성 성공");
//			//stmt = con.createStatement();
//			System.out.println("Statement 생성 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
