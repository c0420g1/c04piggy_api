package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SelectedEmployee {
    private int id;
    private String itemName;
}
