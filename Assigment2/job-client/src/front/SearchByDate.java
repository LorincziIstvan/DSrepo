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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import job.service.JobSearch;

public class SearchByDate extends JFrame {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel=new JPanel();
	 JButton button=new JButton("search");
	 JLabel lb1=new JLabel("Search from");
	 JLabel lb2=new JLabel("to");
	 JTextField tx1=new JTextField("2014-1-20");
	 JTextField tx2=new JTextField("2015-1-20");
	 JFrame frame=this;
	 
	 private void initSearch() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
				Date from=Date.valueOf(tx1.getText());
				Date to=Date.valueOf(tx2.getText());
				
				Registry registry;
				try {
					registry = LocateRegistry.getRegistry();
					JobSearch jobSearch = (JobSearch) registry.lookup("jobSearchService");
					List list=jobSearch.searchByDeadline(from,to);
					ResultF search=new ResultF(list);
					
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}catch(Exception eee ){JOptionPane.showMessageDialog(frame,
					    "Wrong date input.",
					    "Date error",
					    JOptionPane.ERROR_MESSAGE);}
				
			}
		});
		
		panel.setLayout(new GridLayout(1, 5));
		panel.add(lb1);
		panel.add(tx1);
		panel.add(lb2);
		panel.add(tx2);
		panel.add(button);
	 }
	 
	 public SearchByDate() {
			initSearch();
			this.setSize(new Dimension(500,200));
			this.add(panel);
			this.setVisible(true);
		}
	 
}
