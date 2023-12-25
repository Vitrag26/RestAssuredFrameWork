package api.endPoint;
import static io.restassured.RestAssured.given;
import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class userEndPoint {
	
public static Response	createUser(user payload)
{
	 Response response= given()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.body(payload)
	.when ()
	
	.post(Roots.post_url);
	
	return response;
	
}

public static Response	getUser(String userName)
{
	 Response response= given()
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	.when ()
	
	.get(Roots.get_url);
	return response;
	
}

public static Response	putUser(String userName,user payload)
{
	 Response response= given()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.pathParam("username", userName)
	.body(payload)
	.when ()
	
	.put(Roots.put_url);
	return response;
	
}

public static Response	delUser(String userName)
{
	 Response response= given()
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	.when ()
	
	.delete(Roots.del_url);
	return response;
	
}
	

}
