<%-- 学生一覧JSP --%>
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目</h2>
			<div class="my-2 px-4">
					<a href="SubjectList.action" class="link-success"> &lt;- 科目一覧に戻る</a>
			</div>
			<c:choose>
				<c:when test="${deleted_list.size()>0 }">
					<table class="table">
						<tr>
							<th class="col-4">科目コード</th>
							<th class="col-4">科目名</th>
							<th></th>
						</tr>
						<c:forEach var="subject" items="${deleted_list}">
							<tr>
								<td>${subject.cd}</td>
								<td>${subject.name}</td>
								<td><a href="SubjectDeletedList.action?cd=${subject.cd}">戻す</a></td>
						</c:forEach>
					</table>
				</c:when>
					<c:otherwise>
						<div class="">
							削除済み教科が存在しません。
						</div>
					</c:otherwise>
				</c:choose>
					
		</section>
	</c:param>
</c:import>