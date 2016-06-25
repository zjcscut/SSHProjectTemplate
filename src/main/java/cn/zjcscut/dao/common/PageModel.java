package cn.zjcscut.dao.common;


import java.util.List;

/**
 * 分页模型
 *
 * @param <T>
 * @author zjcscut
 */
public class PageModel<T> {

    private static final Integer DEFAULT_PAGE_SIZE = 20; //默认每页记录数


    private List<T> result;

    private int maxPage;

    private int dataCount;

    private int currentPage;

    private int numPerPage;

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public PageModel() {
        super();
    }

    /**
     * @param result      结果列表
     * @param dataCount   总记录数量
     * @param currentPage 当前页号
     * @param numPerPage  每页记录数
     */
    public PageModel(List<T> result, int dataCount, int currentPage, int numPerPage) {
        super();
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (numPerPage <= 0) {
            numPerPage = DEFAULT_PAGE_SIZE;
        }
        this.result = result;
        this.maxPage = maxPageSize(dataCount, numPerPage);
        this.dataCount = dataCount;
        this.currentPage = currentPage;
        this.numPerPage = numPerPage;
    }


    /**
     * 计算最大分页数
     *
     * @param count    记录总数
     * @param pageSize 每页显示多少数据
     * @return int
     */
    public int maxPageSize(int count, int pageSize) {
        if (pageSize > 0) {
            if ((count % pageSize) != 0) {
                return (count / pageSize) + 1;
            } else {
                return (count / pageSize);
            }
        }
        return 0;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

}
