package ncs.memberList.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class NcsMemberDAO {
	private DataSource ds; // DataSource ds 는 아파치톰캣이 제공하는 DBCP(DB Connection Pool)이다.
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public NcsMemberDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/xe");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private Connection init() throws NamingException, SQLException {
		Context init = new InitialContext();
		// connectiom pool 접근
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int memberRegister(MemberVO mvo) throws SQLException {
		int count = 0;		
		try {
			conn = init();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		String sql = "insert into ncstest_member(userId,userName,birthday,gender) values(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mvo.getUserId());
		pstmt.setString(2, mvo.getUserName());
		pstmt.setString(3, mvo.getBirthday());
		pstmt.setInt(4, mvo.getGender());

		count = pstmt.executeUpdate();
		return count;
	}

	public List<MemberVO>  memberVOList() throws SQLException{
		List<MemberVO> aList =new ArrayList<MemberVO>();
		
			try {
				conn= init();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			stmt = conn.createStatement();
			String sql="select * from ncstest_member";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberVO mvo = new MemberVO();
				mvo.setUserId(rs.getString("userid"));
				mvo.setUserName(rs.getString("username"));
				mvo.setBirthday(rs.getString("birthday"));
				mvo.setGender(rs.getInt("gender"));
				
				aList.add(mvo);
			}
			
		
		
		return aList;
	}
}
