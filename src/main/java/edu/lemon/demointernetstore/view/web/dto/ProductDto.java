package edu.lemon.demointernetstore.view.web.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDto(String id, String name, String description, Integer quantity, BigDecimal price) {}
