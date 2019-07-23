package ncs.memberList.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncs.memberList.model.MemberVO;
import ncs.memberList.model.NcsMemberDAO;

@WebServlet("/ncstest/memberRegister.do")
public class NcsMemberRegisterCtrl extends HttpServlet {
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

		String method = request.getMethod();

		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		if ("GET".equalsIgnoreCase(method)) {
			// *** (요구사항 2) /WEB-INF/ncstestMember/memberRegister.jsp 페이지가 보여지도록 작성하시오. ***
			// //
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/ncstestMember/memberRegister.jsp");
			dis.forward(request, response);
		} else {
			MemberVO mvo = new MemberVO();

			mvo.setUserId(userId);
			mvo.setUserName(userName);
			mvo.setBirthday(birthday);
			mvo.setGender(Integer.parseInt(gender));
			NcsMemberDAO dao =new NcsMemberDAO();
			try {
				int result = dao.memberRegister(mvo);
				if (result == 1)
					response.sendRedirect("memberList.do");
			} catch (SQLException e) {
				e.printStackTrace();

				request.setAttribute("errorMsg", "SQL 문 장애발생으로 데이터 입력 실패함!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ncstestMember/error.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}//end class
