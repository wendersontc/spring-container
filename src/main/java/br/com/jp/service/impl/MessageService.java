package br.com.jp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author JP on 10/10/17.
 */
@Service
public class MessageService {

    @Autowired
    private MessageSource messageSource;

    public String get(String key) {
        return this.messageSource.getMessage(key, null, LocaleContextHolder.getLocaleContext().getLocale());
    }
}

