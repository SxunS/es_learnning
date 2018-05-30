package xin.elasticsearch.dao;


import xin.elasticsearch.domain.User;

public interface IUserDao {

    User selectUser(long id);

}