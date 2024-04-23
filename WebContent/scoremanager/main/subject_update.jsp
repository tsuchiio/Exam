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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報変更</h2>
			<form method="get" action="SubjectUpdateExecute.action">
				<div class="col-4">
					<label class="form-lavel" for="">科目コード</label>
					<input class="form-select border border-0" type="text" name="cd"
						value="${subject.cd}" readonly/>
						<div>${f1}</div>
				</div>
				<div class="col-4">
					<label class="form-text-label" >科目名</label>
					<input class="name-input" name="name" type="text"
						value="${name}"
						maxlength="20" required />
				</div>
				<div class="col-4">
					<input class="cd-blue" type="submit" id="filter-button" value="変更">
				</div>
				<div><a href="SubjectList.action">戻る</a></div>
			</form>
		</section>
	</c:param>
</c:import>