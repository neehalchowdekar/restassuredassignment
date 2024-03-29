package com.reqres.applicationApi;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public final class RestResource {
	
	private RestResource() {}
	
	
	public static Response post(Object request, String path) {

		return given(SpecBuilder.getRequestSpec())
				.body(request)
				.when()
				.post(path)
				.then()
				.spec(SpecBuilder.getResponseSpec())
				.extract()
				.response();
	}
	
	public static Response get(String path, int pageNo) {
		return given(SpecBuilder.getRequestSpec())
				.when()
				.queryParam("page", pageNo)
				.get(path)
				.then()
				.spec(SpecBuilder.getResponseSpec())
				.extract()
				.response();
	}
	
	

}
