package site.yangpan.jdbc.dao;

import site.yangpan.jdbc.entity.AccountEntity;

import java.util.List;

/**
 * IAccountDAO
 * Created by yangpan on 2019-06-24 17:06.
 */
public interface IAccountDAO {

    int add(AccountEntity account);

    int update(AccountEntity account);

    int delete(int id);

    AccountEntity findAccountById(int id);

    List<AccountEntity> findAccountList();
}


