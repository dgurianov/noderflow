package com.gud.noderflow.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component("cache")
public class GuavaBasedCache implements NoderflowCache<UserEntityAttributes> {

    private LoadingCache<String, UserEntityAttributes> cache;

    @PostConstruct
    private void init() {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(Integer.MAX_VALUE)
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

    @Override
    public List<UserEntityAttributes> getTwoRandom() {
        List<UserEntityAttributes> two = new LinkedList<>();
        long randomUpperBound = this.cache.size();
        if (randomUpperBound == 0) {
            return two;
        }
        long first = 0, second = 0;
        while (first == second) {
            first = ThreadLocalRandom.current().nextLong(1, randomUpperBound);
            second = ThreadLocalRandom.current().nextLong(1, randomUpperBound);
        }
        two.add(this.cache.getIfPresent(String.valueOf(first)));
        two.add(this.cache.getIfPresent(String.valueOf(second)));
        return two;
    }

}
