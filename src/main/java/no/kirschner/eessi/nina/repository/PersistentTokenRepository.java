package no.kirschner.eessi.nina.repository;

import java.time.LocalDate;
import java.util.List;
import no.kirschner.eessi.nina.domain.PersistentToken;
import no.kirschner.eessi.nina.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the {@link PersistentToken} entity.
 */
public interface PersistentTokenRepository extends MongoRepository<PersistentToken, String> {
    List<PersistentToken> findByUser(User user);

    List<PersistentToken> findByTokenDateBefore(LocalDate localDate);
}
