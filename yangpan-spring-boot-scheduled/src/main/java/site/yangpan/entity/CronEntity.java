package site.yangpan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用于存储corn表达式的entity
 * Created by yangpan on 2019-06-28 16:37.
 */
@Entity
@Table(name = "t_corn")
public class CronEntity {

    @Id
    String cronId;

    @Column
    String cornContent;

    public String getCronId() {
        return cronId;
    }

    public void setCronId(String cronId) {
        this.cronId = cronId;
    }

    public String getCornContent() {
        return cornContent;
    }

    public void setCornContent(String cornContent) {
        this.cornContent = cornContent;
    }
}
