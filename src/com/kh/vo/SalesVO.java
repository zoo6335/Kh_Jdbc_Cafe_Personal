package com.kh.vo;
// 매출조회 관련 Value Objects
import java.sql.Date;

public class SalesVO {
    private String mname;
    private int mprice;
    private String category;
    private String oname;
    private int oprice;
    private int orderno;
    private Date odate;

    public SalesVO(String mname, int mprice, String category, String oname, int oprice, int orderno, Date odate) {
        this.mname = mname;
        this.mprice = mprice;
        this.category = category;
        this.oname = oname;
        this.oprice = oprice;
        this.orderno = orderno;
        this.odate = odate;
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

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }
}
