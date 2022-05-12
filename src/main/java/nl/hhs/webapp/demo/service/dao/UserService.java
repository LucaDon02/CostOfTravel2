package nl.hhs.webapp.demo.service.dao;

import nl.hhs.webapp.demo.model.user.User;
import nl.hhs.webapp.demo.service.repository.AbstractRepository;
import nl.hhs.webapp.demo.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractRepository<User> implements UserDetailsService {

    @Autowired
    public UserService(UserRepository repository) {
        super( repository );
    }

    @Override
    public UserDetails loadUserByUsername( String email ) throws UsernameNotFoundException {
        return ( (UserRepository) REPOSITORY )
                .findByEmail( email )
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }
}
