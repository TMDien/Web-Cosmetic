package tmd.project.ShopCosmetic.Config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tmd.project.ShopCosmetic.Models.Account;
import tmd.project.ShopCosmetic.Models.Authority;
import tmd.project.ShopCosmetic.Services.AccountService;
import tmd.project.ShopCosmetic.Services.AuthorityService;
import tmd.project.ShopCosmetic.Until.constants.Privillages;
import tmd.project.ShopCosmetic.Until.constants.Roles;

@Component
public class SeedData implements CommandLineRunner{

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for(Privillages auth : Privillages.values()){
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillages());
            authorityService.save(authority);
        }

       
        // Account 1
        Account account1 = new Account();
        account1.setEmail("admin@gmail.com");
        account1.setPassword("123456");
        account1.setName("Trinh Minh Dien");
        account1.setRole(Roles.ADMIN.getRole());
        accountService.save(account1);

        // Account 2
        Account account2 = new Account();
        account2.setEmail("user@gmail.com");
        account2.setPassword("123456");
        account2.setName("Tuong Vi");
        accountService.save(account2);

        //Account 3
        Account account3 = new Account();
        account3.setEmail("editor@gmail.com");
        account3.setPassword("123456");
        account3.setName("Editor");
        account3.setRole(Roles.EDITOR.getRole());
        accountService.save(account3);

        // Account 4
        Account account4 = new Account();
        account4.setEmail("super_editor@gmail.com");
        account4.setPassword("123456");
        account4.setName("Super Editor");
        account4.setRole(Roles.EDITOR.getRole());
        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        account4.setAuthorities(authorities);
        accountService.save(account4);
    }
    
}
