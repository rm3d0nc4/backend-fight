package com.example.backendfight.providers;

import de.huxhorn.sulky.ulid.ULID;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UlidProviderImpl implements UlidProvider {
    private final ULID ulid = new ULID();

    @Override
    public String getUlid() {
        return ulid.nextULID();
    }
}
