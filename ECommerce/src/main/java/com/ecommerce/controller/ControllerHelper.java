package com.ecommerce.controller;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class ControllerHelper {

    public static String convertToBase64(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        byte[] base64Encoded = Base64.encodeBase64(bytes);
        return new String(base64Encoded);
    }
}
