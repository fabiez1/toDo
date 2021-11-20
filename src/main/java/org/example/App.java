package org.example;

import org.example.model.AppRole;
import org.example.model.AppUser;
import org.example.model.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args ) {
        Set<AppUser> appUserList = new HashSet<>();
        appUserList.add(new AppUser("jerry", "forever", AppRole.ROLE_APP_USER));
        appUserList.add(new AppUser("john", "forever1", AppRole.ROLE_APP_USER));
        appUserList.add(new AppUser("ted", "forever2", AppRole.ROLE_APP_USER));
        appUserList.add(new AppUser("Konrad", "forever3", AppRole.ROLE_APP_USER));
        appUserList.add(new AppUser("Cecil", "forever4", AppRole.ROLE_APP_USER));

        List<AppUser> result = appUserList.stream()
                .filter(appUser -> appUser.getUsername().equals("john"))
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
