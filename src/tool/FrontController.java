package tool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Teacher;
import dao.ClassNumDao;

@WebServlet(urlPatterns = { "*.action" })
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			Teacher teacher = null;
			Util util = new Util();
			teacher = util.getUser(req);
			// パスを取得
			String path = req.getServletPath().substring(1);
			
			if(teacher != null){
				ClassNumDao cDao = new ClassNumDao();
				List<String> list = cDao.filter(teacher.getSchool());
				if(list.size() < 1 && path.contains("Menu")){
					req.setAttribute("set",true);
					req.getRequestDispatcher("classInput.jsp").forward(req, res);
					return;
				}
			}
			
			
			// ファイル名を取得しクラス名に変換
			String name = path.replace(".a", "A").replace('/', '.');
			// アクションクラスのインスタンスを返却
			Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();

			// 遷移先URLを取得
			action.execute(req, res);
			//String url = action.execute(req, res);
			//req.getRequestDispatcher(url).forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
			// エラーページへリダイレクト
			req.getRequestDispatcher("/error.jsp").forward(req, res);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req,res);

	}
}
