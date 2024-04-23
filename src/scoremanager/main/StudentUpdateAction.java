package scoremanager.main;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.*;
import tool.Action;

public class StudentUpdateAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		String No = req.getParameter("no");
		StudentDao sDao = new StudentDao();
		Student student = sDao.get(No);
		ClassNumDao cDao = new ClassNumDao();
		List<String> list = cDao.filter(student.getSchool());
		req.setAttribute("student", student);
		req.setAttribute("class_num_set", list);

		req.getRequestDispatcher("student_update.jsp").forward(req, res);


	}
}
