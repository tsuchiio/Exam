package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;

public class TestListStudentDao extends Dao{
	private String baseSql = "SELECT s.name as subject_name, "
			+ "s.cd as subject_cd, "
			+"t.no as num,"
			+"t.point "
			+"FROM test t "
			+"JOIN subject s ON t.SUBJECT_CD = s.CD AND t.SCHOOL_CD = s.SCHOOL_CD "
			+"JOIN student st ON t.SCHOOL_CD = st.SCHOOL_CD AND t.CLASS_NUM = st.CLASS_NUM "
			+"WHERE st.no = ? ";

	private List<TestListStudent> postfilter(ResultSet rSet)throws Exception{
		List<TestListStudent> list = new ArrayList<>();
		try{
			while(rSet.next()){
				TestListStudent tStudent = new TestListStudent();
				tStudent.setSubjectName(rSet.getString("subject_name"));
				tStudent.setSubjectCd(rSet.getString("subject_cd"));
				tStudent.setNum(rSet.getInt("num"));
				tStudent.setPoint(rSet.getInt("point"));
				list.add(tStudent);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		return list;

	}

	public List<TestListStudent> filter(Student student)throws Exception{
		List<TestListStudent> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;

		try{
			statement = connection.prepareStatement(
					baseSql);
			statement.setString(1, student.getNo());
			rSet = statement.executeQuery();
			list = postfilter(rSet);
		}catch (Exception e) {
			throw e;
		}finally {
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
}
