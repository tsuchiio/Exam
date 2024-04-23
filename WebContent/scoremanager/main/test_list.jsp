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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績参照</h2>
			<form method="get" action="TestList.action">
					<div class="row">科目情報
					<table>
					<tr>
						<th>入学年度</th>
						<th>クラス</th>
						<th>科目</th>
						<th></th>
					</tr>
					<tr>
							<td>
								<select class="form-select" id="student-f1-select" name="f1">
									<option value="0">--------</option>
									<c:forEach var="year" items="${ent_year_set }">
										<%-- 現在のyearと選択されていたf1が一致した場合selectedを追記 --%>
										<option value="${year}" <c:if test="${year == ent_year}">selected</c:if>>${year}</option>
									</c:forEach>
								</select>
							</td>
					<div class="">
							<td>
							<select class="form-select" id="student-f2-select" name="f2">
								<option value="0">--------</option>
								<c:forEach var="num" items="${class_num_set}">
									<%-- 現在のyearと選択されていたf2が一致した場合selectedを追記 --%>
									<option value="${num}" <c:if test="${num == classNum}">selected</c:if>>${num}</option>
								</c:forEach>
							</select>
							</td>
					</div>
					<div class="">
							<td>
							<select class="form-select" id="student-f3-select" name="f3">
								<option value="0">--------</option>
								<c:forEach var="subject" items="${subjects}">
									<%-- 現在のyearと選択されていたf3が一致した場合selectedを追記 --%>
									<option value="${subject.cd}" <c:if test="${subject.cd == cd}">selected</c:if>>${subject.name}</option>
								</c:forEach>
							</select>
							</td>
					</div>
					<td>
					<div class="col-2 text-center">
						<button class="btn btn-secondary" id="filter-button">検索</button>
					</div>
					</td>
					</tr>
					</table>
				<input type="hidden" name="f" value="sj">
				</div>
			</form>
			<div class="mt2 text-warning">${error}</div>
			<form method="get" action="TestList.action">
				<div class="row">
					<label class="" for="No">
						<p>学生情報</p>
					</label>
					<div class="col" id="No">
						学生番号
						<input type="text" value="${f4}"name="f4" required />
					</div>
					<div class="col">
						<input type="submit" value="検索">
					</div>
				</div>
			<input type="hidden" name="f" value="st">
			</form>
			<label>
				<p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>
			</label>
		</section>
	</c:param>
</c:import>