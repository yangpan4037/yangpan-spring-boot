package site.yangpan.elasticsearch.entity;

import io.searchbox.annotations.JestId;

/**
 * EsUser
 * Created by yangpan on 2019-07-21 22:35.
 */
public class EsUser {

    @JestId
    private Long id;

    private String name;

    private int age;

    private String job;

    private String createTime;

    public EsUser(Long id, String name, int age, String job, String createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
