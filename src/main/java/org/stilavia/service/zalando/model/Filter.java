/*
 * Copyright 2015 Stilavia S.L.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.stilavia.service.zalando.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guillermoblascojimenez on 16/06/15.
 */
public class Filter implements Serializable {

    private static final long serialVersionUID = 42L;

    public enum Type {
        STRING,
        ENUM,
        RANGE,
        KEY,
        SKU
    }

    private String name;
    private boolean multiValue;
    private Type type;
    private List<FilterValue> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMultiValue() {
        return multiValue;
    }

    public void setMultiValue(boolean multiValue) {
        this.multiValue = multiValue;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<FilterValue> getValues() {
        return values;
    }

    public void setValues(List<FilterValue> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filter filter = (Filter) o;

        if (multiValue != filter.multiValue) return false;
        if (name != null ? !name.equals(filter.name) : filter.name != null) return false;
        if (type != filter.type) return false;
        return !(values != null ? !values.equals(filter.values) : filter.values != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (multiValue ? 1 : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (values != null ? values.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Filter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", multiValue=").append(multiValue);
        sb.append(", type=").append(type);
        sb.append(", values=").append(values);
        sb.append('}');
        return sb.toString();
    }
}
