package job.service.impl;

import java.rmi.RemoteException;

import job.model.JobOffer;
import job.persistence.JobOfferPersistence;
import job.service.JobPost;

public class JobPostImpl implements JobPost {

	@Override
	public void post(JobOffer offer) throws RemoteException {
		JobOfferPersistence jobOfferPersistence=new JobOfferPersistence();
		jobOfferPersistence.insert(offer);
	}

}
