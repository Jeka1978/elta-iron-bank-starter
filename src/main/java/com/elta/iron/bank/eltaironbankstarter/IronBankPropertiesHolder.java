package com.elta.iron.bank.eltaironbankstarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Evgeny Borisov
 */
@Data
@ConfigurationProperties(prefix = "raven")
public class IronBankPropertiesHolder {
    private String destination;
    private String packagesToScan;
}
