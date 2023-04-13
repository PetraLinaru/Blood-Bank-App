package BloodBank.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

public enum Role {
        ADMIN,DOCTOR,DONOR;

}
