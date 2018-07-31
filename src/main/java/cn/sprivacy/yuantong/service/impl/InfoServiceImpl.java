package cn.sprivacy.yuantong.service.impl;

import cn.sprivacy.yuantong.condition.InfoCondition;
import cn.sprivacy.yuantong.domain.AppInfo;
import cn.sprivacy.yuantong.repository.AppInfoRepo;
import cn.sprivacy.yuantong.service.InfoService;
import cn.sprivacy.yuantong.util.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@Service
public class InfoServiceImpl implements InfoService {
    private final AppInfoRepo appInfoRepo;

    @Autowired
    public InfoServiceImpl(AppInfoRepo appInfoRepo) {
        this.appInfoRepo = appInfoRepo;
    }

    @Override
    public PageResult<AppInfo> page(Integer currentPage, Integer pageSize, InfoCondition infoCondition) {
//        Pageable pageable = new PageRequest(pageNumber, pageSize);  //分页信息
        final PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize);
        final Specification<AppInfo> spc = (root, query, criteria) ->{
            List<Predicate> predicates = new ArrayList<>(0);
            if (StringUtils.isNotBlank(infoCondition.getName())) {
                predicates.add(criteria.equal(root.get("name"), infoCondition.getName()));

            }
            if (null != infoCondition.getDeadline()) {
                predicates.add(criteria.equal(root.get("deadline"), infoCondition.getDeadline()));

            }
            if (null != infoCondition.getSex()) {
                predicates.add(criteria.equal(root.get("sex"), infoCondition.getSex()));
            }
            if (null != infoCondition.getUtype()) {
                predicates.add(criteria.equal(root.get("utype"), infoCondition.getUtype()));
            }
            return query.where(predicates.toArray(new Predicate[0])).getRestriction();
        };
        System.out.println(appInfoRepo);
        final Page<AppInfo> all = appInfoRepo.findAll(spc, pageRequest);
        PageResult<AppInfo> result = new PageResult<>();
        return result.setTotal(all.getTotalElements()).setData(all.getContent()).setTotalPage(all.getTotalPages());
    }
}
