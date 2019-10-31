package hello;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello Testing, %s!";
    private final AtomicLong counter = new AtomicLong();

    Dog buddy = new Dog("Buddy");

    @RequestMapping("/greeting")
    public HashMap<String, String> greeting(@RequestParam(value="name", defaultValue="World") String name) {

        HashMap<String, String> response = new HashMap<String, String>();

        Greeting message = new Greeting(counter.incrementAndGet(),
        String.format(template, name));

        String fedStatus = "Hungry";

        if(buddy.isFed()) {
            fedStatus = "Feed";
        }

        // We can instantiate either as an Animal, as well.
        Animal buddy_two = new Dog("Buddy II");
        response.put("Greeting", String.format(template, name));
        response.put("Dog Name", buddy.getName());
        response.put("Feed Status", fedStatus.toString());
        // response.put("Dog Name", buddy_two.getName());

        if(buddy_two.isFed()) {
            fedStatus = "Feed";
        } else {
            fedStatus = "Hungry";
        }
        response.put("Buddy II Feed Status", fedStatus);
        return response;
    }

    @RequestMapping("/feed")
    public Boolean feed() {
        // ...And we can call super methods on both.
        buddy.feed();
        return buddy.isFed();
    }
}