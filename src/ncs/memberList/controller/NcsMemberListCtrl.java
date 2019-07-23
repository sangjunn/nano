package ncs.memberList.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncs.memberList.model.MemberVO;
import ncs.memberList.model.NcsMemberDAO;

@WebServlet("/ncstest/memberList.do")
public class NcsMemberListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// *** (요구사항 9) ncstest_member 테이블에 입력된 모든 회원정보가 보여지도록 하시오 *** // 
		NcsMemberDAO dao = new NcsMemberDAO();
		List<MemberVO> aList = null;
		try {
			aList = dao.memberVOList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("aList", aList);
		RequestDispatcher dis =request.getRequestDispatcher("/WEB-INF/ncstestMember/memberVoList.jsp");
		dis.forward(request, response);
	}
}