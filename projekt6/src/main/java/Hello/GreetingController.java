package Hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
@RestController
public class GreetingController {
    private static final String template = "imię: %s, wiek: %s, płeć: %s";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping(path="/bye", method = GET) // odpowiada endpoin'tom http
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Wiktoria") String name,
                             @RequestParam(value = "age", defaultValue = "21" ) String age,
                             String type)
    {
        if(name.charAt(name.length()-1)=='a')
        {
            type = "kobieta";
        }
        else {
            type = "mężczyzna";
        }
        return new Greeting(counter.incrementAndGet(),String.format(template, name, age, type));
    }

    @RequestMapping(path="second", method = GET)
    public String pattern(@RequestParam(value = "name", defaultValue = "Jan") String name)
    {
        String match;
        if (name.equals("Wiki"))
        {
            match = "Welcome";
        } else {
            match = "This page is not for you";
        }
        return match;
    }
}
