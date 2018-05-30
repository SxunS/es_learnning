package xin.elasticsearch.service;


import xin.elasticsearch.domain.User;

public interface IUserService {

    User selectUser(long userId);

}
