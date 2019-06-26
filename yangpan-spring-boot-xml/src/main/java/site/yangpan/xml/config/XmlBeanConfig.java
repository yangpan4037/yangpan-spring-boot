package site.yangpan.xml.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 如果 locations下多文件用逗号隔开，如 locations= {"classpath:a.xml,b.xml,c.xml..."}
 * Created by yangpan on 2019-06-26 16:30.
 */
@Configuration
@ImportResource(locations= {"classpath:config/application-bean.xml"})
public class XmlBeanConfig {
}
