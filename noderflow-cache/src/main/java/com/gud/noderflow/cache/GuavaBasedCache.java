package com.gud.noderflow.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("cache")
public class GuavaBasedCache implements NoderflowCache<UserEntityAttributes> {

    private LoadingCache<String, UserEntityAttributes> cache;

    @PostConstruct
    private void init() {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
//                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(new DummyCacheLoader());
    }

    @Override
    public void put(String key, UserEntityAttributes element) {
        this.cache.put(key, element);
    }

    @Override
    public UserEntityAttributes get(String key) {
        return this.cache.getUnchecked(key);
    }

    @Override
    public List<UserEntityAttributes> getAll() {
        return new ArrayList<>(this.cache.asMap().values());
    }

}
