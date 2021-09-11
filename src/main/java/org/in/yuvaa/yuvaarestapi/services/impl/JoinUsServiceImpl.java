package org.in.yuvaa.yuvaarestapi.services.impl;

import org.in.yuvaa.yuvaarestapi.entity.joinus.JoinUsEntity;
import org.in.yuvaa.yuvaarestapi.repository.joinus.JoinUsRepository;
import org.in.yuvaa.yuvaarestapi.services.JoinUsService;
import org.in.yuvaa.yuvaarestapi.shared.dto.joinus.JoinUsDto;
import org.in.yuvaa.yuvaarestapi.shared.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoinUsServiceImpl implements JoinUsService {

    @Autowired
    JoinUsRepository joinUsRepository;

    @Autowired
    Utils utils;

    @Override
    public JoinUsDto saveMember(JoinUsDto joinUs) {

        JoinUsDto returnValue = new JoinUsDto();

        String publicId = utils.randomPublicId(30);

        ModelMapper modelMapper = new ModelMapper();
        JoinUsEntity joinUsEntity = modelMapper.map(joinUs, JoinUsEntity.class);
        joinUsEntity.setJoinId(publicId);
        joinUsEntity.setSelected(false);

        JoinUsEntity save = joinUsRepository.save(joinUsEntity);

        returnValue = modelMapper.map(save, JoinUsDto.class);

        return returnValue;
    }

    @Override
    public List<JoinUsDto> getMember(String filter) {

        List<JoinUsEntity> members = new ArrayList<JoinUsEntity>();

        if (filter.equals("ALL")) {
            members = (List<JoinUsEntity>) joinUsRepository.findAll();
        }else if (filter.equals("Selected")){
            members = joinUsRepository.getSelectedMembers();
        }else if (filter.equals("Rejected")){
            members = joinUsRepository.getRejectedMembers();
        }else{
            return null;
        }

//        members = (List<JoinUsEntity>) joinUsRepository.findAll();


        ModelMapper modelMapper = new ModelMapper();

        List<JoinUsDto> returnValue = new ArrayList<JoinUsDto>();

        for (JoinUsEntity joinUsEntity : members) {
            returnValue.add(modelMapper.map(joinUsEntity, JoinUsDto.class));
        }

        return returnValue;
    }

    @Override
    public JoinUsDto selectMembers(String joinId) {

        JoinUsDto returnValue = new JoinUsDto();

        ModelMapper modelMapper = new ModelMapper();
        JoinUsEntity memberDetails = joinUsRepository.findByJoinId(joinId);
        memberDetails.setSelected(true);
        JoinUsEntity save = joinUsRepository.save(memberDetails);

        returnValue = modelMapper.map(save, JoinUsDto.class);

        return returnValue;
    }

    @Override
    public List<JoinUsDto> getAllMembers() {
        List<JoinUsEntity> allMembers = (List<JoinUsEntity>) joinUsRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<JoinUsDto> returnValue = new ArrayList<JoinUsDto>();
        for(JoinUsEntity joinUsEntity : allMembers) {
            returnValue.add(modelMapper.map(joinUsEntity, JoinUsDto.class));
        }

        return returnValue;
    }
}
