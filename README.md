Beeceptor API Evaluation
This project is aimed at automating the validation of API requests using Postman and Rest Assured. 
Introduction
This project demonstrates the use of Postman and Rest Assured for validating various API endpoints. 
Technologies Used
- Java, Rest Assured, TestNG, Postman, JSON

 Setup Instructions
 : Open the project in SpringtoolSuite
 : Added the necessary dependencies installed (Rest Assured, TestNG).
 <project xmlns="https://maven.apache.org/POM/4.0.0" xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>RestAssured</groupId>
  <artifactId>RestAssuredjava</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <dependencies>
	 <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>4.5.1</version>
    <scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.7.1</version>
    <scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.14.3</version>
</dependency>
<dependency>
   <groupId>io.rest-assured</groupId>
   <artifactId>json-path</artifactId>
   <version>4.5.1</version>
   </dependency>
<dependency>
   <groupId>io.rest-assured</groupId>
   <artifactId>xml-path</artifactId>
   <version>4.5.1</version>
   </dependency>
<dependency>
   <groupId>io.rest-assured</groupId>
   <artifactId>json-schema-validator</artifactId>
   <version>4.5.1</version>
   </dependency>

  </dependencies>
</project>

: Configure your Postman environment with the base URL `https://posthook-api.mock.beeceptor.com`.
Validated
- **Schedule a Hook**: `POST /v1/hooks`
- **Get Hooks**: `GET /v1/hooks`
- **Get a Hook by ID**: `GET /v1/hooks/c1ec9560-65fc-4b88-bfe0-1bc6e56cb3db`
- **Update a Hook**: `PUT /v1/projects`
- **Delete a Hook by ID**: `DELETE /v1/hooks/c1ec9560-65fc-4b88-bfe0-1bc6e56cb3db`

  Than write the test cases according to the above mentioned request
  Test Cases
 Get Hooks

@Test(enabled = false)
public void GetHooks() {
    RestAssured.baseURI = url;
    given().get("/v1/hooks").then().log().all();
}

@Test(enabled = false)
public void ScheduleHook() {
    RestAssured.baseURI = url;
    given().contentType(ContentType.JSON).when().post("/v1/hooks").then().log().all();
}

@Test(enabled = false)
public void GetHook() {
    RestAssured.baseURI = url;
    given().get("/v1/hooks/c1ec9560-65fc-4b88-bfe0-1bc6e56cb3db").then().log().all();
}

@Test(enabled = false)
public void deleteHook() {
    RestAssured.baseURI = url;
    given().delete("/v1/hooks/c1ec9560-65fc-4b88-bfe0-1bc6e56cb3db").then().log().all();
}
@Test (enabled = true)
public void PutHook() {
    RestAssured.baseURI = url;
    JSONObject js = new JSONObject();
    js.put("name", "updated-project");
    js.put("domain", "api.example.com");
    js.put("headerAuthorization", "");
    js.put("minRetries", 1);
    js.put("retryDelaySecs", 5);

    given().contentType("application/json").body(js.toJSONString()).when().put("/v1/projects/").then().log().all();
}
Running Tests
Using Rest Assured:Run the TestNG test cases.
Using Postman:Import the Postman collection provided in the repository, Set up the environment variables, Run the collection to validate all the endpoints


