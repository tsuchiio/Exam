<%-- サイドバー --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
	#mein a{
	border-left: 8px solid #EEEEEE;
	background-color: #e6f0fe;
	display: block;
	padding: 3px 10px;
	text-decoration: none;
	color: #333;
	width: 150px;
	margin: 1px 0px;
	text-align: left;
	font-size: 14px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	}

	#mein a:hover{
	border-left: 8px solid #f0f1f2;
	background-color: #bbdbf3;
	}

	#s_manage a{
	border-left: 8px solid #EEEEEE;
	background-color: #ddbbbb;
	display: block;
	padding: 3px 10px;
	text-decoration: none;
	color: #333;
	width: 150px;
	margin: 1px 0px;
	text-align: left;
	font-size: 14px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	}

	#s_manage a:hover{
	border-left: 8px solid #f0f1f2;
	background-color: #f19ca7;
	}

	#s_manage a{
	border-left: 8px solid #EEEEEE;
	background-color: #ddbbbb;
	display: block;
	padding: 3px 10px;
	text-decoration: none;
	color: #333;
	width: 150px;
	margin: 1px 0px;
	text-align: left;
	font-size: 14px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	}

	#s_manage a:hover{
	border-left: 8px solid #f0f1f2;
	background-color: #f19ca7;
	}


	#manage {
	background-color: #EEEEEE;
	display: block;
	padding: 3px 10px;
	text-decoration: none;
	color: #333;
	width: 90px;
	margin: 1px 0px;
	text-align: left;

	}

	#p_manage a{
	border-left: 8px solid #EEEEEE;
	background-color: #bbddbb;
	display: block;
	padding: 3px 10px;
	text-decoration: none;
	color: #333;
	width: 150px;
	margin: 1px 0px;
	text-align: left;
	font-size: 14px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	}

	#p_manage a:hover{
	border-left: 8px solid #f0f1f2;
	background-color: #89c997;
	}

	#sub_manage a{
	border-left: 8px solid #EEEEEE;
	background-color: #bbbbdd;
	display: block;
	padding: 3px 10px;
	text-decoration: none;
	color: #333;
	width: 150px;
	margin: 1px 0px;
	text-align: left;
	font-size: 14px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	}

	#sub_manage a:hover{
	border-left: 8px solid #f0f1f2;
	background-color: #8d93c8;
	}


</style>
<div id ="menu">
	<ul class="nav nav-pills flex-column mb-auto px-4">
		<li class="nav-item my-3"id ="mein"><a href="Menu.action">メニュー</a></li>
		<li class="nav-item mb-3"id ="s_manage"><a href="StudentList.action">学生管理</a></li>
		<li class="nav-item mb-2"id ="manage">成績管理</li>
		<li class="nav-item mx-3 mb-3"id ="p_manage"><a href="TestRegist.action">成績登録</a></li>
		<li class="nav-item mx-3 mb-3"id ="p_manage"><a href="TestList.action">成績参照</a></li>
		<li class="nav-item mb-3"id ="sub_manage"><a href="SubjectList.action">科目管理</a></li>
	</ul>
</div>