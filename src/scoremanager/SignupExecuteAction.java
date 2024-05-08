package scoremanager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
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
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = null;

		//リクエストパラメータ―の取得 2
		id = req.getParameter("id");// 教員ID
		password = req.getParameter("password");//パスワード
		name = req.getParameter("name");
		school_cd = req.getParameter("school_cd");

		//DBからデータ取得 3
		teacher = teacherDao.login(id, password);//教員データ取得

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
			//リダイレクト
			url = "signup.jsp";
			req.getRequestDispatcher(url).forward(req, res);
		} else {
			if(school_cd.length()<3){
				List<String> errors = new ArrayList<>();
				errors.add("学校IDは3文字で入力してください");
				// 認証失敗の場合
				// エラーメッセージをセット
				req.setAttribute("errors", errors);
				req.setAttribute("id", id);
				req.setAttribute("name",name);
				req.setAttribute("school_cd", school_cd);
				url = "signup.jsp";
				req.getRequestDispatcher(url).forward(req, res);
			}else{
			teacherDao.sigup(id, password, name, school_cd);
			url = "Login.action?signup=true";
			res.sendRedirect(url);
			}
		}

//		req.getRequestDispatcher(url).forward(req, res);
	}

}
