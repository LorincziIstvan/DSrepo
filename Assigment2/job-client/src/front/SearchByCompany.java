package front;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import job.model.JobOffer;
import job.service.JobSearch;

public class SearchByCompany extends JFrame {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel=new JPanel();
	 JButton button=new JButton("search");
	 JLabel lb1=new JLabel("Search by company");
	 JTextField tx1=new JTextField("search field");
	 
	 private void initSearch() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Registry registry;
				try {
					registry = LocateRegistry.getRegistry();
					JobSearch jobSearch = (JobSearch) registry.lookup("jobSearchService");
					List list=jobSearch.searchByCompany(tx1.getText());
					ResultF search=new ResultF(list);
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		panel.setLayout(new GridLayout(2, 2));
		panel.add(lb1);
		panel.add(tx1);
		panel.add(button);
	 }
	 
	 public SearchByCompany() {
			initSearch();
			this.setSize(new Dimension(500,500));
			this.add(panel);
			this.setVisible(true);
		}
	 
}
