package com.iterlife.zeus.demo.factory;

import com.iterlife.zeus.demo.entity.User2;
import org.springframework.beans.factory.FactoryBean;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2020/10/7 16:54
 **/
public class UserFactoryBean implements FactoryBean {


    private User2 userObj;
    private String userStr;


    @Override
    public Object getObject() throws Exception {
        User2 userObj2 = new User2();
        String[] userDetail = this.userStr.split(";");
        userObj2.setId(userDetail[0]);
        userObj2.setName(userDetail[1]);
        userObj2.setGender(userDetail[2]);
        userObj2.setAge(Integer.valueOf(userDetail[3]));
        return userObj2;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setUserObj(User2 userObj) {
        this.userObj = userObj;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

    @Override
    public String toString() {
        return "UserFactoryBean{" + "userObj=" + userObj + ", userStr='" + userStr + '\'' + '}';
    }
}
