package com.serviceClient;

import com.dto.KeerthiProductDto;
import com.dto.ReqresDto;

import java.util.List;

public interface RestClientService {

    ReqresDto getRestData(int pageNumber);

    List<KeerthiProductDto> getAllKeerthiProduct();

    KeerthiProductDto getKeerthiProductByID(int id);

}
