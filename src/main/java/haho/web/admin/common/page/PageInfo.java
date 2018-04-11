package haho.web.admin.common.page;

public class PageInfo {
    /** 总页数 */
    private int pageSize = 10;

    /** 总行数 */
    private int totalRows = 0;

    /** 当前页 */
    private int currentPage = 1;

    protected int pageStartRow = 0; // 每页的起始行数

    protected int pageEndRow = 0; // 每页显示数据的终止行数

    protected int totalPages = 0; // 总页数



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

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 初始化分页参数:需要先设置totalRows
     */

    public void init(int rows) {
        this.totalRows = rows;
        if ((totalRows % this.pageSize) == 0) {
            totalRows = totalRows / this.pageSize;
        } else {
            totalRows = totalRows / this.pageSize + 1;
        }
        calculatePage();
    }

    /**
     * 计算当前页的取值范围：pageStartRow和pageEndRow
     */
    public void calculatePage() {
        if (currentPage * pageSize < totalRows) { // 判断是否为最后一页
            pageEndRow = currentPage * pageSize;
            pageStartRow = pageEndRow - pageSize;
        } else {
            pageEndRow = totalRows;
            pageStartRow = pageSize * (totalPages - 1) < 0 ? 0 : pageSize * (totalPages - 1);
        }
    }

    /**
     * 直接跳转到指定页数的页面
     * 
     * @param page
     */
    public void gotoPage(int page) {
        if (this.currentPage > this.totalPages && this.currentPage > 1) {
            currentPage = Math.max(1, this.totalPages); // 当前页最小为1
        } else {
            currentPage = Math.max(1, page); // 当前页最小为1
        }
        calculatePage();
    }

    @Override
    public String toString() {
        return "PageInfo [pageSize=" + pageSize + ", totalRows=" + totalRows + ", currentPage=" + currentPage + "]";
    }
}
