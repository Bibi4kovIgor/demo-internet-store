package edu.lemon.demointernetstore.utils;

import java.util.Arrays;
import java.util.Base64;

public class IdTransformUtility {
  private final static String SALT = "salt to encode id";

  public static String encryptId(Long id) {
    return Base64.getEncoder().encodeToString((id.toString() + SALT).getBytes());
  }

  public static Long decryptId(String id) {
    return Long.getLong(Arrays.toString(Base64.getDecoder().decode((id + SALT))));
  }
}
