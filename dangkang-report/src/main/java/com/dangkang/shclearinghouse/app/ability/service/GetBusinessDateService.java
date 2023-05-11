package com.dangkang.shclearinghouse.app.ability.service;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 */
@Component
public class GetBusinessDateService {

    public Date getBusinessDate() {
        return new Date();
    }
}
