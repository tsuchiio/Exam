package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;
import tool.Util;

public class SubjectUpdateExecuteAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{

		Util util = new Util();
		boolean error = true;
		String name = "";
		String cd = "";
		Teacher teacher = util.getUser(req);
		SubjectDao sDao = new SubjectDao();

		name = req.getParameter("name");
		cd = req.getParameter("cd");

		Subject subject = new Subject();
		subject.setCd(cd);
		subject.setName(name);
		subject.setSchool(teacher.getSchool());
		error = sDao.save(subject, "update");

		if(!error){
			req.setAttribute("f1","科目が存在していません。");
			req.setAttribute("cd", cd);
			req.setAttribute("name", name);
			req.getRequestDispatcher("subject_update.jsp").forward(req, res);
			return;
		}

		req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);

	}

}
