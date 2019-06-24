package site.yangpan.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yangpan.jdbc.dao.IAccountDAO;
import site.yangpan.jdbc.entity.AccountEntity;
import site.yangpan.jdbc.service.IAccountService;

import java.util.List;

/**
 * Account Service实现
 * Created by yangpan on 2019-06-24 17:12.
 */
@Service
public class AccountService implements IAccountService {

    @Autowired
    IAccountDAO accountDAO;

    @Override
    public int add(AccountEntity account) {
        return accountDAO.add(account);
    }

    @Override
    public int update(AccountEntity account) {
        return accountDAO.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }

    @Override
    public AccountEntity findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public List<AccountEntity> findAccountList() {
        return accountDAO.findAccountList();
    }
}


