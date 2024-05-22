<%-- 学生情報登録	JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts">
		<c:if test="${set}">
		<script type="text/javascript">
			alert('クラスを設定してください！');
		</script>
	</c:if>
	</c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">クラス登録</h2>
			<form id="classForm" method="get" action="ClassNumExecute.action">
				<div class="class-container mb-3" id="classContainer1">
					<label for="classNum1">1つ目のクラス</label>
					<input type="text" id="classNum1" name="classNums" maxlength="5" class="form-control" required>
				</div>
				<input class="btn btn-primary" type="submit" value="保存" id="submitButton">
			</form>
		</section>
		<script>
		document.addEventListener('DOMContentLoaded', (event) => {
			const form = document.getElementById('classForm');
			let classCount = 1;

			function addClassField() {
				classCount++;
				const newDiv = document.createElement('div');
				newDiv.className = 'class-container mb-3';
				newDiv.id = 'classContainer' + classCount;

				const newLabel = document.createElement('label');
 				newLabel.setAttribute('for', 'classNum' + classCount);
				newLabel.innerText = classCount + 'つ目のクラス ';

				const newInput = document.createElement('input');
				newInput.type = 'text';
				newInput.id = 'classNum' + classCount;
				newInput.name = 'classNums';
				newInput.className = 'form-control';
				newInput.maxLength = '5';
				newInput.required = false;

				newDiv.appendChild(newLabel);
				newDiv.appendChild(newInput);
				form.insertBefore(newDiv, document.getElementById('submitButton'));

				newInput.addEventListener('input', onInput);
			}

			function onInput(event) {
				const currentInput = event.target;
				if (currentInput.value.trim() !== "") {
					currentInput.removeEventListener('input', onInput);
					addClassField();
				}
			}

			const initialInput = document.getElementById('classNum1');
			initialInput.addEventListener('input', onInput);
        });
		</script>
	</c:param>
</c:import>