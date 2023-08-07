package endpointsapi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Userpayload;

import static io.restassured.RestAssured.given;

public class Curldendpoints {

	
	
	public static Response create(Userpayload userpload){
		
	 Response response= given().contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(userpload)
		.when().post(Routes.post_url);
		
		return response;
	}
	public static Response put(String pathparam, Userpayload payload){
		
		 Response response= given().contentType(ContentType.JSON).
			accept(ContentType.JSON)
			.pathParam("usernames", pathparam).body(payload)
			.when().put(Routes.put_url);
			
			return response;
		}
	
	public static Response read(String param){
		
		 Response response= given()
				 .pathParam("username", param)
			.when().get(Routes.get_url);
			
			return response;
		}
	
	public static Response delet(){
		
		 Response response= given()
			.when().delete(Routes.deleteurl);
			
		return response;
		}
	
	
}
