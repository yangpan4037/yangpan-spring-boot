package site.yangpan.rest.docs.controller;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import site.yangpan.rest.docs.entity.UserEntity;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * UserControllerTest
 * 注解@AutoConfigureRestDocs注解开启了生成snippets文件，并指定了存放位置
 * Created by yangpan on 2019-07-28 21:28.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUser() throws Exception {
        this.mockMvc.perform(get("/user/{userId}/", "402882a46adecafc016adeccd2770000"))
                .andExpect(status().isOk())
                .andDo(document(
                        //文件路径
                        "user/get",
                        //对路径参数的描述
                        pathParameters(parameterWithName("userId").description("用户ID")),
                        //对响应字段描述
                        responseFields(
                                subsectionWithPath("userId").description("用户ID"),
                                subsectionWithPath("userName").description("用户姓名")
                        )

                ));
    }

    @Test
    public void insertUser() throws Exception {
        String jsonParam = JSON.toJSONString(new UserEntity("402882a46adecafc016adeccd2770000","yangpan"));
        this.mockMvc.perform(put("/user/insert").contentType(MediaType.APPLICATION_JSON).content(jsonParam))
                .andExpect(status().isOk())
                .andDo(document(
                        //文件路径
                        "user/insert",
                        //对请求字段的描述
                        requestFields(
                                fieldWithPath("userId").description("用户ID"),
                                fieldWithPath("userName").description("用户姓名")
                        ),
                        //对响应字段描述
                        responseFields(
                                subsectionWithPath("userId").description("用户ID"),
                                subsectionWithPath("userName").description("用户姓名")
                        )
                ));
    }

}
