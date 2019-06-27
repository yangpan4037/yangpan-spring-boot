package site.yangpan.environment.aware.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 实现接口EnvironmentAware就能获取到系统环境信息
 * Created by yangpan on 2019-06-27 16:11.
 */
@Configuration
public class MyEnvironmentAware implements EnvironmentAware {

    private Environment environment = null;

    @Override
    public void setEnvironment(Environment environment) {

        //获取系统环境信息
        String javaHome = environment.getProperty("JAVA_HOME");
        System.out.println("通过实现EnvironmentAware读取系统环境信息：" + javaHome);


        //读取项目配置文件属性
        String age = environment.getProperty("yangpan.age");
        System.out.println("通过实现EnvironmentAware读取配置文件属性：" + age);

        this.environment = environment;
    }

    /**
     * 提供一个获取可以获取系统JAVA_HOME的方法
     * @return
     */
    public String getJavaPath(){
        return environment.getProperty("JAVA_HOME");
    }

}
