package tmd.project.ShopCosmetic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmd.project.ShopCosmetic.Models.Profile;
import tmd.project.ShopCosmetic.Repositories.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Profile save(Profile profile){
        return profileRepository.save(profile);
    }
    
}
