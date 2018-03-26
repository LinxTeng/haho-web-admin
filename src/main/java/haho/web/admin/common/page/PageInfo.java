package haho.web.admin.common.page;

public class PageInfo {
    /** 总页数 */
    private int pageSize = 0;

    /** 总行数 */
    private int totalRows = 0;

    /** 当前页 */
    private int currentPage = 1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageInfo [pageSize=" + pageSize + ", totalRows=" + totalRows + ", currentPage=" + currentPage + "]";
    }
}
