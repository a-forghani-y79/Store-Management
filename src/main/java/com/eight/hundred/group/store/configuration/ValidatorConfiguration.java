package com.eight.hundred.group.store.configuration;

import jakarta.validation.MessageInterpolator;
import jakarta.validation.Validator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator validator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        bean.setMessageInterpolator(new MessageInterpolator() {
            @Override
            public String interpolate(String s, Context context) {
                return messageSource.getMessage(s, null, s, Locale.US);
            }

            @Override
            public String interpolate(String s, Context context, Locale locale) {
                return messageSource.getMessage(s, null, s, locale);
            }
        });
        return bean;
    }
}
