package webapplicationtest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.utcn.ds.lab1.User;
import edu.utcn.ds.lab1.backend.Persistence;
import static org.mockito.Mockito.*;

public class PersistenceTest {
	
	private User testUser;
	private User testUpdateUser;
	private Persistence mockedConnection;
	@Before
	public void init() {
		testUser=new User("nameTEST", "passwordTEST", "displayNameTEST", "1.1.1900", "addressTEST", 0.0, 0.0, "user");
		testUpdateUser=new User("usernameTEST", "passwordUPDATE", "displayNameUPDATET", "2.2.1902", "addressTEST", 2.0, 2.0, "user");
		mockedConnection = mock(Persistence.class);
		when(mockedConnection.exists("usernameTEST")).thenReturn(false);
		when(mockedConnection.getUserByUsername("usernameTEST")).thenReturn(testUser);
		
		
	}
	
//	@Test
//	public void testInsert() {
//		
//		if(!mockedConnection.exists(testUser.getUsername())) {
//			mockedConnection.insert(testUser);}
//		
//			User searchUser=mockedConnection.getUserByUsername(testUser.getUsername());
//			assertEquals(testUser,searchUser );
//	
//	}
//	
//	public void mockDelete() {
//		when(mockedConnection.getUserByUsername("usernameTEST")).thenReturn(null);
//	}
//	
//	@Test
//	public void testDelete() {
//		
//		if(!mockedConnection.exists(testUser.getUsername())) {
//			mockedConnection.insert(testUser);}
//			mockedConnection.deleteUser(testUser.getUsername());
//			mockDelete();
//			User searchUser=mockedConnection.getUserByUsername(testUser.getUsername());
//			assertEquals(null,searchUser );
//	
//	}
//	
//	public void mockUpdate() {
//		
//		when(mockedConnection.getUserByUsername("usernameTEST")).thenReturn(testUpdateUser);
//	}
//	
//	
//	@Test
//	public void testUpdate() {
//		
//		if(!mockedConnection.exists(testUser.getUsername())) {
//			mockedConnection.insert(testUser);}
//			User updateUser=testUpdateUser;
//			mockedConnection.update(updateUser);
//			mockUpdate();
//			User searchUser=mockedConnection.getUserByUsername(testUser.getUsername());
//			assertEquals(updateUser,searchUser );
//	}
	
	
	@Test
	public void testInsertNoMock() {
		Persistence connection=new Persistence();
		if(!connection.exists(testUser.getUsername())) {
			connection.insert(testUser);}
		
			User searchUser=connection.getUserByUsername(testUser.getUsername());
			assertEquals(testUser.getUsername(),searchUser.getUsername());
			assertEquals(testUser.getAddress(),searchUser.getAddress());
			assertEquals(testUser.getDisplayName(),searchUser.getDisplayName());
			
	}
	
	
	@Test
	public void testDeleteNoMock() {
		Persistence connection=new Persistence();
		if(!connection.exists(testUser.getUsername())) {
			connection.insert(testUser);}
		
		if(connection.exists(testUser.getUsername())) {
			connection.deleteUser(testUser.getUsername());}
		
		
			User searchUser=connection.getUserByUsername(testUser.getUsername());
			assertEquals(null,searchUser);
			
	}
	
	@After
	public void cleanUp() {
		Persistence connection=new Persistence();
		if(connection.exists(testUser.getUsername())) {
		connection.deleteUser(testUser);}
	}

}
