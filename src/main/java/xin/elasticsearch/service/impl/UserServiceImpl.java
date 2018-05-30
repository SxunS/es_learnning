package xin.elasticsearch.service.impl;

import org.springframework.stereotype.Service;
import xin.elasticsearch.dao.IUserDao;
import xin.elasticsearch.domain.User;
import xin.elasticsearch.service.IUserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
