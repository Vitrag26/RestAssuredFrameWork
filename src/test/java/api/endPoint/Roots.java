package api.endPoint;

public class Roots {
	
	
	/*
	 * https://petstore.swagger.io/v2/user
	 * https://petstore.swagger.io/v2/user/{username}
	 * https://petstore.swagger.io/v2/user/{username}
	 * https://petstore.swagger.io/v2/user/{username}
	 */
public static String base_url="https://petstore.swagger.io/v2";

//user module url

public static String post_url=base_url + "/user";
public static String get_url=base_url + "/user/{username}";
public static String put_url=base_url + "/user/{username}";
public static String del_url=base_url + "/user/{username}";

}
