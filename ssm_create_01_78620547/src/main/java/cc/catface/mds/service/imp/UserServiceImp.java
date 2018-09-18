package cc.catface.mds.service.imp;

import cc.catface.mds.dao.IUserDao;
import cc.catface.mds.model.User;
import cc.catface.mds.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Service("userService")
public class UserServiceImp implements IUserService {


    @Resource
    private IUserDao userDAO;


    @Override
    public User selectUser(long id) {
        return userDAO.selectUser(id);
    }
}
