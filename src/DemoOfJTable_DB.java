import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DemoOfJTable_DB extends JFrame 
{
	JTable table;
	public DemoOfJTable_DB()
	{
		Vector<String> header=new Vector<>();
		Vector<Vector<String>> records=new Vector<>();
		setSize(800,500);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Connection con=DBInfo1.con;
		String str="Select * from book";
		try
		{
			PreparedStatement ps=con.prepareStatement(str);
			ResultSet res=ps.executeQuery();
			//fetching metadata of table
			ResultSetMetaData rsmd=res.getMetaData();
			int count=rsmd.getColumnCount();
			for(int i=1;i<=count;i++)
			{
				header.add(rsmd.getColumnName(i));
			}
			
			//records
			while(res.next())  //for rows
			{
				Vector<String> v=new Vector<>();
				for(int i=1;i<=count;i++)  //for columns
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
		
		table=new JTable(records, header);
		JScrollPane pane=new JScrollPane(table);
		add(pane);
		
	}
	public static void main(String[] args) {
		DemoOfJTable_DB obj=new DemoOfJTable_DB();
		obj.setVisible(true);
	}

}
