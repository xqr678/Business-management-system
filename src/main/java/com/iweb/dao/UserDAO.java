package com.iweb.dao;

import com.iweb.pojo.User;

/**
 * @author XQR
 * @date 2022/8/13 2022/8/13
 * @dsecription 类的描述和介绍
 */
public interface UserDAO {
    /**用来验证用户
     * @param user
     * @return 返回的布尔值代表验证的情况
     */
    boolean login(User user);
}
