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
public class Category implements Serializable {

    private static final long serialVersionUID = 42L;

    private String key;
    private String name;
    private String parentKey;
    private List<String> childKeys;
    private String type;
    private boolean outlet;
    private boolean hidden;
    private String targetGroup;
    private List<String> suggestedFilters;

    public List<String> getSuggestedFilters() {
        return suggestedFilters;
    }

    public void setSuggestedFilters(List<String> suggestedFilters) {
        this.suggestedFilters = suggestedFilters;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public List<String> getChildKeys() {
        return childKeys;
    }

    public void setChildKeys(List<String> childKeys) {
        this.childKeys = childKeys;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOutlet() {
        return outlet;
    }

    public void setOutlet(boolean outlet) {
        this.outlet = outlet;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (outlet != category.outlet) return false;
        if (hidden != category.hidden) return false;
        if (key != null ? !key.equals(category.key) : category.key != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        if (parentKey != null ? !parentKey.equals(category.parentKey) : category.parentKey != null) return false;
        if (childKeys != null ? !childKeys.equals(category.childKeys) : category.childKeys != null) return false;
        if (type != null ? !type.equals(category.type) : category.type != null) return false;
        if (targetGroup != null ? !targetGroup.equals(category.targetGroup) : category.targetGroup != null)
            return false;
        return !(suggestedFilters != null ? !suggestedFilters.equals(category.suggestedFilters) : category.suggestedFilters != null);

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentKey != null ? parentKey.hashCode() : 0);
        result = 31 * result + (childKeys != null ? childKeys.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (outlet ? 1 : 0);
        result = 31 * result + (hidden ? 1 : 0);
        result = 31 * result + (targetGroup != null ? targetGroup.hashCode() : 0);
        result = 31 * result + (suggestedFilters != null ? suggestedFilters.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Category{");
        sb.append("key='").append(key).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", parentKey='").append(parentKey).append('\'');
        sb.append(", childKeys=").append(childKeys);
        sb.append(", type='").append(type).append('\'');
        sb.append(", outlet=").append(outlet);
        sb.append(", hidden=").append(hidden);
        sb.append(", targetGroup='").append(targetGroup).append('\'');
        sb.append(", suggestedFilters=").append(suggestedFilters);
        sb.append('}');
        return sb.toString();
    }
}
