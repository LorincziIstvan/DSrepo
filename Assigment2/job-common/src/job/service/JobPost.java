package job.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import job.model.JobOffer;

public interface JobPost extends Remote {
	public static String SERVICE_NAME = "jobPostService";

	public void post(JobOffer offer) throws RemoteException;
}
