package org.example.data;

import org.example.data.interfaces.AppUserDAO;
import org.example.io.JSONManager;
import org.example.model.AppUser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AppUserDAOCollection implements AppUserDAO {
    public static AppUserDAOCollection INSTANCE;

    private AppUserDAOCollection(Collection<AppUser> appUsers) {
        this.appUsers = appUsers == null ? new HashSet<>(JSONManager.getInstance().deserializeFromJSON(new File("src/main/java/resources.properties/appusers.json"), AppUser.class)) : new HashSet<>(appUsers);
    }

    public static AppUserDAO getInstance() {
        if(INSTANCE == null) INSTANCE = new AppUserDAOCollection(null);
        return INSTANCE;
    }

    static AppUserDAOCollection getTestInstance(Collection<AppUser> appUsers) {
        if(appUsers == null) appUsers = new ArrayList<>();
        return new AppUserDAOCollection(appUsers);
    }

    private final Set<AppUser> appUsers;

    @Override
    public AppUser persist(AppUser appUser) {
        boolean isSaved = appUsers.add(appUser);
        if(isSaved) {
            return appUser;
        }
        return null;
    }

    @Override
    public AppUser findByUsername(String username) {
        for(AppUser user : appUsers) {
            if(user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return appUsers;
    }

    @Override
    public void remove(AppUser username) {
        appUsers.remove(username);
    }
}
