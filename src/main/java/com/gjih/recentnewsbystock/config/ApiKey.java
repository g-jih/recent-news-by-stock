package com.gjih.recentnewsbystock.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * API KEY를 가져오는 클래스
 */

@Getter
@Component
@NoArgsConstructor
public class ApiKey {

    @Value("${external.api.id}")
    private String apiId;

    @Value("${external.api.password}")
    private String apiPassword;

    /*private static ApiKey instance = new ApiKey();

    public static ApiKey getInstance() {
        if (instance == null) {
            instance = new ApiKey();
        }
        return instance;
    }*/
}
