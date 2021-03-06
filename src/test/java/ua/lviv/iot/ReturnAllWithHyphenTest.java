package ua.lviv.iot;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReturnAllWithHyphenTest {

    @Test
    void testSearchHyphens() {
        String input = "No one believed Hikaru when he said he was (self taught/self-taught) because his skills necessitated the presence of a teacher.\n" +
                "Jean promised to drop the boys off at the (railroad/rail-road) station.\n" +
                "Roy and Riza were very tired after the (three hour-long/three-hour long) PTA meeting.\n" +
                "Eli was pleased to see that he still had a (four or five-point/four- or five-point) lead on his opponent";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> resultedWords = new ArrayList<String>();
        while(scanner.hasNextLine()){
            resultedWords.addAll(ReturnAllWithHyphen.wordsValidation(scanner.nextLine()));
        }
        Collections.sort(resultedWords);
        assertEquals(Arrays.asList("five-point", "five-point", "hour-long", "rail-road","self-taught", "three-hour "), resultedWords);
        for (String s: resultedWords) {
            System.out.println(s);
        }
    }
}
