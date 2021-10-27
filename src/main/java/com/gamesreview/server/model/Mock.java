package com.gamesreview.server.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Mock {
    @Id private Long id;
    @Column private String example;
}
