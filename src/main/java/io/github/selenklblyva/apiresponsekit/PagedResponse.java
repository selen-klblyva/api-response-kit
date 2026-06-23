package io.github.selenklblyva.apiresponsekit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse<T> {
    private long totalElements;
    private int totalPages;
    private int pageNumber;
    private int pageSize;
    private boolean lastPage;
    private boolean firstPage;
    private List<T> data;
}
