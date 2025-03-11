package gr.aueb.cf.schoolapp.mapper;

import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;
import gr.aueb.cf.schoolapp.model.Teacher;

import java.util.Optional;

public class Mapper {

    /**
     * No instance of this class should be available.
     */
    private Mapper(){}

    public static Teacher mapTeacherInsertToModel(TeacherInsertDTO dto) {
        return new Teacher(null, dto.getFirstname(), dto.getLastname(), dto.getVat(),
                                    dto.getFathername(), dto.getPhoneNum(), dto.getEmail(),
                                    dto.getStreet(), dto.getStreetNum(), dto.getZipcode(),
                                    dto.getCityId(), null, null, null);
    }

    public static Teacher mapTeacherUpdateToModel(TeacherUpdateDTO dto) {
        return new Teacher(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getVat(),
                dto.getFathername(), dto.getPhoneNum(), dto.getEmail(),
                dto.getStreet(), dto.getStreetNum(), dto.getZipcode(),
                dto.getCityId(), null, null, null);
    }

    public static Optional<TeacherReadOnlyDTO> mapTeacherToReadOnlyDTO(Teacher teacher) {  // δεφέρνει nulls
        if (teacher == null) return Optional.empty();
        return Optional.of(new TeacherReadOnlyDTO(teacher.getId(), teacher.getUuid(), teacher.getFirstname(),
                            teacher.getLastname(), teacher.getVat(), teacher.getFathername(), teacher.getPhoneNum(),
                            teacher.getEmail(), teacher.getStreet(), teacher.getStreetNum(), teacher.getZipCode(), teacher.getCityId()));
    }
}
