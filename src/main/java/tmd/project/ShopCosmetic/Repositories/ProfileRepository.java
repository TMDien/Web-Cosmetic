package tmd.project.ShopCosmetic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tmd.project.ShopCosmetic.Models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
    
}
