package front;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import job.model.JobOffer;

public class Display extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar bar;
	private JMenuItem addM;
	private JMenuItem searchM;
	private JMenuItem searchbyDateM;
	private JMenuItem searchbyCompanyM;
	
	


	
	
	private void initMenu() {
		bar=new JMenuBar();
		addM=new JMenuItem("Add");
		addM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddF add=new AddF();
				
			}
		});
		searchM=new JMenuItem("Search");
		searchM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchF search=new SearchF();
				
			}
		});
		
		searchbyDateM=new JMenuItem("Search by date");
		searchbyDateM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchByDate search=new SearchByDate();
				
			}
		});
		
		searchbyCompanyM=new JMenuItem("Search by company");
		searchbyCompanyM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchByCompany search=new SearchByCompany();
				
			}
		});
		bar.add(addM);
		bar.add(searchM);
		bar.add(searchbyDateM);
		bar.add(searchbyCompanyM);
	}
	

	
	private void init(){
		initMenu();
	}
	public Display()
	{
		
		init();
		this.setSize(new Dimension(500,500));
		//current=add;
		//this.add(current);
		this.setJMenuBar(bar);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
