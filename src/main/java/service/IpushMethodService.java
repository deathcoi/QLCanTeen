package service;

public interface IpushMethodService {
	<T> String pushMethod(String requestType, String httpString, T obj);
	<T> String pushMethod(String requestType, String httpString, String str);
}
