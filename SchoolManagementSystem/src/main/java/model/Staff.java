package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Staff {

    @Id
    @SequenceGenerator(name = "Stid", allocationSize = 20, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Stid")
    private int id;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",  nullable = false)
    private UserDetails user;
}
