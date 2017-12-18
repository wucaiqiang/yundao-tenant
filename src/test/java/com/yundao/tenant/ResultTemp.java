package com.yundao.tenant;

import java.util.List;

/**
 * Created by gjl on 2017/11/6.
 */
public class ResultTemp {
    private List<Content> content;
    private boolean last;

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
