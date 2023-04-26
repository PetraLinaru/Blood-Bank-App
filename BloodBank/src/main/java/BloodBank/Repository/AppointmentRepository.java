package BloodBank.Repository;

import BloodBank.model.Appointment;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
     List<Appointment> findAppointmentsByDate(Date date);

     @Query(value="SELECT * from appointment a  WHERE MONTH(a.date)=MONTH( :month) AND YEAR(a.date)=YEAR(:year) AND a.docid=(:uuid)",nativeQuery = true)
     Page<Appointment> getMonthAppointments(@Param("month")Date date, @Param("year")Date date2, @Param("uuid") UUID uuid, @Param("") Pageable pageable);
}