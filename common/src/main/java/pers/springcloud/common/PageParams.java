package pers.springcloud.common;

/**
 * 分页参数
 */
public class PageParams {
    /**
     * 查询记录条数
     */
    private Integer pageSize;
    /**
     * 当前页码数
     */
    private Integer currentPage;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
