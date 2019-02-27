package com.lambdaschool.ourcourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class OurcoursesApplication
{

    //TODO Exception Handling

    //TODO Hide db password
    // I encrypted the password being https://www.devglan.com/online-tools/jasypt-online-encryption-decryption
    // I used my standard student password

    public static void main(String[] args)
    {
        SpringApplication.run(OurcoursesApplication.class, args);
    }

}
