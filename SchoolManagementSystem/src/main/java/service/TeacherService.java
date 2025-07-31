package service;

import model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.*;

@Service
public class TeacherService {

    @Autowired
    ExamRepo ex;
    @Autowired
    ProfileRepo pro;
    @Autowired
    StaffRepo Str;
    @Autowired
    StudentRepo sr;
    @Autowired
    TeacherRepo tr;
    @Autowired
    UserDetailsRepo udr;







}
