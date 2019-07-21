package site.yangpan.elasticsearch.controller;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.yangpan.elasticsearch.entity.EsUser;

import java.util.ArrayList;
import java.util.List;

/**
 * EsEsUserController
 * Created by yangpan on 2019-07-21 22:16.
 */
@RestController
@RequestMapping("/es/user")
public class EsUserController {

    public static final String INDEX = "yangpan";

    public static final String TYPE = "user";

    @Autowired
    private JestClient jestClient;


    /**
     * 创建索引
     * @return
     * @throws Exception
     */
    @GetMapping("/createIndex/{index}")
    public String createIndex(@PathVariable("index") String index) throws Exception {
        JestResult jr = jestClient.execute(new CreateIndex.Builder(index).build());
        return "创建索引：" +jr.isSucceeded();
    }

    /**
     * 删除索引
     * @return
     * @throws Exception
     */
    @GetMapping("/deleteIndex/{index}")
    public String deleteIndex(@PathVariable("index") String index) throws Exception{
        JestResult jr = jestClient.execute(new DeleteIndex.Builder(index).build());
        return "删除索引：" +jr.isSucceeded();
    }

    /**
     * 新增数据
     * @return
     * @throws Exception
     */
    @PostMapping("/insertData")
    public String insert(@RequestBody EsUser user) throws Exception {
        Index index = new Index.Builder(user).index(INDEX).type(TYPE).build();
        JestResult jr = jestClient.execute(index);
        return "新增数据：" + jr.isSucceeded();
    }

    /**
     * 删除单条数据,  这个id必须是主键才能被删除
     * @return
     * @throws Exception
     */
    @DeleteMapping("/deleteData/{id}")
    public String deleteData(@PathVariable("id") String id)throws Exception{
        DocumentResult dr = jestClient.execute(new Delete.Builder(id).index(INDEX).type(TYPE).build());
        return "删除数据：" + dr.isSucceeded();
    }

    /**
     * 查询数据
     * @return
     * @throws Exception
     */
    @GetMapping("/search")
    public String search() throws Exception{
        //查询表达式
        String json="{\"query\":{\"match_all\":{}}}";
        System.out.println(json);
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex(INDEX).addType(TYPE).build();
        SearchResult result=jestClient.execute(search);
        return result.getJsonString();
    }

    /**
     * 向ElasticSearch中批量新增
     */
    @GetMapping("/insertBatch")
    public String insertBatch(){
        List<Object> objs = new ArrayList<Object>();
        objs.add(new EsUser(1L, "张三三", 20, "张三是个Java开发工程师","2018-4-25 11:07:42"));
        objs.add(new EsUser(2L, "李四四", 24, "李四是个测试工程师","1980-2-15 19:01:32"));
        objs.add(new EsUser(3L, "王五五", 25, "王五是个运维工程师","2018-4-24 06:11:32"));
        boolean result = false;
        try {
            Bulk.Builder bulk = new Bulk.Builder().defaultIndex(INDEX).defaultType(TYPE);
            for (Object obj : objs) {
                Index index = new Index.Builder(obj).build();
                bulk.addAction(index);
            }
            BulkResult br = jestClient.execute(bulk.build());
            result = br.isSucceeded();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "批量新增:" + result;
    }

}
