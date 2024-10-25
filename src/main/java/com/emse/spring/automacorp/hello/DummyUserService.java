package com.emse.spring.automacorp.hello;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyUserService extends ConsoleGreetingService implements UserService{
    public void greetAll(List<String> name){
        for (String s : name) {
            greet(s);
        }
    }
}
