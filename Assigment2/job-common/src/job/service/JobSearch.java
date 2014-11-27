package job.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import job.model.JobOffer;

public interface JobSearch extends Remote{
	
	public static String SERVICE_NAME = "jobSearchService";
	public List<JobOffer> searchByTitle(String title) throws RemoteException;
	public List<JobOffer> searchByCompany(String category) throws RemoteException;
	public List<JobOffer> searchByDeadline(Date from,Date to) throws RemoteException;
}
