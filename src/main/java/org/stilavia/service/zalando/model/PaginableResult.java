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
import java.util.Iterator;
import java.util.List;

/**
 * Created by guillermoblascojimenez on 16/06/15.
 */
public class PaginableResult<E> implements Iterable<E>, Serializable {

    private static final long serialVersionUID = 42L;

    private List<E> content;
    private int totalElements;
    private int totalPages;
    private int page;
    private int size;

    public List<E> getContent() {
        return content;
    }

    public void setContent(List<E> content) {
        this.content = content;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Iterator<E> iterator() {
        return content.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaginableResult<?> that = (PaginableResult<?>) o;

        if (totalElements != that.totalElements) return false;
        if (totalPages != that.totalPages) return false;
        if (page != that.page) return false;
        if (size != that.size) return false;
        return !(content != null ? !content.equals(that.content) : that.content != null);

    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + totalElements;
        result = 31 * result + totalPages;
        result = 31 * result + page;
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaginableResult{");
        sb.append("content=").append(content);
        sb.append(", totalElements=").append(totalElements);
        sb.append(", totalPages=").append(totalPages);
        sb.append(", page=").append(page);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}
