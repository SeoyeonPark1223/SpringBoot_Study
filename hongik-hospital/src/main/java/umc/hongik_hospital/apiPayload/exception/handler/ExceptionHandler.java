package umc.hongik_hospital.apiPayload.exception.handler;

import umc.hongik_hospital.apiPayload.code.BaseErrorCode;
import umc.hongik_hospital.apiPayload.exception.GeneralException;

public class ExceptionHandler extends GeneralException {
    public ExceptionHandler(BaseErrorCode code) {
        super(code);
    }
}