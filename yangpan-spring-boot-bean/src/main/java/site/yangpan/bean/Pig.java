package site.yangpan.bean;

import site.yangpan.bean.IAnimal;

/**
 * Pig
 * Created by yangpan on 2019-06-26 15:37.
 */
public class Pig implements IAnimal {

    private String name;

    @Override
    public String eat() {
        return "pig " + name + " 喜欢吃白菜。。";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
