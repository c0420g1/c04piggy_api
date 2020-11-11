package com.example.demo.service;

import com.example.demo.model.PigAssociateStatus;

import java.util.List;

public interface PigAssociateStatusService extends BaseService<PigAssociateStatus> {
    List<PigAssociateStatus> getAllByPigId(int pigId);
}
