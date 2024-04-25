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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>
			<form method="get" action="TestRegistExecute.action">
				<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
					<div class="col-4">
						<label class="form-lavel" for="student-f1-select">入学年度</label>
						<select class="form-select" id="student-f1-select" name="f1">
							<option value="0">--------</option>
							<c:forEach var="year" items="${ent_year_set }">
								<%-- 現在のyearと選択されていたf1が一致した場合selectedを追記 --%>
								<option value="${year}" <c:if test="${year == f1}"> selected </c:if>>${year}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-4">
						<label class="form-lavel" for="student-f2-select">クラス</label>
						<select class="form-select" id="student-f2-select" name="f2">
							<option value="0">--------</option>
							<c:forEach var="num" items="${class_num_set}">
								<%-- 現在のyearと選択されていたf2が一致した場合selectedを追記 --%>
								<option value="${num}" <c:if test="${num == f2}"> selected</c:if>>${num}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-4">
						<label class="form-check-label" for="student-f3-check">科目</label>
						<select class="form-select" id="student-f3-select" name="f3">
							<option value="0">--------</option>
							<c:forEach var="subject" items="${subjects}">
								<%-- 現在のyearと選択されていたf3が一致した場合selectedを追記 --%>
								<option value="${subject.cd}" <c:if test="${subject.cd == f3}" > selected</c:if>>${subject.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-4">
						<label class="form-check-label" for="student-f4-check">回数
						<select class="form-select" id="student-f4-select" name="f4">
							<option value="0">--------</option>
							<c:forEach var="num" items="${num_set}">
								<%-- 現在のyearと選択されていたf4が一致した場合selectedを追記 --%>
								<option value="${num}" <c:if test="${num == f4}">selected</c:if>>${num}</option>
							</c:forEach>
						</select>
						</label>
					</div>
					<div class="col-2 text-center">
						<button class="btn btn-secondary" id="filter-button">検索</button>
					</div>
					<div class="mt-2 text-warning">${errors.get("f1")}</div>
				</div>
			</form>
			<c:choose>
				<c:when test="${not empty student_list}">
					<form method="get" action="TestRegistExecute.action">
					<c:if test="${req eq 'update'}">
						<div>科目:${subject_name}（${f4}回）</div>
						<table class="table table-hover">
							<tr>
								<th>入学年度</th>
								<th>クラス</th>
								<th>学生番号</th>
								<th>氏名</th>
								<th>点数</th>
							</tr>
								<c:forEach var="student" items="${student_list}">
									<tr>	
										<td>${f1}</td>
										<td>${f2}</td>
										<td>${student.getStudent().getNo()}</td>
										<td>${student.getStudent().getName()}</td>
										<td>
											<input name="point_${student.getStudent().getName()}" type="text" value="${student.getPoint()}">
											<c:if test="${not empty sessionScope['error_' + studentName]}">
												<p>${sessionScope['error_' + studentName]}</p>
											</c:if>
										</td>
								</c:forEach>
						</table>
					</c:if>
					<c:if test="${req eq 'create' }">
					<div>科目:${subject_name}（${f4}回）</div>
						<table class="table table-hover">
						<tr>
								<th>入学年度</th>
								<th>クラス</th>
								<th>学生番号</th>
								<th>氏名</th>
								<th>点数</th>
							</tr>
								<c:forEach var="student" items="${student_list}">
									<tr>	
										<td>${f1}</td>
										<td>${f2}</td>
										<td>${student.getNo()}</td>
										<td>${student.getName()}</td>
										<td>
											<input name="point_${student.getName()}" type="text" value="">
											<c:if test="${not empty sessionScope['error_' + studentName]}">
												<p class="mt-2 text-warning">${sessionScope['error_' + studentName]}</p>
											</c:if>
										</td>
								</c:forEach>
						</table>
					</c:if>
					<input class="btn btn-secondary" type="submit" value="登録して終了">
					</form>
				</c:when>
				<c:when test="${empty student_list }">
					<div>学生情報が存在しませんでした。</div>
				</c:when>
			</c:choose>
		</section>
	</c:param>
</c:import>