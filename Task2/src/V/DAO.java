package V;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MV.Bean;
import Mukesh.DBUtil;

public class DAO {
	public int insert(Bean sb,String database,String table) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		Statement stmt3 = con.createStatement();
		stmt3.execute("use "+database);
		PreparedStatement ps=con.prepareStatement("insert into "+table+" values(?,?,?)");
		ps.setInt(1, sb.getItemid());
		ps.setString(2, sb.getItemname());
		ps.setDouble(3, sb.getItemcost());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public void display(String database,String table) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		Statement stmt3 = con.createStatement();
		stmt3.execute("use "+database);
		PreparedStatement ps=con.prepareStatement("select * from "+table);
		ResultSet rst=ps.executeQuery();
		System.out.println("ITEM-ID\t\tNAME\t\tCOST");
		while(rst.next())
		{
			System.out.println(rst.getInt(1)+"\t\t"+rst.getString(2)+"\t\t"+rst.getDouble(3));
		}
		con.close();
	}
	public double getcost(String database,String table) throws SQLException, ClassNotFoundException
	{
		Connection con=DBUtil.DBConnection();
		Statement stmt3 = con.createStatement();
		stmt3.execute("use "+database);
		PreparedStatement ps=con.prepareStatement("select sum(cost) from "+table);
		ResultSet rst=ps.executeQuery();
		double res=0;
		while(rst.next())
		{
			res=rst.getDouble(1);
		}
		con.close();
		return res;
	}
	public void initialize(String database,String table) throws SQLException, ClassNotFoundException
	{
		Connection con=DBUtil.DBConnection();
		Statement stmt1 = con.createStatement();
		stmt1.execute("create database "+database);
		Statement stmt3 = con.createStatement();
		stmt3.execute("use "+database);
		Statement stmt2=con.createStatement();
		stmt2.execute("create table "+table+"(itemID int,itemName varchar(50),cost double)");
		con.close();
	}
}
