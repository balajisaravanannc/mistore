package com.service;

import com.dto.ProductDto;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class OxmService {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public String convertOneProductDtoObjectToXmlByProductId(ProductDto productDto) throws IOException {
        StringWriter stringWriter = new StringWriter();
        getMarshaller().marshal(productDto, new StreamResult(stringWriter));

        return stringWriter.toString();
    }

    public String convertFromProductDtoObjectToXml(List<ProductDto> productDto) throws IOException {
        StringWriter stringWriter = new StringWriter();
        getMarshaller().marshal(productDto, new StreamResult(stringWriter));

        return stringWriter.toString();
    }

    public Object convertFromXmlToProductDtoObject(String xml) {
        StringReader stringReader = new StringReader(xml);
        try {
            return getUnmarshaller().unmarshal(new StreamSource(stringReader));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Marshaller getMarshaller() {

        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {

        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
}