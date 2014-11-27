package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import job.model.Category;
import job.model.JobOffer;
import job.persistence.JobOfferPersistence;
import job.service.impl.JobPostImpl;
import job.service.impl.JobSearchImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JobServiceTest {
	
	
	@Before
	public void testPost(){
		
		//JobPostImpl post=new JobPostImpl();
		JobOffer offer=new JobOffer();
		offer.setTitle("TestTitle");
		offer.setCategory(Category.ECONOMY);
		offer.setCompanyName("TestCompany");
		offer.setContact("TestContact");
		offer.setDeadline(Date.valueOf("1900-1-2"));
		offer.setSpecification("TestSpecification");
		JobOfferPersistence persistence=new JobOfferPersistence();
		persistence.insert(offer);
		/*
		try {
			post.post(offer);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		assert(true);
		*/
	}
	
	@Test
	public void testSearchByTitle() {
		JobSearchImpl search=new JobSearchImpl();
		List<JobOffer> list;
		try {
			list = search.searchByTitle("TestTitle");
			assertEquals(1,list.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		}
	
	@Test
	public void testSearchByCompany() {
		JobSearchImpl search=new JobSearchImpl();
		List<JobOffer> list;
		try {
			list = search.searchByCompany("TestCompany");
			assertEquals(1,list.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		}
	
	@Test
	public void testSearchByDeadline() {
		JobSearchImpl search=new JobSearchImpl();
		List<JobOffer> list;
		try {
			list = search.searchByDeadline(Date.valueOf("1900-1-1"), Date.valueOf("1900-1-3"));
			assertEquals(1,list.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		}
	
	@After
	public void teardown(){
		JobOfferPersistence persistence=new JobOfferPersistence();
		persistence.deleteJobOffer("TestTitle");
	}
	
	

}
