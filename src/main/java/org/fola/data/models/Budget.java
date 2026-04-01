package org.fola.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Budget {
    @Id
    private String id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Income> inflows;
    private List<Expense> outflows;
    private LocalDateTime createdAt = LocalDateTime.now();
}
