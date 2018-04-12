package haho.web.admin.common.page;

import java.util.List;

public class TableResult<T> {
    private Integer draw = 2;
    private Integer recordsTotal = 3;
    private Integer recordsFiltered = 4;
    /** 分页结果 */
    private List<T> data;

    private TableResult() {}

    public static <T> TableResult<T> build() {
        return new TableResult<>();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
