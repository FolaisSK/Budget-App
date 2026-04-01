package org.fola.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Income {
    @Id
    private String id;
    private String source;
    private double amount;
}
