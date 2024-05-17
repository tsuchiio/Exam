package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;
import tool.Util;

public class ClassNumExecuteAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception {
		String[] classNums = req.getParameterValues("classNums");
		Teacher teacher = null;
		Util util = new Util();
		try{
			teacher = util.getUser(req);
			ClassNumDao cDao = new ClassNumDao();
			cDao.save(teacher.getSchool(), classNums);
			res.sendRedirect("Menu.action");
		}catch (Exception e) {
			throw e;
		}
	}
}
