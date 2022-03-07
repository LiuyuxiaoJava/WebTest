package com.test.entity;

/**
 * @author Liuyuxiao
 * @version 1.0
 * @description: TODO
 * @date 2022/3/6 10:57
 */
public class Caipin {
    private Long id;
    private String caiName;
    private String kouwei;
    private Float price;
    private String pic;
    private String miaoshu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaiName() {
        return caiName;
    }

    public void setCaiName(String caiName) {
        this.caiName = caiName;
    }

    public String getKouwei() {
        return kouwei;
    }

    public void setKouwei(String kouwei) {
        this.kouwei = kouwei;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

    public Caipin() {
    }

    public Caipin(Long id, String caiName, String kouwei, Float price, String pic, String miaoshu) {
        this.id = id;
        this.caiName = caiName;
        this.kouwei = kouwei;
        this.price = price;
        this.pic = pic;
        this.miaoshu = miaoshu;
    }

    @Override
    public String toString() {
        return "Caipin{" +
                "id=" + id +
                ", caiName='" + caiName + '\'' +
                ", kouwei='" + kouwei + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", miaoshu='" + miaoshu + '\'' +
                '}';
    }
}

