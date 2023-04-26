package BloodBank.model;

import jakarta.persistence.*;
import org.aspectj.lang.annotation.control.CodeGenerationHint;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name="appointment")

public class Appointment {
    @JoinColumns({
            @JoinColumn(name="docid",referencedColumnName = "uuid"),
            @JoinColumn(name="donorid",referencedColumnName = "uuid"),
            @JoinColumn(name="locationid",referencedColumnName = "locationid")
    })

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;


    UUID docid;


    UUID locationid;
    UUID donorid;
    Date date;

    public Appointment(UUID id, UUID docid, UUID locationid, UUID donorid, Date date) {
        this.id = id;
        this.docid = docid;
        this.locationid = locationid;
        this.donorid = donorid;
        this.date = date;
    }

    public Appointment() {

    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getDocid() {
        return docid;
    }

    public void setDocid(UUID docid) {
        this.docid = docid;
    }

    public UUID getLocationid() {
        return locationid;
    }

    public void setLocationid(UUID locationid) {
        this.locationid = locationid;
    }

    public UUID getDonorid() {
        return donorid;
    }

    public void setDonorid(UUID donorid) {
        this.donorid = donorid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
