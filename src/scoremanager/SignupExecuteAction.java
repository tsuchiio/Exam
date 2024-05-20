package scoremanager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Teacher;
import dao.SchoolDao;
import dao.TeacherDao;
import tool.Action;


public class SignupExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		String url = "";
		String id = "";
		String password = "";
		String name = "";
		String school_cd = "";
		String school_name = "";
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = null;
		SchoolDao schoolDao = new SchoolDao();
		
		//リクエストパラメータ―の取得 2
		id = req.getParameter("id");// 教員ID
		password = req.getParameter("password");//パスワード
		name = req.getParameter("name");
		school_cd = req.getParameter("school_cd");
		school_name = req.getParameter("school_name");

		//DBからデータ取得 3
		teacher = teacherDao.get(id);//教員データ取得

		//ビジネスロジック 4
		//DBへデータ保存 5
		//レスポンス値をセット 6
		//フォワード 7
		//条件で手順4~7の内容が分岐
		if (teacher != null) {
			List<String> errors = new ArrayList<>();
			errors.add("IDが重複しています。");
			// 認証失敗の場合
			// エラーメッセージをセット
			req.setAttribute("errors", errors);
			req.setAttribute("id", id);
			req.setAttribute("name",name);
			req.setAttribute("school_cd", school_cd);
			req.setAttribute("school_name", school_name);
			//リダイレクト
			url = "signup.jsp";
			req.getRequestDispatcher(url).forward(req, res);
		} else {
			School school = new School();
			school = schoolDao.get(school_cd);
			if(school == null || school.getName().equals(school_name)){
				teacherDao.sigup(id, password, name, school_cd,school_name);
				url = "Login.action?signup=true";
				res.sendRedirect(url);
			}else{
				List<String> errors = new ArrayList<>();
				errors.add("学校名が違います。");
				req.setAttribute("errors", errors);
				req.setAttribute("id", id);
				req.setAttribute("name",name);
				req.setAttribute("school_cd", school_cd);
				req.setAttribute("school_name", school_name);
				
				url = "signup.jsp";
				req.getRequestDispatcher(url).forward(req, res);
			}
		}

//		req.getRequestDispatcher(url).forward(req, res);
	}

}
