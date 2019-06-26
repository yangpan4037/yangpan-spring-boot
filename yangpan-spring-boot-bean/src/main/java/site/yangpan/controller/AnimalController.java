package site.yangpan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.bean.IAnimal;

/**
 * 描述
 * Created by yangpan on 2019-06-26 15:42.
 */
@RestController
@RequestMapping("/animal")
public class AnimalController {

    /**
     * 用注解使用我们的bean
     */
    @Autowired
    private IAnimal dog;

    @Autowired
    private IAnimal cat;

    @Autowired
    private IAnimal pig;

    @RequestMapping("/dog")
    public String dog(){
        return dog.eat();
    }

    @RequestMapping("/cat")
    public String cat(){
        return cat.eat();
    }

    @RequestMapping("/pig")
    public String pig(){
        return pig.eat();
    }
}
