package front;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import job.model.JobOffer;

public class ResultF extends JFrame {

	 JPanel panel=new JPanel();
	 JTable table;
	 String[] header={"Title","Company","Category","Deadline","Specification","Contact"};
	 
	 private void initSearch(List<JobOffer> list) {
		
		 Object[][] data=new Object[list.size()][6];
		 for(int i =0;i<list.size();i++)
		 {
			 data[i][0]=list.get(i).getTitle();
			 data[i][1]=list.get(i).getCompanyName();
			 data[i][2]=list.get(i).getCategory();
			 data[i][3]=list.get(i).getDeadline();
			 data[i][4]=list.get(i).getSpecification();
			 data[i][5]=list.get(i).getContact();
		 }
		
		table=new JTable(data,header);
		panel.add(table);
	 }
	 
	 public ResultF(List<JobOffer> list) {
			initSearch(list);
			this.setSize(new Dimension(500,500));
			this.add(panel);
			this.setVisible(true);
		}
	 
}
