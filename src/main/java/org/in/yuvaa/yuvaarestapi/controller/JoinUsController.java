package org.in.yuvaa.yuvaarestapi.controller;

import org.apache.poi.util.IOUtils;
import org.in.yuvaa.yuvaarestapi.model.request.joinus.JoinUsRequestModel;
import org.in.yuvaa.yuvaarestapi.model.response.joinus.JoinUsResponseModel;
import org.in.yuvaa.yuvaarestapi.services.JoinUsService;
import org.in.yuvaa.yuvaarestapi.shared.dto.joinus.JoinUsDto;
import org.in.yuvaa.yuvaarestapi.shared.utils.MemberExcelExport;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/joinus")
public class JoinUsController {

    @Autowired
    JoinUsService joinUsService;

    // api endpoint to register new user
    // public end point
    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody JoinUsRequestModel joinUsRequestModel){

        ModelMapper mapper = new ModelMapper();

        JoinUsDto joinUs = mapper.map(joinUsRequestModel, JoinUsDto.class);

        joinUsService.saveMember(joinUs);

        return ResponseEntity.ok("Form submitted successfully, You will hear from us soon!");
    }

    // endpoint to get all the registered member/selected/rejected
    // secured endpoint
    @GetMapping("/{filter}")
    public List<JoinUsResponseModel> getAllRegisteredUsers(@PathVariable String filter){

        System.out.println(filter);
        System.out.println(filter.equals("ALL"));
        System.out.println(filter == "ALL");

        ModelMapper modelMapper = new ModelMapper();

        List<JoinUsDto> member = joinUsService.getMember(filter);


        List<JoinUsResponseModel> returnValues = new ArrayList<JoinUsResponseModel>();
        for (JoinUsDto joinUs : member) {
            returnValues.add(modelMapper.map(joinUs, JoinUsResponseModel.class));
        }

        return returnValues;
    }

    //end point to select the members
    //restricted end point
    @PostMapping("/select/{publicId}")
    public ResponseEntity<String> selectMembers(@PathVariable String publicId){

        joinUsService.selectMembers(publicId);

        return ResponseEntity.ok("The member have been added successfully");

    }

    // export excel file of member details
    @GetMapping("/memberDetails")
    public void downloadMemberDetails(HttpServletResponse response) throws IOException {

        List<JoinUsDto> allMembers = joinUsService.getAllMembers();
        ByteArrayInputStream byteArrayInputStream = MemberExcelExport.memberListToExcelSheet(allMembers);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=Members.xlsx");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());

    }


}
