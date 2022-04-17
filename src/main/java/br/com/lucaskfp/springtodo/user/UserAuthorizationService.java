package br.com.lucaskfp.springtodo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthorizationService {

    @Autowired
    UserRepository userRepository;

    public boolean canGet(int loggedInuserId, int pathUserId) {

        if (loggedInuserId != pathUserId) {
            return false;
        }

        UserEntity userEntity = userRepository.findById(pathUserId).get();
        if (userEntity == null) {
            return false;
        }

        return true;

    }

}
