<%-- 学生情報登録	JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報登録</h2>
			<form method="get" action="SubjectCreateExecute.action">
					<div class="">
						<label class="form-text-lavel">科目コード</label>
						<input class="cd-input" name="cd" type="text"
						placeholder="科目コードを入力してください" value="${cd}"
						maxlength="3" required />
							<p class="mt2 text-warning">${errors.get("f1")}</p>
							<p class="mt2 text-warning">${errors.get("f2")}</p>
					</div>
					<div class="">
						<label class="form-text-label" >科目名</label>
						<input class="name-input" name="name" type="text"
						placeholder="科目名を入力してください" value="${name}"
						maxlength="20" required />
					</div>
					<div class="">
						<input type="submit" value="登録">
					</div>
					<div><a href="SubjectList.action">戻る</a></div>
			</form>
		</section>
	</c:param>
</c:import>