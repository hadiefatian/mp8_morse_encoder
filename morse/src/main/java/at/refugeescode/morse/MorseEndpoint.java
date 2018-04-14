package at.refugeescode.morse;

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

    private List<String> letters = Stream.of("a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" "))
            .collect(Collectors.toList());

    private List<String> morseCode = Stream.of((".-  -...  -.-.  -..  .  ..-.  --.  ....  ..  .---  -.-  .-..  " +
            "--  -.  ---  .--.  --.-  .-.  ...  -  ..-  ...-  .--  -..-  -.--  --..").split("  "))
            .collect(Collectors.toList());

    @PostMapping("/morse")
    String encode(@RequestBody String letter) {
        if (letter.trim().isEmpty()) {
            return " ";
        }
        return convertToMorseCode(letter);
    }

    private String convertToMorseCode(String letter) {
        int letterIndex = letters.indexOf(letter);
        return morseCode.get(letterIndex);
    }
}
