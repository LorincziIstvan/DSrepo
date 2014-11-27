package job.service.impl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import job.model.JobOffer;
import job.persistence.JobOfferPersistence;
import job.service.JobSearch;

public class JobSearchImpl implements JobSearch{

	@Override
	public List<JobOffer> searchByTitle(String title) throws RemoteException {
		List<JobOffer>list;
		JobOfferPersistence jobOfferPersistence=new JobOfferPersistence();
		list=jobOfferPersistence.getJobOffers();
		List<JobOffer> list2=new ArrayList<JobOffer>();
		for(Object o :list) {
			JobOffer jo=(JobOffer)o;
			if(jo.getTitle().toLowerCase().contains(title.toLowerCase())) {list2.add(jo);}
		}
		if(title.equals("*")) {return list;}
		else {
		return list2;
		}
		
		
	}

	@Override
	public List<JobOffer> searchByCompany(String company)
			throws RemoteException {
		List<JobOffer>list;
		JobOfferPersistence jobOfferPersistence=new JobOfferPersistence();
		list=jobOfferPersistence.getJobOffers();
		
		List<JobOffer> list2=new ArrayList<JobOffer>();
		for(Object o :list) {
			JobOffer jo=(JobOffer)o;
			if(jo.getCompanyName().toLowerCase().contains(company.toLowerCase())) {list2.add(jo);}
		}
		if(company.equals("*")) {return list;}
		else {
		return list2;
		}
		
	}

	@Override
	public List<JobOffer> searchByDeadline(Date from, Date to)
			throws RemoteException {
		List<JobOffer>list;
		JobOfferPersistence jobOfferPersistence=new JobOfferPersistence();
		list=jobOfferPersistence.getJobOffers();
		ArrayList<JobOffer> list2=new ArrayList<JobOffer>();
		for(Object o :list) {
			JobOffer jo=(JobOffer)o;
			if(jo.getDeadline().after(from) &&
					jo.getDeadline().before(to)) {list2.add(jo);}
		}
		return list2;
	}

}
