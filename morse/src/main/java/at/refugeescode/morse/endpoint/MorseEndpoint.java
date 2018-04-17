package at.refugeescode.morse.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping
public class MorseEndpoint {

    @Value("#{'${letters}'.split(' ')}")
    private List<String> letters;

    @Value("#{'${morsecodes}'.split('  ')}")
    private List<String> morseCode;

    @PostMapping("/morse")
    String encode(@RequestBody String letter) {
        if (letter.trim().isEmpty()) {
            return " ";
        }
        return convertToMorseCode(letter.toLowerCase());
    }

    private String convertToMorseCode(String letter) {
        int letterIndex = letters.indexOf(letter);
        return morseCode.get(letterIndex);
    }
}
