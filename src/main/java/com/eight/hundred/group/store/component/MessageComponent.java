package com.eight.hundred.group.store.component;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageComponent {
    private final MessageSource messageSource;
    private final Locale locale;

    public MessageComponent(MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = LocaleContextHolder.getLocale();
    }

    public String getMessage(String s) {
        return messageSource.getMessage(s, null, s, locale);
    }

}

