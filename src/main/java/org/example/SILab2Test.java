package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void emailIsNull()
    {
        List<User> list = new ArrayList<>();
        list.add(new User("Lazo", "password34@","nikoloskilazo@gmail.com"));
        User u = new User("username", "Password1234@", "");
        assertEquals(false,SILab2.function(u,list));
    }

    @Test
    void passwordIsNull() {
        List<User> list = new ArrayList<>();
        list.add(new User("Lazo", "password1234@","nikoloskilazo@gmail.com"));
        User u = new User("username", "", "example@example.org");
        assertEquals(false,SILab2.function(u,list));
    }

    @Test
    void passwordIsValid() {
        List<User> list = new ArrayList<>();
        list.add(new User("Lazo", "password1234@","nikoloskilazo@gmail.com"));
        User u = new User("username", "password1234@", "example@example.org");
        assertEquals(true,SILab2.function(u,list));
    }

    @Test
    void passwordHasEmptySpace(){
        List<User> list = new ArrayList<>();
        list.add(new User("Lazo", "!@#!@A","nikoloskilazo@gmail.com"));
        User u = new User("username", "Passw ord1234@", "example@example.org");
        assertEquals(false,SILab2.function(u,list));
    }

    @Test
    void passwordWithoutSpecialCharacters(){
        List<User> list = new ArrayList<>();
        list.add(new User("Lazo", "password1234@","nikoloskilazo@gmail.com"));
        User u = new User("username", "password", "example@example.org");
        assertEquals(false,SILab2.function(u,list));
    }

    @Test
    void userIsNull(){
        List<User> list = new ArrayList<>();
        list.add(new User("Lazo", "password34@","nikoloskilazo@gmail.com"));
        User u = new User("", "Password1234@", "example@example.org");
        assertEquals(false,SILab2.function(u,list));
    }

    @Test
    void passwordAndEmailNull(){
        List<User> list = new ArrayList<>();
        list.add(new User("Lazo", "!@#!@A","nikoloskilazo@gmail.com"));
        User u = new User("username", "", "");
        assertEquals(false,SILab2.function(u,list));
    }



    @Test
    void multipleCondition(){
        //UserIsNull
        RuntimeException exce;
        exce = assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<User>(List.of(new User("username", "Password1234@", "example@example.com")))));
        assertTrue(exce.getMessage().contains("Mandatory information missing!"));

        //UserIsValidPasswordIsNull
        exce = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, "example@example.com"), new ArrayList<User>(List.of(new User("username", "Password1234@", "example@example.com")))));
        assertTrue(exce.getMessage().contains("Mandatory information missing!"));

        //UserIsValidPasswordIsValidEmailIsNull
        exce = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", "Password1234@", null), new ArrayList<User>(List.of(new User("username", "Password1234@", "example@example.com")))));
        assertTrue(exce.getMessage().contains("Mandatory information missing!"));

        //AllConditionsAreNotValid
        assertTrue(() -> SILab2.function(new User("username11", "Password1234@", "test@test.com"), new ArrayList<User>(List.of(new User("username", "Password4@", "example@test.com")))));

        }
    }

