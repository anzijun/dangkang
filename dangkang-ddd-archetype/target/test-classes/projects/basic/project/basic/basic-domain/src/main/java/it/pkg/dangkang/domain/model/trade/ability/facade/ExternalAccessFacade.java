package it.pkg.dangkang.domain.model.trade.ability.facade;

import it.pkg.dangkang.domain.model.trade.type.CallRequestDto;
import it.pkg.dangkang.domain.model.trade.type.CallResult;
import it.pkg.dangkang.domain.model.trade.type.QueryRequestDto;
import it.pkg.dangkang.domain.model.trade.type.QueryResult;

/**
 * @date 2022/12/23 10:23
 */
public interface ExternalAccessFacade {

    String ERR_CALL_RETURN_UNKNOWN_CODE = "R001";
    String ERR_CALL_RETURN_UNKNOWN_MESSAGE = "call方法执行结果未知";

    CallResult call(CallRequestDto callRequestDto);

    QueryResult query(QueryRequestDto queryRequestDto);
}
