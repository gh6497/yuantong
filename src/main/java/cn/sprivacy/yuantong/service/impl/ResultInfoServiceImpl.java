package cn.sprivacy.yuantong.service.impl;

import cn.sprivacy.yuantong.domain.AppResultInfo;
import cn.sprivacy.yuantong.repository.AppResultInfoRepo;
import cn.sprivacy.yuantong.service.ResultInfoService;
import cn.sprivacy.yuantong.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author cailun
 * @date 2018年 07月31日
 */
@Service
public class ResultInfoServiceImpl implements ResultInfoService {
    private final AppResultInfoRepo appResultInfoRepo;

    @Autowired
    public ResultInfoServiceImpl(AppResultInfoRepo appResultInfoRepo) {
        this.appResultInfoRepo = appResultInfoRepo;
    }

    @Override
    public PageResult<AppResultInfo> page(Integer currentPage, Integer pageSize) {
//        Pageable pageable = new PageRequest(pageNumber, pageSize);  //分页信息
        final PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize);
        final Page<AppResultInfo> all = appResultInfoRepo.findAll(pageRequest);/*　Specification<TestVO> spec = new Specification<TestVO>() {        //查询条件构造

　　　　　　

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
        PageResult<AppResultInfo> result = new PageResult<>();
        return result.setTotal(all.getTotalElements()).setData(all.getContent()).setTotalPage(all.getTotalPages());
    }
}
