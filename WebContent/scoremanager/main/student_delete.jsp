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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生削除</h2>
			<div class="mx-3 my-4">
				<form method="get" action="StudentDeleteExecute.action">
					<div class="mb-3">
						<input type="hidden" name="no" value="${student.getNo()}">
						<p>「${student.getName()}」さんを削除してよろしいですか</p>
					</div>
					<div class="mb-5">
						<input class="btn btn-danger" type="submit" id="filter-button" value="削除">
					</div>
				</form>
				<div><a href="StudentUpdate.action?no=${student.getNo()}">戻る</a></div>
			</div>
		</section>
	</c:param>
</c:import>