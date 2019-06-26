package site.yangpan.bean;

import site.yangpan.bean.IAnimal;

/**
 * Dog
 * Created by yangpan on 2019-06-26 15:36.
 */
public class Dog implements IAnimal {

    private String name;

    @Override
    public String eat() {
        return "dog " + name + " 喜欢吃肉。。";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


