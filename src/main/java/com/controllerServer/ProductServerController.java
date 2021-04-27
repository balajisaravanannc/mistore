package com.controllerServer;

import com.serviceServer.ProductServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductServerController {

    @Autowired
    private ProductServerService productServerService;

    //Marshallaing
    @RequestMapping(value = "/getAllProductDtoIntoJson")
    @ResponseBody
    public String getAllProductDtoIntoJson(){

        return productServerService.getAllProductDtoIntoJson();
    }

    @RequestMapping(value = "/getProductDtoIntoJsonById/{productId}")
    @ResponseBody                                                           //getProductDtoIntoJsonById?productId=2---queryParameter
    public String getProductDtoIntoJsonById(@PathVariable int productId){  //@RequestParam int productId

        return productServerService.getProductDtoIntoJsonById(productId);
    }

    @RequestMapping(value = "/getProductDtoIntoJsonToDelete/{productId}")
    @ResponseBody
    public String getProductDtoIntoJsonToDelete(@PathVariable int productId){

        return productServerService.getProductDtoIntoJsonToDelete(productId);
    }

}
