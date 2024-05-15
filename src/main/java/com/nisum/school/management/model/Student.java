package com.nisum.school.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Document(collection = "student")
public class Student extends BaseBean {

    @Serial
    private static final long serialVersionUID = 20000001L;

    private String firstName;
    private String lastName;
    private String email;
    private String branch;
    @Indexed(unique = true)
    private String phoneNumber;

}
