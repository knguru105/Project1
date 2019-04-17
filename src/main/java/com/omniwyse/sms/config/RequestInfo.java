package com.omniwyse.sms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestInfo {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestInfo.class);

    public static final ThreadLocal<Long> tenantId = new ThreadLocal<Long>();

    public static final ThreadLocal<String> tenantName = new ThreadLocal<String>();

    public static Long getTenantid() {
        return tenantId.get();
    }

    public static String getTenantname() {
    	LOGGER.info("Returning Tenant : "+ tenantName.get(), tenantName.get());
        return tenantName.get();
    }

}
