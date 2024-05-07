package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.StudentDao;
import tool.Action;

public class StudentDeleteExecuteAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception {

		String no = req.getParameter("no");
		StudentDao sDao = new StudentDao();
		sDao.delete(no);

		req.getRequestDispatcher("student_delete_done.jsp").forward(req, res);
	}

}
