package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import bean.School;
import bean.Student;
import bean.Subject;
import bean.TestListStudent;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao{
	private String baseSql = "SELECT st.ent_year,"
				+ "st.class_num,"
				+ "st.no as student_no,"
				+ "st.name as student_name,"
				+ "s.name as subject_name,"
				+ "s.cd as subject_cd,"
				+"t.no as num,"
				+"t.point "
				+"FROM test t "
				+"JOIN subject s ON t.SUBJECT_CD = s.CD AND t.SCHOOL_CD = s.SCHOOL_CD "
				+"JOIN student st ON t.SCHOOL_CD = st.SCHOOL_CD AND t.CLASS_NUM = st.CLASS_NUM "
				+"WHERE st.ENT_YEAR = ? "
				+"AND st.CLASS_NUM = ? "
				+"AND s.CD = ? "
				+"ORDER BY st.NAME, t.NO";

	private List<TestListSubject> postfilter(ResultSet rSet)throws Exception{
		List<TestListSubject> list = new ArrayList<>();
		try{
			while(rSet.next()){
				TestListSubject tSubject = new TestListSubject();
				Map<Integer, Integer> point = new HashMap<>();
				tSubject.setEntYear(rSet.getInt("ent_year"));
				tSubject.setStudentNo(rSet.getString("student_no"));
				tSubject.setStudentName(rSet.getString("student_name"));
				tSubject.setClassNum(rSet.getString("class_num"));
				tSubject.setPoints(point);
				tSubject.putPoit(rSet.getInt("num"), rSet.getInt("point"));
				list.add(tSubject);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<TestListSubject> filter(int entYear,String classNum,
			Subject subject, School school)throws Exception{
		List<TestListSubject> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;

		try{
			statement = connection.prepareStatement(
					baseSql);
			statement.setInt(1, entYear);
			statement.setString(2, classNum);
			statement.setString(3, subject.getCd());
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
