package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;
import tool.Util;

public class SubjectDeletedListAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception {
		
		Util util = new Util();
		Teacher teacher = util.getUser(req);
		SubjectDao sDao = new SubjectDao();
		List<Subject> list = new ArrayList<>();
		String cd = null;
		cd = req.getParameter("cd");
		if(cd != null){
			sDao.change(cd, true);
		}
		list = sDao.filter(teacher.getSchool(), false);
		req.setAttribute("deleted_list", list);
		
		req.getRequestDispatcher("subject_deleted_list.jsp").forward(req, res);
	}
}
