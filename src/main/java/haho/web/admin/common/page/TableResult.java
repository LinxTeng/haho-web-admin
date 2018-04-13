package haho.web.admin.common.page;

import java.io.Serializable;
import java.util.List;

public class TableResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer draw = 1;
    private Integer recordsTotal = 0;
    private Integer recordsFiltered = 0;
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

    @Override
    public String toString() {
        return "TableResult [draw=" + draw + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered + ", data=" + data + "]";
    }
}
