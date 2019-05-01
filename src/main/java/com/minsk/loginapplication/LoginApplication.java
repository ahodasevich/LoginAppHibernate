package com.minsk.loginapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.minsk.loginapplication.User;

public class LoginApplication {

    public static void main(String[] args) {

        int n;
        Util util = new Util();

        Scanner sc = new Scanner(System.in);
        do {
            util.goMainUnit();
            n = sc.nextInt();
            if (n == 1) {
                util.logIn();
            } else {
                if (n == 2) {
                    util.createUser();
                }
            }
        } while (n != 3);

    }

}
