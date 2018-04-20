package com.wyx.tms.service;

import com.wyx.tms.entity.Pos;

import java.util.List;

/**
 * 添加销售点的业务类
 */
public interface PosService {


    /**
     * 查询所有销售点
     * @return
     */
    List<Pos> selectPos();

    /**
     * 新增销售点
     * @param pos
     */
    void index(Pos pos);

    /**
     * 根据ID查询销售点
     * @param id
     * @return
     */
    Pos selectById(Integer id);

    /**
     * 修改销售点信息
     * @param pos
     */
    void update(Pos pos);

    /**
     * 删除销售点
     * @param id
     */
    void deleteById(Integer id);
}
