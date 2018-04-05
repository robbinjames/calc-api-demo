package robin.java_webservice_samples.calcdemo_api.services;

import robin.java_webservice_samples.calcdemo_api.bo.*;

public class CalculatorServices {

    public int addition(Request request){
        Response response = new Response();

        response.setResult( (request.getFirst() + request.getSecond()) );
        return response.getResult();
    }

    public Response substraction(Request request){
        Response response = new Response();

        response.setResult( (request.getFirst() - request.getSecond()) );
        return response;
    }
}
