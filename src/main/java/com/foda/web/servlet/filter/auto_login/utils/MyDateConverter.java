package com.foda.web.servlet.filter.auto_login.utils;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @ author pxz
 * @ date 2018/12/7 0007-下午 2:39
 */
public class MyDateConverter implements Converter {

    @SuppressWarnings("rawtypes")
    public Object convert(Class type, Object value) {
        if (value == null) {
            return null;
        }
        if (!(value instanceof String)) {
            return value;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return sdf.parse((String) value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
