package site.yangpan.jdbc.entity;

/**
 * AccountEntity
 * Created by yangpan on 2019-06-24 17:05.
 */
public class AccountEntity {

    private int id ;
    private String name ;
    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
