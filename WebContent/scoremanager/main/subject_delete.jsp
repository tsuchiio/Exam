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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報削除</h2>
			<form method="get" action="SubjectDeleteExecute.action">
				<div class="col-4">
					<input type="hidden" value="${subject.cd}">
					<p>「${subject.name}(${subject.cd})」を削除してよろしいですか</p>
				</div>
				<div class="col-4">
					<input class="cd-blue" type="submit" id="filter-button" value="削除">
				</div>
				<div><a href="SubjectList.action">戻る</a></div>
			</form>
		</section>
	</c:param>
</c:import>