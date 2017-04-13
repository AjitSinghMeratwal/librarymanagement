import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class GetValues 
{
	  public static Vector<String> header;
	  public static Vector<Vector<String>> records;
	  
	  
	  public static Vector<String> getAuthor()
	  {
		  Vector<String> v=new Vector<>();
		  Connection con=DBInfo1.con;
		  String query="select * from author order by name";
		  try
		  {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
			}
		  }
         catch(Exception e)
		  {
        	 e.printStackTrace();
		  }
		  
		  return v;
	  }
	  public static Vector<String> getCategory()
	  {
		  Vector<String> v=new Vector<>();
		  Connection con=DBInfo1.con;
		  String query="select * from category order by name";
		  try
		  {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
			}
		  }
         catch(Exception e)
		  {
        	 e.printStackTrace();
		  }
		  
		  return v;
	  }
	  public static Vector<String> getSubject()
	  {
		  Vector<String> v=new Vector<>();
		  Connection con=DBInfo1.con;
		  String query="select * from subject order by name";
		  try
		  {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
			}
		  }
         catch(Exception e)
		  {
        	 e.printStackTrace();
		  }
		  
		  return v;
	  }
	  public static Vector<String> getPublication()
	  {
		  Vector<String> v=new Vector<>();
		  Connection con=DBInfo1.con;
		  String query="select * from publication order by name";
		  try
		  {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
			}
		  }
         catch(Exception e)
		  {
        	 e.printStackTrace();
		  }
		  
		  return v;
	  }
      
	  public static void getBook(String str,String value)
	  {
		  System.out.println(str+":::::::::::::"+value);
		  header=new Vector<>();
		  records=new Vector<>();
		  
		  
		  String query="select * from book where "+str+"=?";
		  System.out.println(query);
		  Connection con=DBInfo1.con;
		  try
		  {
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, value);
			 ResultSet res=ps.executeQuery();
			 //fetching metadata
			 
			 ResultSetMetaData rsmd=res.getMetaData();
			 int count=rsmd.getColumnCount();
			 for(int i=1;i<=count;i++)
			 {
				 header.add(rsmd.getColumnName(i));
			 }
			 
			 //records
			 while(res.next())
			 {
				Vector<String> v=new Vector<>();
				for(int i=1;i<=count;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
			 }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
	  }
	  public static void getAllBooks()
	  {
		  
		  header=new Vector<>();
		  records=new Vector<>();
		  
		  
		  String query="select * from book ";
		  System.out.println(query);
		  Connection con=DBInfo1.con;
		  try
		  {
			 PreparedStatement ps=con.prepareStatement(query);
			 
			 ResultSet res=ps.executeQuery();
			 //fetching metadata
			 
			 ResultSetMetaData rsmd=res.getMetaData();
			 int count=rsmd.getColumnCount();
			 for(int i=1;i<=count;i++)
			 {
				 header.add(rsmd.getColumnName(i));
			 }
			 
			 //records
			 while(res.next())
			 {
				Vector<String> v=new Vector<>();
				for(int i=1;i<=count;i++)
				{
					v.add(res.getString(i));
				}
				records.add(v);
			 }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
}
}
