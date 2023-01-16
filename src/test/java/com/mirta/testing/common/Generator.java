package com.mirta.testing.common;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

  public static String specialSymbolsString = "±!@#$%^&*()_+./,|\\[]{}\"'`~№:;?";

  public static String phoneNumber(String countryCode, String prefix, int numberLength) {
    StringBuilder finalPhoneNumber = new StringBuilder(countryCode + prefix);

    for (int i = 0; i < numberLength; i++) {
      String randomNum = String.valueOf(ThreadLocalRandom.current().nextInt(0, 9 + 1));
      finalPhoneNumber.append(randomNum);
    }
    // System.out.println("Generated phone:" + finalPhoneNumber.toString());
    return finalPhoneNumber.toString();
  }

  public static String phoneNumber(String prefix, int numberLength) {
    return phoneNumber("", prefix, numberLength);
  }

  public static String validKZNumber() {
    return phoneNumber("", kzPrefix(), 7);
  }

  public static String string
          (int length, boolean containsCyrillic, boolean containsLatin, boolean containsNumeric, boolean containsSpaces,
           boolean containsSpecialSymbols) {

    String ALPHA_NUMERIC_STRING = "";

    if (containsCyrillic) {
      ALPHA_NUMERIC_STRING += "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЭЮЯЬЙЪ";
    }
    if (containsLatin) {
      ALPHA_NUMERIC_STRING += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    if (containsNumeric) {
      ALPHA_NUMERIC_STRING += "0123456789";
    }
    if (containsSpaces) {
      ALPHA_NUMERIC_STRING += " ";
    }
    if (containsSpecialSymbols) {
      ALPHA_NUMERIC_STRING += Generator.specialSymbolsString;
    }
    StringBuilder builder = new StringBuilder();
    while (length-- != 0) {
      int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
      builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }
    return builder.toString();
  }

  public static String numericString(int length) {
    return string(length, false, false, true,
            false, false);
  }

  public static String numericStringWithoutLeadingZeroes(int length) {
    String result = string(length, false, false, true,
            false, false);
    while (result.startsWith("0")) {
      result = string(length, false, false, true,
              false, false);
    }
    return result;
  }

  public static String lettersString(int length, boolean cyrillic, boolean latin) {
    return string(length, cyrillic, latin, false,
            false, false);
  }

  public static String latinString(int length) {
    return string(length, false, true, false,
            false, false);
  }

  public static String cyrString(int length) {
    return string(length, true, false, false,
            false, false);
  }

  public static String kzPrefix() {
    ArrayList<String> list = new ArrayList<String>() {{
      add("700");
      add("701");
      add("702");
      add("705");
      add("706");
      add("707");
      add("708");
      add("747");
      add("750");
      add("751");
      add("760");
      add("761");
      add("762");
      add("763");
      add("764");
      add("771");
      add("775");
      add("776");
      add("777");
      add("778");
    }};

//        String generatedIndex = list.get(Tools.generateRandomInt(0, list.size() - 1));
//        //System.out.println("Generated index: " + generatedIndex);
//        return generatedIndex;

    return list.get(Tools.generateRandomInt(0, list.size() - 1));
  }
}
