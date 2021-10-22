package com.gamesreview.server.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "mock", schema = "gamesreview")
public class MockModel {
    @Id private Long id;
    @Column private String example;
}
