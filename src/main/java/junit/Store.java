package junit;

import java.util.Hashtable;

public class Store
{
	private Hashtable<String, junit.RequestResponse> responses = new Hashtable<String, junit.RequestResponse>();
	
	/**
	 * Learn to respond to a request
	 * @param request
	 * @param response
	 */
	public void learnResponse(String request, String response)
	{
		responses.put(request, new junit.RequestResponse(request, response));
	}
	
	/**
	 * @param request
	 * @return The response to a request
	 */
	public String getResponse(String request)
	{
		junit.RequestResponse requestReponse = responses.get(request);
		if(requestReponse == null)
		{
			return null;
		}
		return requestReponse.getResponse();
	}
	
	/**
	 * Forget all learned responses
	 */
	public void unlearnAll()
	{
		responses = new Hashtable<String, RequestResponse>();
	}
}
