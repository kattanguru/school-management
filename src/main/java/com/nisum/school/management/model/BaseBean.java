package com.nisum.school.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class BaseBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 10000001L;

    @Id
    private Long id;
}
