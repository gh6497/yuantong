package cn.sprivacy.yuantong.repository;

import cn.sprivacy.yuantong.domain.AppResultInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author cailun
 * @date 2018年 07月31日
 */
public interface AppResultInfoRepo extends JpaSpecificationExecutor<AppResultInfo>,JpaRepository<AppResultInfo,Integer> {
}
