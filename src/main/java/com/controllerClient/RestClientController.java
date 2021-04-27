package com.controllerClient;

import com.ServiceJaxB.XmlService;
import com.dto.KeerthiProductDto;
import com.dto.ReqresDto;
import com.serviceClient.RestClientService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.List;

//Marshalling & UnMarshalling
@Controller
public class RestClientController {

    @Autowired
    private RestClientService restClientService;

    @Autowired
    private XmlService xmlService;

    //StringToObject
    @RequestMapping(value = "/getRestData", method = RequestMethod.GET)
    public String getRestData(Model model) throws IOException {

        ReqresDto reqresDto = restClientService.getRestData(2);
        model.addAttribute("reqresDto", reqresDto);

        String xml = xmlService.convertObjectToXml(reqresDto);
        model.addAttribute("xml", xml);

        Object object = xmlService.convertXmlToObject(xml);
        model.addAttribute("object", object);

        return "getRestDataPage";
    }

    @RequestMapping(value = "/getAllKeerthiProduct", method = RequestMethod.GET)
    public String getAllKeerthiProduct(Model model) {

        List<KeerthiProductDto> KeerthiProductDto = restClientService.getAllKeerthiProduct();
        model.addAttribute("KeerthiProductDto", KeerthiProductDto);

        return "getAllKeerthiProductPage";
    }

    @RequestMapping(value = "/getKeerthiProductByID", method = RequestMethod.GET)
    public String getKeerthiProductByID(@RequestParam int productId, Model model) {

        KeerthiProductDto KeerthiProductDto = restClientService.getKeerthiProductByID(productId);
        model.addAttribute("KeerthiProductDto", KeerthiProductDto);

        return "getKeerthiProductByIDPage";
    }

    @RequestMapping(value = "/download")
    public void downloadAndVerifyFile() throws IOException {

        ReqresDto reqresDto = restClientService.getRestData(2);
        String xml = xmlService.convertObjectToXml(reqresDto);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("C:/Users/balaj/Documents/xmlFile.txt"), xml);

//        try (BufferedInputStream inputStream = new BufferedInputStream(new URL("http://localhost:8081/MiStore_war_exploded/getRestData").openStream());
//
//             FileOutputStream fileOS = new FileOutputStream("C:/Users/balaj/Documents/xmlFile.txt")) {
//            byte data[] = new byte[1024];
//            int byteContent;
//            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
//                fileOS.write(data, 0, byteContent);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }

    }
}
