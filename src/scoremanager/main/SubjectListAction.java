package scoremanager.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.time.LocalDate;

import bean.Student;
import bean.Teacher;
import dao.*;
import tool.Action;
import tool.Util;

public class SubjectListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		Util util = new Util();
		util.setSubjects(req);

		req.getRequestDispatcher("subject_list.jsp").forward(req, res);
	}
}
