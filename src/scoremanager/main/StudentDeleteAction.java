package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import tool.Action;
import dao.*;

public class StudentDeleteAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception {
		
		String no = "";
		no = req.getParameter("no");
		Student student = new Student();
		StudentDao sDao = new StudentDao();
		student = sDao.get(no);
		req.setAttribute("student", student);
		req.getRequestDispatcher("student_delete.jsp").forward(req, res);
	}
}
