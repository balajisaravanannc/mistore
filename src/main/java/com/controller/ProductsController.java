package com.controller;

import com.customvalidator.ProductValidator;
import com.dto.PriceDto;
import com.dto.ProductDto;
import com.service.ProductsService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    @Qualifier("productsService")
    private ProductsService productsService;

    @Autowired
    @Qualifier("productValidator")
    private ProductValidator productValidator;

    private static final Logger logger = LogManager.getLogger(ProductsController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        logger.info("inside the initBinder method");

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(false);
        binder.registerCustomEditor(String.class,"name", stringTrimmerEditor);
    }

    @RequestMapping(value = "/addProducts", method = RequestMethod.GET)
    public String addProducts(Model model) {
        BasicConfigurator.configure();
        model.addAttribute("productDto",new ProductDto());

        return "addProductsPage";
    }

    @RequestMapping(value = "/addProductsSave", method = RequestMethod.POST)
    public String addProductsSave(@Valid @ModelAttribute ProductDto productDto, BindingResult bindingResult) {
        productValidator.validate(productDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return "addProductsPage";
        }else{
            productsService.addProductsSave(productDto);
            logger.info("addProductsSave method where i save which get from user");

            return "redirect:/getAllShowProducts";
        }
    }

    @RequestMapping(value = "/getAllShowProducts", method = RequestMethod.GET)
    public String getAllShowProducts(Model model) {
        List<ProductDto> products = productsService.getAllShowProducts();
        model.addAttribute("products", products);
        logger.info("getting all the products from database");

        return "getAllShowProductsPage";
    }

    @RequestMapping(value = "/editGetAllShowProducts/{productId}")
    public String editGetAllShowProducts(@PathVariable int productId, Model model) {
        ProductDto products = productsService.getProductById(productId);
        model.addAttribute("products", products);

        return "editGetAllShowProductsPage";
    }

    @RequestMapping(value = "/updateGetAllShowProducts", method = RequestMethod.POST)
    public String updateGetAllShowProducts(@ModelAttribute ProductDto productDto) {
        productsService.update(productDto);

        return "redirect:/getAllShowProducts";
    }

    @RequestMapping(value = "/deleteInGetAllShowProducts/{productId}", method = RequestMethod.GET)
    public String deleteInGetAllShowProducts(@PathVariable int productId) {
        productsService.delete(productId);

        return "redirect:/getAllShowProducts";
    }

    @RequestMapping(value = "/showProducts", method = RequestMethod.GET)
    public String showProducts(@ModelAttribute PriceDto priceDto, Model model) {
        List<ProductDto> products = productsService.showProducts();
        model.addAttribute("products", products);

        return "showProductsPage";
    }

    @RequestMapping(value = "/getDetailsById/{productId}", method = RequestMethod.GET)
    public String getDetailsById(@PathVariable int productId, Model model) {
        ProductDto products = productsService.getDetailsById(productId);
        model.addAttribute("products", products);

        return "getDetailsByIdPage";
    }

    @RequestMapping(value = "/getDetailsByName/{productName}", method = RequestMethod.GET)
    public String getDetailsByName(@PathVariable String productName, Model model) {
        List<ProductDto> products = productsService.getDetailsByName(productName);
        model.addAttribute("products", products);

        return "getDetailsByNamePage";
    }

    @RequestMapping(value = "/editShowProducts")
    public String editshowProducts(@RequestParam int productId, Model model) {
        ProductDto products = productsService.getProductById(productId);
        model.addAttribute("products", products);

        return "editShowProductsPage";
    }

    @RequestMapping(value = "/updateShowProducts", method = RequestMethod.POST)
    public String updateshowProducts(@ModelAttribute ProductDto productDto) {
        productsService.update(productDto);

        return "redirect:/showProducts";
    }

    @RequestMapping(value = "/deleteShowProducts", method = RequestMethod.GET)
    public String deleteShowProducts(@RequestParam int productId) {
        productsService.delete(productId);

        return "redirect:/showProducts";
    }

    //remote date server
    @RequestMapping(value = "/restData", produces = {"application/json"})
    @ResponseBody
    public JSONArray getRestData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "spider");
        jsonObject.put("count", "8");

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "Feb21");
        jsonObject1.put("count", "4");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject1);

        return jsonArray;
    }

    public static Logger getLogger() {

        return logger;
    }
}
