import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBookBy extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBookBy frame = new SearchBookBy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchBookBy() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 597, 416);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel lblSearchBookBy = new JLabel("Search Book By");
		
		String value[]={"Select","All","Author","Category","Subject","Publication"};
		JComboBox comboBox = new JComboBox(value);
		
		JButton btnClickToSearch = new JButton("Click To Search");
		btnClickToSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
		        String str=(String)comboBox.getSelectedItem();
		        System.out.println(str);
		        if(str.equalsIgnoreCase("select"))
		        {
		        JOptionPane.showMessageDialog(getParent(), "Select any option", "Error", JOptionPane.ERROR_MESSAGE);	
		        }
		       
		        else
		        {
			        if(str.equalsIgnoreCase("all"))
			        {
			          GetValues.getAllBooks();
			          
			          JFrame obj=new JFrame();
				        obj.setSize(700, 500);
				        obj.setLocationRelativeTo(getParent());
				        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				        
				        JTable table=new JTable(GetValues.records, GetValues.header);
				        JScrollPane pane=new JScrollPane(table);
				        obj.add(pane);
				        obj.setVisible(true);
			        	
			        	
			        }
			        else
			        {
			        String value=JOptionPane.showInputDialog("Enter "+str+" name");
			        System.out.println(value);
			        
			        GetValues.getBook(str, value);
			        
			        JFrame obj=new JFrame();
			        obj.setSize(700, 500);
			        obj.setLocationRelativeTo(getParent());
			        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			        
			        JTable table=new JTable(GetValues.records, GetValues.header);
			        JScrollPane pane=new JScrollPane(table);
			        obj.add(pane);
			        obj.setVisible(true);
			        
			        
			        
			        
			        
			        }
		        }
		       
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(119)
							.addComponent(lblSearchBookBy)
							.addGap(62)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(183)
							.addComponent(btnClickToSearch, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSearchBookBy)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnClickToSearch)
					.addContainerGap(196, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
