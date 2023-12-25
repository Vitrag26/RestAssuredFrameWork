package api.endPoint;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class userEndPoint_1 {
	
	
	static ResourceBundle geturl()
	{
		ResourceBundle rs=ResourceBundle.getBundle("roots");
		return rs;
	}
	
	
public static Response	createUser(user payload)
{
	String post_url=geturl().getString("post_url");
	 Response response= given()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.body(payload)
	.when ()
	
	.post(post_url);
	
	return response;
	
}

public static Response	getUser(String userName)
{
	String get_url=geturl().getString("get_url");

	 Response response= given()
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	.when ()
	
	.get(get_url);
	return response;
	
}

public static Response	putUser(String userName,user payload)
{
	String put_url=geturl().getString("put_url");

	 Response response= given()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.pathParam("username", userName)
	.body(payload)
	.when ()
	
	.put(put_url);
	return response;
	
}

public static Response	delUser(String userName)
{
	String del_url=geturl().getString("del_url");

	 Response response= given()
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	.when ()
	
	.delete(del_url);
	return response;
	
}
	

}
