package site.yangpan.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Configuration;
import site.yangpan.bean.Cat;
import site.yangpan.bean.Dog;

/**
 * MyBeanDefinitionRegistryPostProcessor: 实现自己实例化bean并注册为Spring管理
 * Created by yangpan on 2019-06-26 15:39.
 */
@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


    //bean 的名称生成器.
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();


    /**
     * 先执行：postProcessBeanDefinitionRegistry()方法，
     * 在执行：postProcessBeanFactory()方法。
     */


    /**
     * 用来注册bean
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("自定义bean注册处理器执行：postProcessBeanDefinitionRegistry()。。");
        /*
         * 在这里可以注入bean.
         */
        registerBean(registry, "dog", Dog.class);
        registerBean(registry, "cat", Cat.class);
    }


    /**
     * bean配置的工厂方法，在这个方法中可以获取到我们所有在postProcessBeanDefinitionRegistry方法中注册的所有bean，
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("自定义bean注册处理器执行：postProcessBeanFactory()");

        // 在这里我们可以进行属性的设置等操作
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("cat");
        MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
        mutablePropertyValues.add("name", "加菲");

        BeanDefinition beanDefinition2 = beanFactory.getBeanDefinition("dog");
        MutablePropertyValues mutablePropertyValues2 = beanDefinition2.getPropertyValues();
        mutablePropertyValues2.add("name", "史努比");
    }


    /**
     * 提供公共的注册方法
     * @param registry
     * @param name
     * @param beanClass
     */
    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass){
        AnnotatedBeanDefinition annotatedBeanDefinition  = new AnnotatedGenericBeanDefinition(beanClass);
        //可以自动生成name
        String beanName = (name != null?name:this.beanNameGenerator.generateBeanName(annotatedBeanDefinition, registry));
        //bean注册的holer类.
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, beanName);
        //使用bean注册工具类进行注册.
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, registry);
    }

}
