package site.yangpan.druid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * DruidController
 * Created by yangpan on 2019-06-25 16:48.
 */
@RestController
@RequestMapping("/testDruid")
public class DruidController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/dataSource")
    public String dataSource() {
        try {
            System.out.println("dataSource = "+dataSource);
            Connection conn = dataSource.getConnection();
            System.out.println("conn = "+conn);
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "end.";
    }
}
