package scoremanager.main;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import bean.Teacher;
import bean.Test;
import tool.Action;
import tool.Util;

public class TestRegistExecuteAction extends Action{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Util util = new Util();
		Teacher teacher = util.getUser(req);
		Enumeration<String> paramlist = req.getParameterNames();
		while(paramlist.hasMoreElements()){
			String name = paramlist.nextElement();
			if(name.startsWith("point_")){
				String student_name = name.substring(6);
				String p = (req.getParameter(name));
				try{
					int point = Integer.parseInt(p);
					if(point >= 0 && point <= 100){
						List<Test> list = new ArrayList<>();
						
					}else{
						req.getSession().setAttribute("error_"+student_name, "0〜100の範囲で入力してください");
						PointError(req, res);
					}
				}catch (Exception e) {
					req.getSession().setAttribute("error_"+student_name, "0〜100の範囲で入力してください");
					PointError(req, res);
				}
			}
		}
	}
	
	private void PointError(HttpServletRequest req, HttpServletResponse res)throws Exception {
		String f1 = req.getParameter("f1");
		String f2 = req.getParameter("f2");
		String f3 = req.getParameter("f3");
		String f4 = req.getParameter("f4");
		req.setAttribute("f1", f1);
		req.setAttribute("f2", f2);
		req.setAttribute("f3", f3);
		req.setAttribute("f4", f4);
		req.getRequestDispatcher("TestRegist.action").forward(req, res);
	}

}
