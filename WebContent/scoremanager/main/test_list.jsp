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
			<div class="container border mx-3 mb-3 px-3 py-2 align-items-center rounded">
				<div class	="row">
					<div class="col">
						<form method="get" action="TestList.action">
							<div class="row align-items-center">
								<div class="col-2">
									<label class="mb-0">科目情報</label>
								</div>
								<div class="col-6">
									<table class="table table-borderless table-sm">
										<tr>
											<th class="fw-normal">入学年度</th>
											<th class="fw-normal">クラス</th>
											<th class="fw-normal">科目</th>
										</tr>
										<tr>
											<td class="mb-3">
												<select class="form-select" id="student-f1-select" name="f1">
													<option value="0">--------</option>
													<c:forEach var="year" items="${ent_year_set}">
														<option value="${year}" <c:if test="${year == ent_year}">selected</c:if>>${year}</option>
													</c:forEach>
												</select>
											</td>
											<td>
												<select class="form-select" id="student-f2-select" name="f2">
													<option value="0">--------</option>
													<c:forEach var="num" items="${class_num_set}">
														<option value="${num}" <c:if test="${num == classNum}">selected</c:if>>${num}</option>
													</c:forEach>
												</select>
											</td>
											<td>
												<select class="form-select" id="student-f3-select" name="f3">
													<option value="0">--------</option>
													<c:forEach var="subject" items="${subjects}">
														<option value="${subject.cd}" <c:if test="${subject.cd == cd}">selected</c:if>>${subject.name}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
									</table>
								</div>
							<div class="col-3 text-center mt-2">
								<button class="btn btn-secondary" id="filter-button">検索</button>
							</div>
							</div>
							<input type="hidden" name="f" value="sj">
						</form>
					</div>
				</div>
				<hr class="mx-3 my-1 mb-3 border-bottom">
				<div class="row">
					<div class="col">
						<form method="get" action="TestList.action">
							<div class="row align-items-center">
								<div class="col-sm-2">
									<label class="">学生情報</label>
								</div>
								<div class="col-sm-4">
									<div>学生番号</div>
									<input class="form-control" type="text" value="${f4}" 
									name="f4" id="No" placeholder="学生番号を入力してください" required />
								</div>
								<div class="col-sm-2">
									<input class="btn btn-secondary" type="submit" value="検索">
								</div>
							</div>
							<input type="hidden" name="f" value="st">
						</form>
					</div>
				</div>
			</div>
			<div class="mt2 text-warning">${error}</div>
			<label>
				<p class="text-info">科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>
			</label>
		</section>
	</c:param>
</c:import>