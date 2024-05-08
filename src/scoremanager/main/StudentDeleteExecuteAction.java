package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.StudentDao;
import tool.Action;
import tool.Util;

public class StudentDeleteExecuteAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception {

		Util util = new Util();
		Teacher teacher = util.getUser(req);
		String no = req.getParameter("no");
		StudentDao sDao = new StudentDao();
		sDao.delete(no,teacher.getSchool().getCd());

		req.getRequestDispatcher("student_delete_done.jsp").forward(req, res);
	}

}
