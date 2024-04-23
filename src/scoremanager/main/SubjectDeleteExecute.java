package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;
import tool.Util;

public class SubjectDeleteExecute extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception {

		Util util = new Util();
		Teacher teacher = util.getUser(req);
		String cd = req.getParameter("cd");
		SubjectDao sDao = new SubjectDao();
		Subject subject = sDao.get(cd, teacher.getSchool());
		sDao.delete(subject);

		req.getRequestDispatcher("subject_delete_done.jsp").forward(req, res);
	}

}
