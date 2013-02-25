package com.bilionix.widgetprocessor.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 */
@Entity
public class Widget {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Version
    @Column(columnDefinition="int4 default 0")
    private Integer version = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
