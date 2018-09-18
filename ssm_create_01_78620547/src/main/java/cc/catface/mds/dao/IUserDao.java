package cc.catface.mds.dao;

import cc.catface.mds.model.User;
import org.springframework.stereotype.Repository;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Repository
public interface IUserDao {

    User selectUser(long id);

}
