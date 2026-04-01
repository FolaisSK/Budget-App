package org.fola.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.fola.data.models.Expense;
import org.fola.data.models.Income;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateBudgetResponse {
    private String id;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private List<Income> inflows;
    private List<Expense> outflows;
    private LocalDateTime createdAt;
}
