package scoremanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // セッションを取得
        HttpSession session = req.getSession(false);
        if (session != null) { // セッションが存在する場合
            // セッションを無効にする（ログアウト）
            session.invalidate();
            // ログアウト後の画面へフォワード
            req.getRequestDispatcher("logout.jsp").forward(req, res);
        } else {
            // セッションが存在しない場合はログアウト処理を行わず、ログアウト画面にリダイレクト
            res.sendRedirect("logout.jsp");
        }
    }
}
