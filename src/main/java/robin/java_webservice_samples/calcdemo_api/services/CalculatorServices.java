package robin.java_webservice_samples.calcdemo_api.services;

import org.springframework.stereotype.Service;
import robin.java_webservice_samples.calcdemo_api.bo.*;

@Service(value = "mycalcService")
public class CalculatorServices {

    //Service , Component ,

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
