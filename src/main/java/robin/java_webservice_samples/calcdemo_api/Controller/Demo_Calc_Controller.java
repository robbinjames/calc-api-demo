package robin.java_webservice_samples.calcdemo_api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value="/Calc")
public class Demo_Calc_Controller {

    //@GetMapping
    @RequestMapping(value="/Add")
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

    @RequestMapping(value="/Sub/{firstNumber}/{secondNumber}")
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

    @RequestMapping(value="/Mul")
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

    @RequestMapping(value="/Div/{firstNumber}/{secondNumber}")
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
}
