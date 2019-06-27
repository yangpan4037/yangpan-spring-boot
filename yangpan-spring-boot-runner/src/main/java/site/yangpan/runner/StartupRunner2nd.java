package site.yangpan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 第二个服务启动执行器
 *
 * CommandLineRunner和ApplicationRunner的作用是相同的。
 * 不同之处在于CommandLineRunner接口的run()方法接收String数组作为参数，即是最原始的参数，没有做任何处理；
 * 而ApplicationRunner接口的run()方法接收ApplicationArguments对象作为参数，是对原始参数做了进一步的封装。
 *
 * Created by yangpan on 2019-06-27 17:10.
 */
@Component
@Order(value=2)
public class StartupRunner2nd implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("StartupRunner2nd，实现CommandLineRunner接口，服务启动执行。。");
        String strArgs = Arrays.stream(args).collect(Collectors.joining(" | "));
        System.out.println("StartupRunner2nd，接收到参数" + strArgs);
        System.out.println("\n");
    }

}
