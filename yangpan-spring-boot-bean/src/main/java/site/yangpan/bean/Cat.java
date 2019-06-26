package site.yangpan.bean;

import site.yangpan.bean.IAnimal;

/**
 * Cat
 * Created by yangpan on 2019-06-26 15:37.
 */
public class Cat implements IAnimal {

    private String name;

    @Override
    public String eat() {
        return "cat " + name + " 喜欢吃鱼。。";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
