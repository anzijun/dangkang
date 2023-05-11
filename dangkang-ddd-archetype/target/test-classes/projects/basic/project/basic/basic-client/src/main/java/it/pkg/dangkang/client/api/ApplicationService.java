package it.pkg.dangkang.client.api;

import it.pkg.dangkang.client.dto.ApplicationServiceDTO;
import it.pkg.dangkang.client.dto.result.ApplicationServiceResult;

/**
 * 应用服务
 */
public interface ApplicationService {
    String TRADE_CODE ="T001";
    String TRADE_DESCRIPTION ="dangkang-ddd应用服务描述信息";

    ApplicationServiceResult execute(ApplicationServiceDTO applicationServiceDTO);

}
