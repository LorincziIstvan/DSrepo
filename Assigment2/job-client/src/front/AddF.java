package front;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import job.model.Category;
import job.model.JobOffer;
import job.service.JobPost;

public class AddF  extends JFrame {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	 JButton button=new JButton("add");
	 JLabel lb1=new JLabel("Title");
	 JLabel lb2=new JLabel("Company");
	 JLabel lb3=new JLabel("Category");
	 JLabel lb4=new JLabel("Deadline");
	 JLabel lb5=new JLabel("Specification");
	 JLabel lb6=new JLabel("Contact");
	 JTextField tx1=new JTextField("Title");
	 JTextField tx2=new JTextField("Company");
	 JTextField tx3=new JTextField("Category");
	 JTextField tx4=new JTextField("2015-12-31");
	 JTextField tx5=new JTextField("Specification");
	 JTextField tx6=new JTextField("Contact");
	 JFrame frame=this;
	 
	 public Category getCat(String in) {
			if(in==null) return Category.IT;
			switch(in){
			case "IT": return Category.IT;
			case "FOOD": return Category.FOOD;
			case "ECONOMY": return Category.ECONOMY;
			default: return Category.IT;
			}
		}
	
	private void initAdd() {

		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try{
					Date d=Date.valueOf(tx4.getText());
					
							JobOffer jo=new JobOffer();
					jo.setTitle(tx1.getText());
					jo.setCompanyName(tx2.getText());
					jo.setCategory(getCat(tx3.getText()));
					//LocalDate d=LocalDate.of(year, month, dayOfMonth);
					jo.setDeadline(d);
					jo.setSpecification(tx5.getText());
					jo.setContact(tx6.getText());
				
				Registry registry;
				try {
				
					
					
					registry = LocateRegistry.getRegistry();
					JobPost jobPost = (JobPost) registry.lookup("jobPostService");
					jobPost.post(jo);
					
					JOptionPane.showMessageDialog(frame,
						    "New offer was added.",
						    "Post successful",
						    JOptionPane.INFORMATION_MESSAGE);
					
				} catch (RemoteException | NotBoundException  e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}catch(Exception eee) {
					
					JOptionPane.showMessageDialog(frame,
						    "Wrong date input.",
						    "Date error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
		
				
			}
		});
		
		panel.setLayout(new GridLayout(7, 2));
		panel.add(lb1);
		panel.add(tx1);
		panel.add(lb2);
		panel.add(tx2);
		panel.add(lb3);
		panel.add(tx3);
		panel.add(lb4);
		panel.add(tx4);
		panel.add(lb5);
		panel.add(tx5);
		panel.add(lb6);
		panel.add(tx6);
		panel.add(button);
	}
	
	public AddF() {
		initAdd();
		this.setSize(new Dimension(500,500));
		this.add(panel);
		this.setVisible(true);
	}
}
