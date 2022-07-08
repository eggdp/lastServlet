package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.Menu;

public class MenuDaoImpl implements MenuDao{
	private static String dburl = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "root";
	private static String dbpasswd = "1234";
	
	@Override
	public void insert(Menu menu) {
		Connection conn =null; 			//연결을 맺어낼 객체
		PreparedStatement ps = null;	//명령을 선언할 객체
		ResultSet rs = null; 			//결과값을 담아낼 객체
		
		try {
			//드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			//커넥션 객체
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "INSERT INTO `mydb`.`tb_menu` (`menu`, `price`, `img`) VALUES (?, ?, ?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, menu.getMenu());
			ps.setInt(2, menu.getPrice());
			ps.setString(3, menu.getImg());
			int result = ps.executeUpdate(); //명렁어 실행

			if(result == 1) {
				// 성공			
				System.out.println("데이터 입력 성공");
			}else {
				// 실패
				System.out.println("데이터 입력 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) {				
				try {
					rs.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			if(ps != null) {				
				try {
					ps.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			if(conn != null) {				
				try {
					conn.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Menu> selectAll() {
		ArrayList<Menu> list = new ArrayList<>(); //메소드 밖으로 전달할 리스트(메뉴dto들을 담은)
		Connection conn =null; 			//연결을 맺어낼 객체
		PreparedStatement ps = null;	//명령을 선언할 객체
		ResultSet rs = null; 			//결과값을 담아낼 객체
		
		
		try {
			//드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			//커넥션 객체
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "SELECT * FROM `tb_menu`";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); //명렁어 실행

			while(rs.next()) {		
				Menu dto = new Menu();
				dto.setMenu(rs.getString("menu"));
				dto.setPrice(rs.getInt("price"));
				dto.setImg(rs.getString("img"));
				// 위 데이터를 셋팅이 끝나면 리스트에 담는다.
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) {				
				try {
					rs.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			if(ps != null) {				
				try {
					ps.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			if(conn != null) {				
				try {
					conn.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public Menu selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Menu selectBest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
