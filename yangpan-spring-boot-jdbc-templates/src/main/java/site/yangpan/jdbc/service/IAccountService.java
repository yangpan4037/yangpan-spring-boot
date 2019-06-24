package site.yangpan.jdbc.service;

import site.yangpan.jdbc.entity.AccountEntity;

import java.util.List;

/**
 * Account Service 接口
 * Created by yangpan on 2019-06-24 17:11.
 */
public interface IAccountService {


    int add(AccountEntity account);

    int update(AccountEntity account);

    int delete(int id);

    AccountEntity findAccountById(int id);

    List<AccountEntity> findAccountList();

}


