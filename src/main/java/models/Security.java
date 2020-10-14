package models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "table_securities")
public class Security implements Serializable {
    @Id
    Integer id;
    String secid;
    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<History> histories ;

    String shortname;
    String regnumber;
    String name;
    String isin;
    int is_traded;
    int emitent_id;
    String emitent_title;
    String emitent_inn;
    String emitent_okpo;
    String gosreg;
    String type;
    @Column(name ="groupofsecurities")
    String group;
    String primary_boardid;
    String marketprice_boardid;

    public List<History> getHistories() {
        return histories;
    }

    public Security (){
        histories= new ArrayList<History>();
    }

    public void removeHistory(History history){
        histories.remove(history);
    }
    public List<History> getHistory(){
        return histories;
    }

    public void addHistory (History history){
        history.setSecurity(this);
        histories.add(history);
    }
    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public String getSecid() {
        return secid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public void setIs_traded(int is_traded) {
        this.is_traded = is_traded;
    }

    public void setEmitent_id(int emitent_id) {
        this.emitent_id = emitent_id;
    }

    public void setEmitent_title(String emitent_title) {
        this.emitent_title = emitent_title;
    }

    public void setEmitent_inn(String emitent_inn) {
        this.emitent_inn = emitent_inn;
    }

    public void setEmitent_okpo(String emitent_okpo) {
        this.emitent_okpo = emitent_okpo;
    }

    public void setGosreg(String gosreg) {
        this.gosreg = gosreg;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPrimary_boardid(String primary_boardid) {
        this.primary_boardid = primary_boardid;
    }

    public void setMarketprice_boardid(String marketprice_boardid) {
        this.marketprice_boardid = marketprice_boardid;
    }

    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", secid='" + secid + '\'' +
                ", shortname='" + shortname + '\'' +
                ", regnumber='" + regnumber + '\'' +
                ", name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", is_traded=" + is_traded +
                ", emitent_id=" + emitent_id +
                ", emitent_title='" + emitent_title + '\'' +
                ", emitent_inn='" + emitent_inn + '\'' +
                ", emitent_okpo='" + emitent_okpo + '\'' +
                ", gosreg='" + gosreg + '\'' +
                ", type='" + type + '\'' +
                ", group='" + group + '\'' +
                ", primary_boardid='" + primary_boardid + '\'' +
                ", marketprice_boardid='" + marketprice_boardid + '\'' +
                '}';
    }
}
