package tmd.project.ShopCosmetic.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tmd.project.ShopCosmetic.Models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    Optional<Account> findOneByEmailIgnoreCase(String email);
}
