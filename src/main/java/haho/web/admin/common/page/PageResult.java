package haho.web.admin.common.page;

public class PageResult<T> {
    /** 分页数据 */
    private PageInfo page;

    /** 分页结果 */
    private T result;

    private PageResult() {}

    public static <T> PageResult<T> build() {
        return new PageResult<>();
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PageResult [page=" + page + ", result=" + result + "]";
    }
}
