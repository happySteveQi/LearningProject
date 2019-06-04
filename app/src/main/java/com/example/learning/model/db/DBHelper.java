package com.example.learning.model.db;

public interface DBHelper {
    /**
     * 插入 阅读记录
     * @param id
     */
    void insertNewsId(int id);

    /**
     * 查询阅读记录
     * @param id
     * @return
     */
    boolean queryNewsId(int id);
}
