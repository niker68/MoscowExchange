package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "table_histories")
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
public String boardid;
public Date tradedate;
String shortname;
@Column(name="secid", insertable = false, updatable = false)
String secid;
public Double numtrades;
public Double value;
public Double open;
public Double low;
public Double high;
public Double legalcloseprice;
Double warprice;
public Double close;
public Double volume;
public Double marketprice2;
public Double marketprice3;
public Double admittedvalue;
Double waval;
Double admittedquote;
Double mp2valtrd;
Double marketprice3tradesvalue;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "secid",referencedColumnName="secid")
private Security security;
public History(){

}

    public Security getSecurity() {
        return security;
    }

    public void setSecurity (Security security){
    this.security = security;
}

    public void setMp2valtrd(Double mp2valtrd) {
        this.mp2valtrd = mp2valtrd;
    }

    public void setMarketprice3tradesvalue(Double marketprice3tradesvalue) {
        this.marketprice3tradesvalue = marketprice3tradesvalue;
    }

    public String getSecid() {
        return secid;
    }

    public void setAdmittedquote(Double admittedquote) {
        this.admittedquote = admittedquote;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public void setNumtrades(Double numtrades) {
        this.numtrades = numtrades;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public void setLegalcloseprice(Double legalcloseprice) {
        this.legalcloseprice = legalcloseprice;
    }

    public void setWarprice(Double warpice) {
        this.warprice = warpice;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public void setMarketprice2(Double marketprice2) {
        this.marketprice2 = marketprice2;
    }

    public void setMarketprice3(Double marketprice3) {
        this.marketprice3 = marketprice3;
    }

    public void setAdmittedvalue(Double admittedvalue) {
        this.admittedvalue = admittedvalue;
    }

    public void setWaval(Double waval) {
        this.waval = waval;
    }

    @Override
    public String toString() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(tradedate);
        return "History{" +
                "boardid='" + boardid + '\'' +
                ", tradedate=" +calendar.get(Calendar.YEAR) +"-"+calendar.get(Calendar.MONTH) +"-"+calendar.get(Calendar.DAY_OF_MONTH)+
                ", shortname='" + shortname + '\'' +
                ", secid='" + secid + '\'' +
                ", numtrades=" + numtrades +
                ", value=" + value +
                ", open=" + open +
                ", low=" + low +
                ", high=" + high +
                ", legalclosepricel=" + legalcloseprice +
                ", warpice=" + warprice +
                ", close=" + close +
                ", volume=" + volume +
                ", marketprice2=" + marketprice2 +
                ", marketprice3=" + marketprice3 +
                ", admittedvalue=" + admittedvalue +
                ", waval=" + waval +
                ", admittedquote=" + admittedquote +
                ", mp2valtrd=" + mp2valtrd +
                ", marketprice3tradesvalue=" + marketprice3tradesvalue +
                '}';
    }
}
