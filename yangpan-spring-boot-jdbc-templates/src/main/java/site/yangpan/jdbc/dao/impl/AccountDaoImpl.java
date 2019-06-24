package site.yangpan.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import site.yangpan.jdbc.dao.IAccountDAO;
import site.yangpan.jdbc.entity.AccountEntity;

import java.util.List;

/**
 * AccountDaoImpl
 * Created by yangpan on 2019-06-24 17:07.
 */
@Repository
public class AccountDaoImpl implements IAccountDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int add(AccountEntity account) {
        return jdbcTemplate.update("insert into account(name, money) values(?, ?)",
                account.getName(),account.getMoney());

    }

    @Override
    public int update(AccountEntity account) {
        return jdbcTemplate.update("UPDATE  account SET NAME=? ,money=? WHERE id=?",
                account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from TABLE account where id=?",id);
    }

    @Override
    public AccountEntity findAccountById(int id) {
        List<AccountEntity> list = jdbcTemplate.query("select * from account where id = ?", new Object[]{id}, new BeanPropertyRowMapper(AccountEntity.class));
        if(list!=null && list.size()>0){
            AccountEntity account = list.get(0);
            return account;
        }else{
            return null;
        }
    }

    @Override
    public List<AccountEntity> findAccountList() {
        List<AccountEntity> list = jdbcTemplate.query("select * from account", new Object[]{}, new BeanPropertyRowMapper(AccountEntity.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
