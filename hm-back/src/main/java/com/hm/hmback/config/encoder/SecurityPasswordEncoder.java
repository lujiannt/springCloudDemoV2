package com.hm.hmback.config.encoder;

import com.hm.commons.utils.CryptoUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        boolean flag = false;
        try {
            flag = (CryptoUtils.encrypt(s)).equals(charSequence.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }
}
