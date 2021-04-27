package com.dto;

import javax.xml.bind.annotation.*;
import java.lang.reflect.Field;
import java.util.Arrays;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqresDto {

    @XmlElement
    private int page;
    @XmlElement
    private int per_page;
    @XmlElement
    private int total;
    @XmlElement
    private int total_pages;
    @XmlElement
    private DataDto[] data;
    @XmlElement
    private SupportDto support;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public DataDto[] getData() {
        return data;
    }

    public void setData(DataDto[] data) {
        this.data = data;
    }

    public SupportDto getSupport() {
        return support;
    }

    public void setSupport(SupportDto support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "ReqresDto{" +
                "page=" + page +
                ", per_page=" + per_page +
                ", total=" + total +
                ", total_pages=" + total_pages +
                ", data=" + Arrays.toString(data) +
                ", support=" + support +
                '}';
    }
}
