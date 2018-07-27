package cn.sprivacy.yuantong.service.impl;

import cn.sprivacy.yuantong.domain.AppInfo;
import cn.sprivacy.yuantong.repository.AppInfoRepo;
import cn.sprivacy.yuantong.service.InfoService;
import cn.sprivacy.yuantong.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private AppInfoRepo appInfoRepo;

    @Override
    public PageResult<AppInfo> page(Integer pageNumber, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNumber, pageSize);  //分页信息

        final Page<AppInfo> all = appInfoRepo.findAll(pageable);/*　Specification<TestVO> spec = new Specification<TestVO>() {        //查询条件构造

　　　　　　

            @Override
            public Predicate toPredicate(Root<TestVO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

　　　　　　　　Path<String> name = root.get("name");

　　　　　　　　Path<Integer> age = root.get("age");

　　　　　　　　Predicate p1 = cb.like(name, "%" + param.getName() + "%");

　　　　　　　　Predicate p2 = cb.lt(age, param.getAge());

    　　　　　　　Predicate p = cb.and(p1, p2);

　　　　　　　　return p;

　　　　　　}

　　　　
        };*/
        PageResult<AppInfo> result = new PageResult<>();
        return result.setConut(all.getTotalElements()).setData(all.getContent()).setTotalPage(all.getTotalPages());
    }
}
