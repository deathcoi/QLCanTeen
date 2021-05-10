package service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import constant.HttpConstant;
import service.IpushMethodService;
import service.myhttpmethod.HttpDeleteWithEntity;
import service.myhttpmethod.HttpGetWithEntity;

public class PushMethodService implements IpushMethodService{

	public <T> String pushMethod(String requestType, String httpString, T obj) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {

//			HttpGet getRequest = new HttpGet(httpString);
//			HttpPost postRequest = new HttpPost(httpString);
//			HttpPut putRequest = new HttpPut(httpString);
//			HttpDelete deleteRequest = new HttpDelete(httpString);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(obj);
			StringEntity stringEntity = new StringEntity(json, "UTF-8");
			
			HttpResponse response = null;
			
			if (requestType.equals(HttpConstant.HTTPREQUESTGET)){
				HttpGetWithEntity getRequest = new HttpGetWithEntity(httpString);
				
				getRequest.setEntity(stringEntity);
				getRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				response = httpClient.execute(getRequest);
			} else if (requestType.equals(HttpConstant.HTTPREQUESTPOST)){
				HttpPost postRequest = new HttpPost(httpString);
				
				postRequest.setEntity(stringEntity);
				postRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				response = httpClient.execute(postRequest);
			} else if (requestType.equals(HttpConstant.HTTPREQUESTPUT)){
				HttpPut putRequest = new HttpPut(httpString);
				
				putRequest.setEntity(stringEntity);
				putRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				response = httpClient.execute(putRequest);
			} else if (requestType.equals(HttpConstant.HTTPREQUESTDELETE)){
				HttpDeleteWithEntity deleteRequest = new HttpDeleteWithEntity(httpString);
				
				deleteRequest.setEntity(stringEntity);
				deleteRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				response = httpClient.execute(deleteRequest);
			}
			
			
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			
			if (response.getEntity().getContentLength() == 0)
				throw new Exception("Error! Please check your ID or number format!");
			
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			StringBuilder output = new StringBuilder();
			String str;
			System.out.println("Output from Server .... \n");
			while ((str = br.readLine()) != null) {
				output.append(str);
				System.out.println(output);
			}
			
			return output.toString();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return null;
	}

	public <T> String pushMethod(String requestType, String httpString, String id) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {

//			HttpGet getRequest = new HttpGet(httpString);
//			HttpPost postRequest = new HttpPost(httpString);
//			HttpPut putRequest = new HttpPut(httpString);
//			HttpDelete deleteRequest = new HttpDelete(httpString);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(id);
			StringEntity stringEntity = new StringEntity(json, "UTF-8");
			
			HttpResponse response = null;
			
			if (requestType.equals(HttpConstant.HTTPREQUESTGET)){
				HttpGetWithEntity getRequest = new HttpGetWithEntity(httpString);
				
				getRequest.setEntity(stringEntity);
				getRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				response = httpClient.execute(getRequest);
			} else if (requestType.equals(HttpConstant.HTTPREQUESTPOST)){
				HttpPost postRequest = new HttpPost(httpString);
				
				postRequest.setEntity(stringEntity);
				postRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				response = httpClient.execute(postRequest);
			} else if (requestType.equals(HttpConstant.HTTPREQUESTPUT)){
				HttpPut putRequest = new HttpPut(httpString);
				
				putRequest.setEntity(stringEntity);
				putRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				response = httpClient.execute(putRequest);
			} else if (requestType.equals(HttpConstant.HTTPREQUESTDELETE)){
				HttpDeleteWithEntity deleteRequest = new HttpDeleteWithEntity(httpString);
				
				deleteRequest.setEntity(stringEntity);
				deleteRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				response = httpClient.execute(deleteRequest);
			}
			
			
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			StringBuilder output = new StringBuilder();
			String str;
			System.out.println("Output from Server .... \n");
			while ((str = br.readLine()) != null) {
				output.append(str);
				System.out.println(output);
			}
			System.out.println("Hết");
			return output.toString();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return null;
	}

	

}
