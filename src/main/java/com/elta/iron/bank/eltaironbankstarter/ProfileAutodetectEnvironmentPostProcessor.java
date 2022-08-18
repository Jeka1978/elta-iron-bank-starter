package com.elta.iron.bank.eltaironbankstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Evgeny Borisov
 */


public class ProfileAutodetectEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (environment.getActiveProfiles().length == 0) {
            if (getTemperature() < -50) {
                environment.addActiveProfile(ProfilesConst.WINTER_IS_HERE);
            }else {
                environment.addActiveProfile(ProfilesConst.WINTER_IS_COMING);
//                environment.getPropertySources().addLast();

            }
        }
    }

    private int getTemperature() {
        return -81;
    }
}
