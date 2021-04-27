package com.serviceClient;

import com.dto.KeerthiProductDto;
import com.dto.ReqresDto;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//UnMarshalling
public class RestClientServiceImpl implements RestClientService {

    private RestTemplate restTemplate;

    //StringToObject
    @Override
    public ReqresDto getRestData(int pageNumber) {
        String url = "https://reqres.in/api/users?page="+pageNumber;
        ReqresDto reqresDto = getRestTemplate().getForObject(url, ReqresDto.class);

        return reqresDto;
    }

    @Override
    public List<KeerthiProductDto> getAllKeerthiProduct() {
        String url = "http://10.255.255.225:8080/RestKMart_war_exploded/getProductIntoJson";
        ResponseEntity<KeerthiProductDto[]> keerthiProductDto = getRestTemplate().getForEntity(url, KeerthiProductDto[].class);

        if(keerthiProductDto.getBody() != null){
            return Arrays.asList(keerthiProductDto.getBody());
        }
        return Collections.emptyList();
    }

    @Override
    public KeerthiProductDto getKeerthiProductByID(int id) {
        String url = "http://10.255.255.225:8080/RestKMart_war_exploded/getById/"+id;
        KeerthiProductDto keerthiProductDto = getRestTemplate().getForObject(url, KeerthiProductDto.class);

        System.out.println(keerthiProductDto);
        return keerthiProductDto;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Required
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
