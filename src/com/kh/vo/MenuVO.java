package com.kh.vo;
// MENU_INFO, OPTION_INFO Table에 대한 VO (Value Object)
// 조인이 걸릴만한 객체를 전부 선언 해주고 시작하면 좋을 듯. 어차피 무결성은 db가 보장하니까.
// 그런 뒤 select 문에서 조인해서 필요한 것만 가져오면 될거같다..?
public class MenuVO {
    private String mname;       // 메뉴명
    private int mprice;         // 가격
    private String category;    // 카테고리

    public MenuVO(String mname, int mprice, String category) {
        this.mname = mname;
        this.mprice = mprice;
        this.category = category;
    }

    public MenuVO() {
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

//    public String getOname() {
//        return oname;
//    }
//
//    public void setOname(String oname) {
//        this.oname = oname;
//    }
//
//    public int getOprice() {
//        return oprice;
//    }
//
//    public void setOprice(int oprice) {
//        this.oprice = oprice;
//    }
}
