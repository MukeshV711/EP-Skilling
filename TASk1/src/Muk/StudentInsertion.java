package Muk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mukesh.DBUtil;
import StudentBean.StudentBean;

public class StudentInsertion {
	public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("Insert into Student values(?,?,?)");
		ps.setLong(1,student.getRegno());
		ps.setString(2, student.getName());
		ps.setString(3, student.getEmail());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}
	public int StudentDelete(StudentBean student,String id) throws ClassNotFoundException, SQLException 
	{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("delete from student where Regno="+id);
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public int StudentUpdate(int para,String upval,long id) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		String qry="";
		if(para==1) {
			qry="update student "+"set name=? "+"where Regno=?";
		}
		else if(para==2) {
			qry="update student "+"set Regno=? "+"where Regno=?";
		}
		else
		{
			qry="update student "+"set email=? "+"where Regno=?";
		}
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setString(1, upval);
		ps.setLong(2, id);
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public  void Retrive() throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("select * from student");
		ResultSet rst=ps.executeQuery();
		System.out.println("Regno\t\tName\t\tEmail");
		while(rst.next())
		{
			System.out.println(rst.getLong(1)+"\t"+rst.getString(2)+"\t\t"+rst.getString(3));
		}
		con.close();
	}
	{

	}
}