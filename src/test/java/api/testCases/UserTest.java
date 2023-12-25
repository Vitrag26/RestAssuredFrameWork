package api.testCases;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoint.userEndPoint;
import api.payload.user;
import groovyjarjarantlr4.v4.runtime.misc.LogManager;
import io.restassured.response.Response;

public class UserTest {
	Faker fake;
	user userpayload;
	public static org.apache.log4j.Logger Logger;
	@BeforeClass
	public void generateTestData()
	{
		
		fake=new Faker();
		userpayload=new user();
		
		userpayload.setId(fake.idNumber().hashCode());
		userpayload.setUsername(fake.name().username());
		userpayload.setFirstName(fake.name().firstName());
		userpayload.setLastName(fake.name().lastName());
		userpayload.setEmail(fake.internet().safeEmailAddress());
		userpayload.setPhone(fake.phoneNumber().cellPhone());
		userpayload.setPassword(fake.internet().password(5,10));
		Logger=org.apache.log4j.LogManager.getLogger("iconicle");
		
	} 
	@Test(priority = 1)
	public void testCreatUser()
	{
		System.out.println(userpayload.getUsername());
	Response response=userEndPoint.createUser(userpayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	Logger.info("Created user Data Created");
	}
	@Test(priority = 2)

	public void testgetUser()
	{
	Response response=userEndPoint.getUser(this.userpayload.getUsername());
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	Logger.info("Get user Data Created");

	}
	@Test(priority = 3)
	public void testupdateUser()
	{
		userpayload.setFirstName(fake.name().firstName());

	Response response=userEndPoint.putUser(this.userpayload.getUsername(), userpayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	Logger.info("Update user Data Created");

	}
	@Test(priority = 4)
	public void testdelUser()
	{

	Response response=userEndPoint.delUser(this.userpayload.getUsername());
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	Logger.info("Delete user Data Created");

	}
}

