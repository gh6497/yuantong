package cn.sprivacy.yuantong.repository;

import cn.sprivacy.yuantong.domain.AppInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
public interface AppInfoRepo extends JpaSpecificationExecutor<AppInfoRepo>,JpaRepository<AppInfo,Integer> {
}
