package com.gud.noderflow.cache;

import com.google.common.cache.CacheLoader;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;

public class DummyCacheLoader extends CacheLoader<String, UserEntityAttributes> {
    @Override
    public UserEntityAttributes load(String key) throws Exception {
        return null;
    }
}
