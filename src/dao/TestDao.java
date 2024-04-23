package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;


public class TestDao extends Dao{

	private String baseSql = "select * from test";

	public Test get(Student student,Subject subject,School school,int no) throws Exception{
		Test test = new Test();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(
					"select * from test where"
					+ "student_no=? and subject_cd=? and "
					+ "school_cd =? and no = ?");
			statement.setString(1, student.getNo());
			statement.setString(2, subject.getCd());
			statement.setString(3, school.getCd());
			statement.setInt(4, no);
			
			ResultSet rSet = statement.executeQuery();
			
			if(rSet.next()){
				test.setStudent(student);
				test.setClassNum(rSet.getString("class_num"));
				test.setSubject(subject);
				test.setSchool(school);
				test.setNo(no);
				test.setPoint(rSet.getInt("point"));
			}else{
				test = null;
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement !=null) {
				try{
					statement.close();
				}catch (SQLException sqle){
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null){
				try{
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return test;
	}
	
	public List<Test> postFilter(ResultSet rSet,School school)throws Exception {
		List<Test> list = new ArrayList<>();
		try{
			// リザルトセットを全権操作
			while(rSet.next()){
				Test test = new Test();
				Student student = new Student();
				Subject subject = new Subject();
				// 学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("student_no"));
				student.setName(rSet.getString("student_name"));
				student.setEntYear(rSet.getInt("ent_year"));
				student.setClassNum(rSet.getString("class_num"));
				student.setSchool(school);
				subject.setCd(rSet.getString("subject_cd"));
				subject.setName(rSet.getString("subject_name"));
				test.setStudent(student);
				test.setSubject(subject);
				test.setSchool(school);
				test.setClassNum(rSet.getString("class_num"));
				test.setNo(rSet.getInt("num"));
				test.setPoint(rSet.getInt("point"));
				
				// リストに追加
				list.add(test);
			}

		}catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			list = null;
		}

		return list;
	}

	public List<Test> filter(int entYear,String classNum,Subject subject,
			int num, School school) throws Exception{
		List<Test> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		String condition = ""
				+ "SELECT st.ent_year,"
				+ "st.class_num as classNum,"
				+ "st.NO AS STUDENT_NO,"
				+ "st.NAME AS STUDENT_NAME,"
				+ "t.subject_cd,"
				+ "s.name as subject_name, "
				+ "t.NO AS NUM,"
				+ "t.POINT "
				+ "FROM test t "
				+ "JOIN subject s ON t.SUBJECT_CD = s.CD AND t.SCHOOL_CD = s.SCHOOL_CD "
				+ "JOIN student st ON t.SCHOOL_CD = st.SCHOOL_CD AND t.CLASS_NUM = st.CLASS_NUM and t.student_no = st.no "
				+ "WHERE st.ENT_YEAR = ? "
				+ "AND st.CLASS_NUM = ? "
				+ "AND s.CD = ? "
				+ "ORDER BY st.NAME, t.NO";
		String order = "";

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement(condition + order );
			statement.setInt(1, entYear);
			statement.setString(2, classNum);
			statement.setString(3, subject.getCd());
			rSet = statement.executeQuery();
			list = postFilter(rSet, school);
			if(list.isEmpty()){
				list = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement !=null) {
				try{
					statement.close();
				}catch (SQLException sqle){
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null){
				try{
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return list;
	}

	public boolean save(List<Test> list) throws Exception{
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		int count = 0;

		try {
			
		}catch (Exception e){
			
			return false;
		} 
		


		if (count > 0) {
			//実行件数が1件以上ある場合
			return true;
		} else {
			// 実行件数が0件の場合
			return false;
		}
	}


}
