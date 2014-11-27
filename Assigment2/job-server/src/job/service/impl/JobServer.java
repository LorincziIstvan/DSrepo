package job.service.impl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import job.service.JobPost;
import job.service.JobSearch;





public class JobServer {

	public static void main(String[] args)  {
		try{
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		Registry registry = LocateRegistry.getRegistry();
		
		JobPost jobPost = new JobPostImpl();
		JobPost jobPostStub = (JobPost) UnicastRemoteObject.exportObject(jobPost, 0);
		registry.rebind(JobPost.SERVICE_NAME, jobPostStub);
		
		JobSearch jobSearch = new JobSearchImpl();
		JobSearch jobSearchStub = (JobSearch) UnicastRemoteObject.exportObject(jobSearch, 0);
		registry.rebind(JobSearch.SERVICE_NAME, jobSearchStub);
		}
		catch(RemoteException e) {System.out.println("remote failed");}
		System.out.println("Running?2");
	}

}
