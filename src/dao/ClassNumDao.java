package dao;

import java.util.ArrayList;
import java.util.List;

import bean.School;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClassNumDao extends Dao{

	public List<String> filter(School school) {
		List<String> list = new ArrayList<String>();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		String cd = school.getCd();
		try{
			Connection connection = getConnection();
			statement = connection.prepareStatement("select * from class_num where school_cd = ?");
			statement.setString(1, cd);
			rSet = statement.executeQuery();
			while(rSet.next()){
				String num = rSet.getString("class_num");
				list.add(num);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
