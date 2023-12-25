package api.testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.payload.*;


import api.endPoint.userEndPoint;
import io.restassured.response.Response;

public class UsertestDo {
	user userpayload;

@Test(priority = 1,dataProvider ="AllData",dataProviderClass =DataProvider.class)

public void testCreatUser(String userId,String userName,String fname,String lname,String email,String pwd,String Phone)
	{
	user userpayload=new user();
	
	userpayload.setId(Integer.parseInt(userId));
	userpayload.setUsername(userName);
	userpayload.setFirstName(fname);
	userpayload.setLastName(lname);
	userpayload.setEmail(email);
	userpayload.setPhone(pwd);
	userpayload.setPassword(Phone);		
	
	Response response=userEndPoint.createUser(userpayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	}

}
