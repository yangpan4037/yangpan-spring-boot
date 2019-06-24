package site.yangpan.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.yangpan.jdbc.entity.AccountEntity;
import site.yangpan.jdbc.service.IAccountService;

import java.util.List;

/**
 * Account Controller
 * Created by yangpan on 2019-06-24 17:13.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService accountService;

    /**
     * 列表
     * @return
     */
    @GetMapping("/list")
    public List<AccountEntity> getAccounts() {
        return accountService.findAccountList();
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public AccountEntity getAccountById(@PathVariable("id") int id) {
        return accountService.findAccountById(id);
    }

    /**
     * 修改
     * @param id
     * @param accountEntity
     * @return
     */
    @PutMapping
    public String updateAccount(@RequestBody AccountEntity accountEntity) {
        int t = accountService.update(accountEntity);
        if (t == 1) {
            return accountEntity.toString();
        } else {
            return "更新失败！";
        }
    }

    /**
     * 新增
     * @param accountEntity
     * @return
     */
    @PostMapping
    public String postAccount(@RequestBody AccountEntity accountEntity) {
        int t = accountService.add(accountEntity);
        if (t == 1) {
            return accountEntity.toString();
        } else {
            return "fail";
        }

    }

}
