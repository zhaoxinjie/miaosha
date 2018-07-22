package com.example.miaosha.redis;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
* @file
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief
* @author
* @email 838985328@qq.com
* @date
*/

public class UserKey extends BasePrefix{

    private UserKey(String prefix) {
        super(prefix);
    }


    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");

    @Override
    public int getExpireSeconds() {
        return 0;
    }
}
