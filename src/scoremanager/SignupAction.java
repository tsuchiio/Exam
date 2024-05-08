package scoremanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class SignupAction extends Action{
	
	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception {
		
		req.getRequestDispatcher("signup.jsp").forward(req, res);
	}

}
