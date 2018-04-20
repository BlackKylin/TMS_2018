package com.wyx.tms.service.impl;

import com.wyx.tms.entity.Pos;
import com.wyx.tms.entity.PosExample;
import com.wyx.tms.mapper.PosMapper;
import com.wyx.tms.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 销售点的业务实现类
 */
@Service
public class PosServiceImpl implements PosService {

    @Autowired
    private PosMapper posMapper;


    /**
     * 查询所有销售点
     *
     * @return
     */
    @Override
    public List<Pos> selectPos() {

        PosExample posExample = new PosExample();

        return posMapper.selectByExample(posExample);
    }

    /**
     * 新增销售点
     *
     * @param pos
     */
    @Override
    public void index(Pos pos) {
        //添加创建时间
        pos.setObsoleteTime(new Date());

        posMapper.insertSelective(pos);
    }

    /**
     * 根据ID查询销售点
     *
     * @param id
     * @return
     */
    @Override
    public Pos selectById(Integer id) {

        Pos pos= posMapper.selectByPrimaryKey(id);

        return pos;
    }

    /**
     * 修改销售点信息
     *
     * @param pos
     */
    @Override
    public void update(Pos pos) {
        posMapper.updateByPrimaryKey(pos);
    }

    /**
     * 删除销售点
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        posMapper.deleteByPrimaryKey(id);
    }
}
