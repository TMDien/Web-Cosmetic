package tmd.project.ShopCosmetic.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Email(message = "Invalid email")
    @NotEmpty(message = "Vui lòng nhập Email")
    private String email;

    @NotEmpty(message = "Vui lòng nhập password")
    private String password;

    @NotEmpty(message = "Vui lòng nhập tên của bạn")
    private String name;

    private String role;


     @ManyToMany
    @JoinTable(name="account_authority",
            joinColumns = {@JoinColumn(name="account_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities = new HashSet<>();
    
}
