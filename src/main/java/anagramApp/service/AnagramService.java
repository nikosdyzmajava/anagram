package org.example.service;

import org.example.model.Request;
import org.example.model.Result;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.example.util.MessageUtil.*;

@Service
public class AnagramService {

    public boolean areAnagrams(String firstString, String secondString) {
        Function<String, String> sanitize = s ->
                s.replaceAll("\\s", "").toLowerCase();

        String sanitizedFirstOne = sanitize.apply(firstString);
        String sanitizedSecondOne = sanitize.apply(secondString);

        return sanitizedFirstOne.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .equals(sanitizedSecondOne.chars()
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public boolean areOnlyNumbers(String firstString, String secondString) {
        Predicate<String> isNumeric = s -> s.chars().allMatch(Character::isDigit);
        return isNumeric.test(firstString) && isNumeric.test(secondString);
    }

    public Result checkStringsAreAnagram(Request request) {
        String firstInputString = request.getFirstString();
        String secondInputString = request.getSecondString();

        if (areOnlyNumbers(firstInputString, secondInputString)) {
            return areAnagrams(request.getFirstString(), request.getSecondString())
                    ? new Result(RESULT_ARE_NUMBER_AND_THEY_ARE_ANAGRAM)
                    : new Result(RESULT_ARE_NUMBER_AND_THEY_ARE_NOT_ANAGRAM);
        } else {
            return areAnagrams(request.getFirstString(), request.getSecondString())
                    ? new Result(RESULT_ARE_ANAGRAM)
                    : new Result(RESULT_ARE_NOT_ANAGRAM);
        }
    }
}
