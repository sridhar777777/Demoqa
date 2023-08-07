package testngtest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpointsapi.Curldendpoints;
import io.restassured.response.Response;
import payload.Userpayload;

public class Testuser {
      Faker faker;
      Userpayload userpload;
	@BeforeClass
	public void setupdata() {
		
		faker= new Faker();
		userpload=new Userpayload();
		userpload.setId(faker.idNumber().hashCode());
		userpload.setFirstName(faker.name().firstName());
		userpload.setEmail(faker.internet().safeEmailAddress());
		userpload.setLastName(faker.name().lastName());
		userpload.setPhone(faker.phoneNumber().cellPhone());
		userpload.setPassword(faker.internet().password(5,10));
		userpload.setUsername(faker.name().username());
		
	}
	
	@Test(enabled=false)
	public void posttestmetho() {
		
		Response responce=Curldendpoints.create(userpload);
		responce.then().log().all();
		System.out.println(responce);
	} 
	
	@Test(enabled=true)
	public void puttmethod() {

		userpload.setFirstName(faker.name().firstName());
		userpload.setEmail(faker.internet().safeEmailAddress());
		userpload.setLastName(faker.name().lastName());
		
		
		Response responce=Curldendpoints.put(this.userpload.getUsername(), userpload);
		responce.then().log().all();
		System.out.println(responce);
	} 
	
	
	@Test
	public void gettest() {
		
		Response responce=Curldendpoints.read(this.userpload.getUsername());
		responce.then().log().all();
		System.out.println(responce);
	}
	

}