package edu.lemon.demointernetstore.view.web.dto;

import java.math.BigDecimal;

public record ProductDto(String name, String description, Integer quantity, BigDecimal price) {}
