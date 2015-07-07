/*
 * Copyright (c) 2015 Stilavia
 */

package org.stilavia.service.zalando.model;

import java.util.List;

/**
 * Created by guillermoblascojimenez on 04/07/15.
 */
public class Attribute {

    private String name;
    private List<String> values;

    public Attribute() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
