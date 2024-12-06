package org.example.aplikaceproskolu;

import org.example.aplikaceproskolu.objekty.Users;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Controller
@RequestMapping("api/authorization/discord")
public class discordAuth {

    String ClientSecret = "S8Wax4gw0KyjuBUVXBjsa9oCz0xVUmjL";
    String ClientId = "1293478889066070068";

    @Autowired
    UserRepo userRepo;

    @GetMapping("/redirect")
    public void Redirect(@RequestParam String code) {
        System.out.println(code);
//        Users usr = userRepo.findByDiscordId(GetDiscordId(code));

//        NewToken(usr.getId());
        // save token to cookies and rederect to a log webside
    }
    private String GetDiscordId(String DiscordCode) {

        RestClient defaultClienat = RestClient.create();

        RestClient customClient = RestClient.builder()
           .requestFactory(new HttpComponentsClientHttpRequestFactory())
           .build();
        String discordId = customClient.get().uri("https://discord.com/api/oauth2/token/users/{DiscordCode}",DiscordCode).retrieve().body(String.class);
        return discordId;
    }

    private String NewToken(UUID user) {
        Users usr = userRepo.getById(user);
        usr.token = UUID.randomUUID();
        return usr.token.toString();
    }

}
