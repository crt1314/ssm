package com.chrt.ssm.util;

import com.chrt.ssm.exception.EmailException;

public class EmailExceptionEnumerationWrapper {

    private EmailExceptionEnumerationWrapper() {}

    public static void wrapperEmailException(EmailExceptionEnumeration enumeration, Exception e) throws EmailException {
        throw new EmailException(enumeration.getMessage(), e);
    }

    public static void wrapperEmailException(EmailExceptionEnumeration enumeration) throws EmailException {
        throw new EmailException(enumeration.getMessage());
    }
}
