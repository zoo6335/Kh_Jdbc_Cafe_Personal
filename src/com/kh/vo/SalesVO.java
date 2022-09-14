package com.kh.vo;
// 매출조회 관련 Value Objects
import java.sql.Date;

public class SalesVO {
    private String mname;
    private int mprice;
    private String category;
    private String oname;
    private int oprice;
    private int ordnum;
    private Date orddate;
    private String ordDateM;
    private int salesRate;
    private int salesTotal;

    public SalesVO(String mname, int mprice, String category, String oname, int oprice, int ordnum, Date orddate, String ordDateM, int salesRate, int salesTotal) {
        this.mname = mname;
        this.mprice = mprice;
        this.category = category;
        this.oname = oname;
        this.oprice = oprice;
        this.ordnum = ordnum;
        this.orddate = orddate;
        this.ordDateM = ordDateM;
        this.salesRate = salesRate;
        this.salesTotal = salesTotal;
    }

    public SalesVO() {
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getMprice() {
        return mprice;
    }

    public void setMprice(int mprice) {
        this.mprice = mprice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public int getOprice() {
        return oprice;
    }

    public void setOprice(int oprice) {
        this.oprice = oprice;
    }

    public int getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(int ordnum) {
        this.ordnum = ordnum;
    }

    public Date getOrddate() {
        return orddate;
    }

    public void setOrddate(Date orddate) {
        this.orddate = orddate;
    }

    public String getOrdDateM() {
        return ordDateM;
    }

    public void setOrdDateM(String ordDateM) {
        this.ordDateM = ordDateM;
    }

    public int getSalesRate() {
        return salesRate;
    }

    public void setSalesRate(int salesRate) {
        this.salesRate = salesRate;
    }

    public int getSalesTotal() {
        return salesTotal;
    }

    public void setSalesTotal(int salesTotal) {
        this.salesTotal = salesTotal;
    }
}