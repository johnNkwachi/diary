package models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Entry {
    @Id
    private Long id;
    private String title;
    private String body;
//    private DateTimeFormat dateTimeFormat;

}
