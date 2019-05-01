package com.minsk.loginapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    int n;
    String name;
    String login;
    String password;
    boolean isAdmin = false;
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService();
    User user = new User();

    public void goMainUnit() {
        System.out.println("1 - Log in");
        System.out.println("2 - Create User");
        System.out.println("3 - Exit");
    }

    public void logIn() {
        System.out.print("Enter your login:");
        login = sc.next();
        user = checkUser(login);
        if (user == null) {
            System.out.println("This login doesn't exist");
            System.out.println("4 - Exit in main menu");
            do {
                n = sc.nextInt();
            } while (n != 4);
        } else {
            if (user.getIsAdmin() == true) {
                helloAdmin(user.getName());
            } else {
                helloUser(user.getName());
            }
        }    
    }

    public User checkUser(String login) {
        List<User> list = userService.findUser(login);
        if (list.isEmpty() == false) {
            user = list.get(0);
        } else {
            user = null;
            System.out.println(user);
        }
        return user;

    }

    public static void printUserList(List<User> list) {
        for (User us : list) {
            System.out.println(us);
        }
    }

    public void helloUser(String name) {
        System.out.println("Hello, " + name);
        do {
            System.out.println("4 - Exit in main menu");
            n = sc.nextInt();
        } while (n != 4);
    }

    public void helloAdmin(String name) {
        System.out.println("Hello, " + name);
        do {
            System.out.println("4 - Exit in main menu");
            System.out.println("5 - View all users");
            n = sc.nextInt();
        } while ((n != 4) & (n != 5));
        if (n == 5) {
            printUserList(userService.findAllUsers());
        }
    }

    public void createUser() {
        System.out.println("Enter your name:");
        name = sc.next();

        boolean isSingle = false;
        do {
            System.out.println("Enter your login:");
            login = sc.next();
            List<User> list = userService.findUser(login);
            if ((list.isEmpty()) == true) {
                isSingle = true;
            } else {
                System.out.println("This login is already in use. Try again.");
            }
        } while (isSingle == false);

        System.out.println("Enter your password:");
        password = sc.next();

        System.out.println("Are you admin? (true/false):");
        isAdmin = sc.nextBoolean();

        User user = new User(name, login, password, isAdmin);
        userService.saveUser(user);
        System.out.println("New user is created");
        System.out.println("4 - Exit to main menu");
        do {
            n = sc.nextInt();
        } while (n != 4);
    }

}
