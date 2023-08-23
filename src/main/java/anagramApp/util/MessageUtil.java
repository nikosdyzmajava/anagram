package org.example.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageUtil {

    public static final String RESULT_ARE_NUMBER_AND_THEY_ARE_ANAGRAM = "The strings are only numbers but they are anagram";

    public static final String RESULT_ARE_NUMBER_AND_THEY_ARE_NOT_ANAGRAM = "The strings are only numbers but they aren't anagram";

    public static final String RESULT_ARE_ANAGRAM = "The strings are anagram";

    public static final String RESULT_ARE_NOT_ANAGRAM = "The strings are not anagram";

}
