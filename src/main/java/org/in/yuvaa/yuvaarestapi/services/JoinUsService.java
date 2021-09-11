package org.in.yuvaa.yuvaarestapi.services;

import org.in.yuvaa.yuvaarestapi.shared.dto.joinus.JoinUsDto;

import java.util.List;

public interface JoinUsService {

    JoinUsDto saveMember(JoinUsDto joinUs);
    List<JoinUsDto> getMember(String filter);
    JoinUsDto selectMembers(String joinId);
    List<JoinUsDto> getAllMembers();
}
