package UserProfile;

import com.wrapper.spotify.model_objects.specification.User;
import entity.UserDetails;
import entity.UserDetailsRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NoArgsConstructor
@Service
public class UserProfileService {
    private UserDetailsRepository userDetailsRepository;

    public  Optional<UserDetails> insertOrUpdateUserDetails(User user, String accessToken, String refreshToken) {
        Optional<UserDetails> existingUserDetailsOpt = Optional.ofNullable(userDetailsRepository.findByRefId(user.getId()));

        UserDetails userDetails;
        if (existingUserDetailsOpt.isPresent()) {
            // Update existing user details
            userDetails = existingUserDetailsOpt.get();
            userDetails.setAccessToken(accessToken);
            userDetails.setRefreshToken(refreshToken);
            userDetails.setUsername(userDetails.getUsername());
        } else {
            // Insert new user details
            userDetails = new UserDetails();
            userDetails.setUsername(user.getId());
            userDetails.setEmail(user.getEmail());
            userDetails.setAccessToken(accessToken);
            userDetails.setRefreshToken(refreshToken);
        }

        UserDetails savedUserDetails = userDetailsRepository.save(userDetails);
        return Optional.of(savedUserDetails);
    }
}
