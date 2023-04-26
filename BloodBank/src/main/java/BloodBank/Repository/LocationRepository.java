package BloodBank.Repository;

import BloodBank.model.Location;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface LocationRepository extends JpaRepository<Location, UUID> {

    Location findLocationByLocationid(UUID locationid);
}
