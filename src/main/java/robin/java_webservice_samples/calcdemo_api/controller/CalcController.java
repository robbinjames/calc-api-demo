package robin.java_webservice_samples.calcdemo_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import robin.java_webservice_samples.calcdemo_api.bo.*;
import robin.java_webservice_samples.calcdemo_api.services.CalculatorServices;

@RestController
@RequestMapping(value="/calc")
public class CalcController {

    @Autowired
    private CalculatorServices mycalcService;

    // ------------------------------Query and Path Parameters Handling -----------------------

    //@GetMapping
    @RequestMapping(value="/add")
    public int Add( @RequestParam("firstNumber") int nFN,
                    @RequestParam("secondNumber") int nSN )
    {
        int res = -1;
        System.out.println("Add Operation");
        if( (nFN <= 0) || (nSN <= 0) )
        {
            System.out.println("Add Operation: Input error");
            return res;
        }

        res = nFN + nSN;
        System.out.println("Sum is " +  res );
        return res;
    }

    @RequestMapping(value="/sub/{firstNumber}/{secondNumber}")
    public int Sub( @PathVariable("firstNumber") int nFN,
                    @PathVariable("secondNumber") int nSN )
    {
        int res = -1;
        System.out.println("Sub Operation");
        if((nFN <= 0) || (nSN <= 0))
        {
            System.out.println("Substract Operation: Input error");
            return res;
        }

        res = nFN - nSN;
        System.out.println("Difference is " +  res );
        return res;
    }

    @RequestMapping(value="/mul")
    public int Mul( @RequestParam("firstNumber") int nFN,
                    @RequestParam("secondNumber") int nSN )
    {
        int res = -1;
        System.out.println("Mul Operation");
        if((nFN < 0) || (nSN < 0))
        {
            System.out.println("Multiply Operation: Input error");
            return res;
        }

        res = nFN * nSN;
        System.out.println("Product is " +  res );
        return res;
    }

    @RequestMapping(value="/div/{firstNumber}/{secondNumber}")
    public int Div( @PathVariable("firstNumber") int nFN,
                    @PathVariable("secondNumber") int nSN )
    {
        int res = -1;
        System.out.println("Division Operation");
        if((nFN < nSN) || ( nSN <=0 ))
        {
            System.out.println("Division Operation: Input error");
            return res;
        }

        res = nFN / nSN;
        System.out.println("Result is " +  res );
        return res;
    }

    //---------------------------With Bussiness Logic Objects on Request Body mode----------------------------
    @RequestMapping(value="/adtn")
    @PostMapping
    public Response adtn(@RequestBody Request request){
        Response response = new Response();

        response.setResult( (request.getFirst() + request.getSecond()) );
        return response;
    }

    @RequestMapping(value="/substn")
    @PostMapping
    public Response substn(@RequestBody Request request){
        Response response = new Response();

        response.setResult( (request.getFirst() - request.getSecond()) );
        return response;
    }

    // ----------------------------Removing Business Logic from Controller Class--------------------------

    @RequestMapping(value="/addition")
    @PostMapping
    public int addition( @RequestBody Request request){
        return  mycalcService.addition(request);
    }

    @RequestMapping(value="/substraction")
    @PostMapping
    public Response substraction(@RequestBody Request request){
        return mycalcService.substraction(request);
    }
}


