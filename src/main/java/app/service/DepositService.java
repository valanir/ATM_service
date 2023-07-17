package app.service;

import app.facade.GeneralFacade;
import app.model.DepositModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class DepositService extends GeneralService<DepositModel> {
}
