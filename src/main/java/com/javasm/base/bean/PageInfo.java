package com.javasm.base.bean;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 存储分页相关的属性
 *
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/9/23-14:55
 * @Since：jdk1.8
 * @Description：
 */
@Getter
@ToString
public class PageInfo<T> {

    private Integer nowPage;// 当前页（页面传递到servlet中）
    private Integer pageSize;// 每页显示几条数据（页面传递到servlet中）
    private Integer startIndex;// 起始下标(计算)
    private Integer total;// 总条数（统计）
    private Integer sumPage;// 总页数(计算)

    private List<T> data;// 分页之后查询到的数据（userList）

    public void setData(List<T> data) {
        this.data = data;
    }

    public PageInfo(Integer nowPage, Integer pageSize, Integer total) {
        // 将页面传递的分页数据赋值给pageinfo
        this.nowPage = nowPage == null || nowPage < 1 ? 1 : nowPage;
        this.pageSize = pageSize == null || pageSize < 2 ? 2 : pageSize;

        this.total = total;
        //  计算 总页数
        this.sumPage = this.total % this.pageSize == 0 ? this.total / this.pageSize : this.total / this.pageSize + 1;

        // this.sumPage >= this.nowPage >= 1
        this.nowPage = this.nowPage > this.sumPage ? this.sumPage : this.nowPage;
        // 计算起始下标
        this.startIndex = (this.nowPage - 1) * this.pageSize < 0 ? 0 : (this.nowPage - 1) * this.pageSize;
    }


}
