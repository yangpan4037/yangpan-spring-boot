package site.yangpan.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 第三个服务启动运行器
 *
 * CommandLineRunner和ApplicationRunner的作用是相同的。
 * 不同之处在于CommandLineRunner接口的run()方法接收String数组作为参数，即是最原始的参数，没有做任何处理；
 * 而ApplicationRunner接口的run()方法接收ApplicationArguments对象作为参数，是对原始参数做了进一步的封装。
 *
 * Created by yangpan on 2019-06-27 17:10.
 */
@Component
@Order(value=3)
public class StartupRunner3rd implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("StartupRunner3rd，实现ApplicationRunner接口，服务启动执行。。");

        List<String> argsList = Arrays.asList(args.getSourceArgs());
        System.out.println("StartupRunner3rd，接收到参数list：" + argsList);

        Set<String> optionNames = args.getOptionNames();
        System.out.println("StartupRunner3rd，接收到参数名称list：" + optionNames);

        List<String> optionValues = args.getOptionValues("foo");
        System.out.println("StartupRunner3rd，接收到参数值list：" + optionValues);
    }

}
