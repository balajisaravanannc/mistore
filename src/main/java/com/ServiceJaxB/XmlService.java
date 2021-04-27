package com.ServiceJaxB;

import java.io.IOException;

public interface XmlService {

    String convertObjectToXml(Object object);

    Object convertXmlToObject(String xml);
}
