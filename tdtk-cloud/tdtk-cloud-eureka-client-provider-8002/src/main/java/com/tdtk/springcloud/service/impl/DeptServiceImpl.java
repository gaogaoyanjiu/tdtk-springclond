package com.tdtk.springcloud.service.impl;

import com.tdtk.springcloud.dao.DeptDao;
import com.tdtk.springcloud.entities.Dept;
import com.tdtk.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService{


//    关于@Resource和@Autowired：
//    两者都可以写在字段和setter方法上。两者如果都写在字段上，那么就不需要再写setter方法。
//    @Autowired默认按类型装配（这个注解属于spring的），默认情况下必须要求依赖对象必须存在，如果要允许null值，可以设置它的required属性为false，如：@Autowired(required=false)
//    @Resource默认安装名称进行装配（这个注解属于J2EE的），名称可以通过name属性进行指定，如果没有指定name属性，当注解写在字段上时，默认取字段名进行安装名称查找。
//    在我个人推荐用@Resource，因为这个注解是属于J2EE的，减少了与spring的耦合，并且代码看起更优雅。若有高见，欢迎指教。

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept)
    {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id)
    {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list()
    {
        return deptDao.findAll();
    }

}